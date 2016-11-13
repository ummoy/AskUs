package com.askus.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.askus.dao.PersonDAO;
import com.askus.dao.UserDAO;
import com.askus.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	@Transactional
	public void addUser(User u) {
		userDAO.addUser(u);
		
	}
	@Transactional
	public void updateUser(User u) {
		userDAO.updateUser(u);
		
	}
	@Transactional
	public List<User> listuser() {
		return this.userDAO.listuser();
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Transactional
	public List<User> getUserByLogin(String user_name, String user_password) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserByLogin(user_name, user_password);
	}
	
	

}
