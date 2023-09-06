package com.gis.service;

import java.util.List;

import com.gis.dto.PostDto;

public interface PostService {
	
	public boolean createPost(PostDto postDto);
	
	public  boolean updatePost(PostDto postDto);
	
	public PostDto getPostById(Integer id);
	
	public List<PostDto> getAllPosts();
	
	public boolean deletePostById(Integer id);

}
