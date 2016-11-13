package com.askus.service;

import java.util.List;

import com.askus.model.User;

public interface UserService {
	public void addUser(User u);
	public void updateUser(User u);
	public List<User> listuser();
	public List<User> getUserByLogin(String user_name,String user_password);
}
