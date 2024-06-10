package com.event.event_management.services;

import java.util.List;

import com.event.event_management.module.User;

public interface UserServices {

	public User saveUser(User user);
	
	public List<User>userList();
	
	public void deleteById(int id);
	
	public User findById(int id);
	
	public User updateUser(User user); 
	
}
