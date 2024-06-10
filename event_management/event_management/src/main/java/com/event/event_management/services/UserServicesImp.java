package com.event.event_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.event_management.dao.UserRepo;
import com.event.event_management.module.User;

@Service
public class UserServicesImp implements UserServices {

	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public User saveUser(User user) {
		
		return userRepo.save(user);
	}


	@Override
	public List<User> userList() {
		List<User> findAll = userRepo.findAll();
		return findAll;
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
