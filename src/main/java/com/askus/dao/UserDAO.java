package com.askus.dao;

import java.util.List;

import com.askus.model.User;

public interface UserDAO {
	 public void addUser(User u);
	 public void updateUser(User u);
	 public List<User> listuser();
	 public List<User> getUserByLogin(String user_name,String User_password);
}
