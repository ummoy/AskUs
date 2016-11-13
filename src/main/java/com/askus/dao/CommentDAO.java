package com.askus.dao;

import java.util.List;

import com.askus.model.Comment;

public interface CommentDAO {

	public void addComment(Comment c);
	public List<Comment> ShowComment(int parent_id);
}
