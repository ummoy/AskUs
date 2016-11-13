package com.askus.dao;

import java.util.List;

import com.askus.model.Post;

public interface PostDAO {
	public List<Post> showALLPost();
	public void addPost(Post p);
	public void updatePost(Post p);
	public List<Post> getPostById(int post_id);
	public List<Post> getSearchPost(String post_keywords);
	public List<Post> showTopPost();
	public List<Post> showUnanswerPost();
	public List<Post> getPostByTags(String tags);
}
