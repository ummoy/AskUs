package com.askus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.askus.dao.PostDAO;
import com.askus.model.Post;

public class PostServiceImpl implements PostService {

	private PostDAO postDAO;
	
	@Transactional
	public List<Post> showALLPost() {
		// TODO Auto-generated method stub
		return this.postDAO.showALLPost();
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	@Transactional
	public void addPost(Post p) {
		this.postDAO.addPost(p);
		
	}
	@Transactional
	public List<Post> getPostById(int post_id) {
		// TODO Auto-generated method stub
		return this.postDAO.getPostById(post_id);
	}
	@Transactional
	public List<Post> getSearchPost(String post_keywords) {
		// TODO Auto-generated method stub
		return this.postDAO.getSearchPost(post_keywords);
	}
	@Transactional
	public void updatePost(Post p) {
		// TODO Auto-generated method stub
		this.postDAO.updatePost(p);
	}
	@Transactional
	public List<Post> showTopPost() {
		// TODO Auto-generated method stub
		return this.postDAO.showTopPost();
	}
	@Transactional
	public List<Post> showUnanswerPost() {
		// TODO Auto-generated method stub
		return this.postDAO.showUnanswerPost();
	}
	@Transactional
	public List<Post> getPostByTags(String tags) {
		// TODO Auto-generated method stub
		return this.postDAO.getPostByTags(tags);
	}

}
