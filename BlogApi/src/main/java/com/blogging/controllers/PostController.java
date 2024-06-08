package com.blogging.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.entities.Post;
import com.blogging.payloads.ApiResponse;
import com.blogging.payloads.PostDto;
import com.blogging.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			                      @RequestBody PostDto postDto,
			                      @PathVariable Integer userId,
			                      @PathVariable Integer categoryId){
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		
		List<PostDto> postDtos = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postDtos,HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postsByCategory,HttpStatus.OK);
	}
	
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId){
		
		 PostDto postById = this.postService.getPostById(postId);
		
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(value= "pageNumber",defaultValue = "2",required = false)Integer pageNumber,
	                                                 @RequestParam(value= "pageSize",defaultValue = "5",required = false)Integer pageSize){
		
		List<PostDto> allPost = this.postService.getAllPost(pageNumber,pageSize);
		
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
	}
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<ApiResponse> deletePosts(@PathVariable Integer postId){
		
		this.postService.delete(postId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully...",true),HttpStatus.OK);
	
	}
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePosts(@RequestBody PostDto postDto,@PathVariable Integer postId){
		
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
}
