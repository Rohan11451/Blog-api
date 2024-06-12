package com.blogging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.entities.Comment;
import com.blogging.payloads.ApiResponse;
import com.blogging.payloads.CommentDto;
import com.blogging.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/comments/post/{postId}")
	public ResponseEntity<CommentDto> createCommnet(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		
		CommentDto writeComment = this.commentService.writeComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>(writeComment,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteCommnet(@PathVariable Integer commentId){
		
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Succesfully !!", true),HttpStatus.OK);
		
	}
	
	
	
	
}
