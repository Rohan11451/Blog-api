package com.blogging.services;

import java.util.List;

import com.blogging.entities.Post;
import com.blogging.payloads.PostDto;
import com.blogging.payloads.PostResponse;

public interface PostService {

	//create post
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update posts
	public PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete posts
	public void delete(Integer postId);
	
	//get All posts
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	
	//get one posts
	public PostDto getPostById(Integer postId);
	
	//get all posts by user
	public List<PostDto> getPostByUser(Integer userId);
	
	//get post by category.
	public List<PostDto> getPostsByCategory(Integer categoryId);
	
	//search posts.
	public List<PostDto> searchPosts(String keyword);
	
	
	
	
}
