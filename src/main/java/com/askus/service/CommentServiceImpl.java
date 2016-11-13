package com.askus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.askus.dao.CommentDAO;
import com.askus.model.Comment;

public class CommentServiceImpl implements CommentService {

	private CommentDAO commentDAO;
	@Transactional
	public void addComment(Comment c) {
		this.commentDAO.addComment(c);
		
	}
	@Transactional
	public List<Comment> ShowComment(int parent_id) {
		// TODO Auto-generated method stub
		return this.commentDAO.ShowComment(parent_id);
	}
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

}
