package com.askus.service;

import java.util.List;

import com.askus.model.Comment;

public interface CommentService {

	public void addComment(Comment c);
	public List<Comment> ShowComment(int parent_id);
}
