package com.gis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.dto.PostDto;
import com.gis.entity.PostEntity;
import com.gis.repo.PostRepo;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean createPost(PostDto postDto) {
		PostEntity entity = new PostEntity();
		modelMapper.map(postDto, entity);
		postRepo.save(entity);
		return true;
	}

	@Override
	public boolean updatePost(PostDto postDto) {
		Optional<PostEntity> findById = postRepo.findById(postDto.getPostId());
		PostEntity entity = new PostEntity();
		entity.setPostId(postDto.getPostId());
		entity.setPostTitle(postDto.getPostTitle());
		entity.setDescription(postDto.getDescription());
		entity.setContent(postDto.getContent());
		modelMapper.map(postDto, entity);
		postRepo.save(entity);
		return true;

	}

	@Override
	public PostDto getPostById(Integer id) {
		PostEntity postEntity = postRepo.findById(id).get();
		PostDto dto = new PostDto();
		modelMapper.map(postEntity, dto);
		return dto;
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<PostEntity> listOfPosts = postRepo.findAll();
		List<PostDto> dto = new ArrayList<>();

		for (PostEntity post : listOfPosts) {
			PostDto postDto = new PostDto();
			modelMapper.map(post, postDto);
			dto.add(postDto);
		}
		return dto;
	}

	@Override
	public boolean deletePostById(Integer id) {
		postRepo.deleteById(id);
		return true;
	}

}
