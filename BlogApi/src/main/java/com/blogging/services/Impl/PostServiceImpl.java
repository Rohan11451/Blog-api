package com.blogging.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.entities.Category;
import com.blogging.entities.Post;
import com.blogging.entities.User;
import com.blogging.exceptions.ResourceNotFoundException;
import com.blogging.payloads.PostDto;
import com.blogging.repositories.CategoryRepo;
import com.blogging.repositories.PostRepo;
import com.blogging.repositories.UserRepo;
import com.blogging.services.PostService;


@Service
public class PostServiceImpl implements PostService {


	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user id",userId));
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id",categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post savePost = this.postRepo.save(post);
		
		return this.modelMapper.map(savePost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "post id", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		post.setCategory(post.getCategory());
		post.setUser(post.getUser());
		Post save = this.postRepo.save(post);
		
		return this.modelMapper.map(save, PostDto.class);
		
	}

	

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = this.postRepo.findAll();
		
		List<PostDto> collect = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	return collect;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user Id", userId));
		
		List<Post> posts = this.postRepo.findByUser(user);
		
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}
	
	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "category id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}


	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "post id", postId));
	
		this.postRepo.delete(post);
	}

	

	
}