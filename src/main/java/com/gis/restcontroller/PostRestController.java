package com.gis.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.dto.PostDto;
import com.gis.service.PostService;

@RestController
public class PostRestController {
	@Autowired
	PostService postService;

	@PostMapping("/postSave")
	public ResponseEntity<String> createPost(@RequestBody PostDto postDto) {
		postService.createPost(postDto);
		return new ResponseEntity<String>("created successfully...", HttpStatus.CREATED);
	}

	@PutMapping("/updatePost")
	public ResponseEntity<String> updatePost(@RequestBody PostDto postDto) {
		postService.updatePost(postDto);
		return new ResponseEntity<String>("updates sucessfully...", HttpStatus.CREATED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer id) {
		PostDto postById = postService.getPostById(id);
		return new ResponseEntity<PostDto>(postById, HttpStatus.OK);
	}

	@GetMapping("/getAllPosts")
	public ResponseEntity<List<PostDto>> getAllPosts() {
		List<PostDto> allPosts = postService.getAllPosts();
		return new ResponseEntity<>(allPosts, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable Integer id) {
		postService.deletePostById(id);
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}

}
