package com.askus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.askus.model.Post;

@Repository
public class PostDAOImpl implements PostDAO {
	private static final Logger logger = LoggerFactory.getLogger(PostDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public List<Post> showALLPost() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Post> postList = session.createQuery("from Post order by post_id desc").list();
        for(Post p : postList){
            logger.info("Post List::"+p);
        }
        return postList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPost(Post p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Post saved successfully, Post Details="+p);
		
	}
	
	public void updatePost(Post p) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Post updated successfully, Post Details="+p);
		
	}
	
	public List<Post> getPostById(int post_id) {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Post> postList = session.createQuery("from Post where post_id="+post_id).list();
        for(Post p : postList){
            logger.info("Post List::"+p);
        }
        return postList;
	}

	public List<Post> getSearchPost(String post_keywords) {
		String s=post_keywords;
		String[] parts=s.split(" ");
		StringBuffer sb = new StringBuffer();
		for(String split : parts){
			//sb.append(split);
			sb.append("post_keywords like '%"+split+"%' OR ");
		}
		s=sb.substring(0, sb.length()-3).toString();
		System.out.println(s);
		//p.setPost_keywords(sb.toString());
		
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Post> postList = session.createQuery("from Post where "+s+" order by post_id desc").list();
        for(Post p : postList){
            logger.info("Post List::"+p);
        }
        return postList;
	}

	public List<Post> showTopPost() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Post> postList = session.createQuery("from Post order by post_views desc").list();
        for(Post p : postList){
            logger.info("Post List::"+p);
        }
        return postList;
	}

	public List<Post> showUnanswerPost() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Post> postList = session.createQuery("from Post where post_answers = 0").list();
        for(Post p : postList){
            logger.info("Post List::"+p);
        }
        return postList;
	}

	public List<Post> getPostByTags(String tags) {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked") 
		List<Post> postList = session.createQuery("from Post where post_keywords like '%"+tags+"%' order by post_id desc").list();
        for(Post p : postList){
            logger.info("Post List::"+p);
        }
        return postList;
	}

}
