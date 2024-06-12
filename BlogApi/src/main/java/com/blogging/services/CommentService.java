package com.blogging.services;

import com.blogging.payloads.CommentDto;

public interface CommentService {

	
	public CommentDto writeComment(CommentDto commentDto,Integer postId);
	public void deleteComment(Integer commentId);
	
}
