package com.askus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.askus.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	 
    private SessionFactory sessionFactory;

	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
        logger.info("User saved successfully, User Details="+u);
		
	}

	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
        logger.info("User updated successfully, User Details="+u);
		
	}

	public List<User> listuser() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
        for(User u : userList){
            logger.info("User List::"+u);
        }
        return userList;
	}

	
	public List<User> getUserByLogin(String user_name,String user_password) {
		Session session = this.sessionFactory.getCurrentSession();      
		 @SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User where user_name='"+user_name+"' AND user_password='"+user_password+"'").list();
		 for(User u : userList){
	            logger.info("User List::"+u);
	        }
	        return userList;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}