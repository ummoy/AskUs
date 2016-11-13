package com.askus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.askus.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {

	private static final Logger logger = LoggerFactory.getLogger(CommentDAOImpl.class);
	private SessionFactory sessionFactory;
	public void addComment(Comment c) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(c);
        logger.info("Comment saved successfully, Comment Details="+c);
		
	}

	public List<Comment> ShowComment(int parent_id) {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Comment> commentList = session.createQuery("from Comment where parent_id="+parent_id).list();
        for(Comment c : commentList){
            logger.info("Comment List::"+c);
        }
        return commentList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
