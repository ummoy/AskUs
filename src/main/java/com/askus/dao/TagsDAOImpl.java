package com.askus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.askus.model.Post;
import com.askus.model.Tags;

@Repository
public class TagsDAOImpl implements TagsDAO {
	private static final Logger logger = LoggerFactory.getLogger(TagsDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addTags(Tags t) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(t);
        logger.info("Tag saved successfully, Tag Details="+t);
		
	}

	public List<Tags> showAllTags() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Tags> tagList = session.createQuery("from Tags").list();
        for(Tags t : tagList){
            logger.info("Tags List::"+t);
        }
        return tagList;
	}

	public List<Tags> checkTags(String tags_name) {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Tags> tagList = session.createQuery("from Tags where tags_name='"+tags_name+"'").list();
        for(Tags t : tagList){
            logger.info("Tags List::"+t);
        }
        return tagList;
	}

	public void updateTags(Tags t) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(t);
        logger.info("Tag update successfully, Tag Details="+t);
		
	}
	

}
