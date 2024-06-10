package com.event.event_management.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CollegeLogin {

	@Id
	private int id;
	
	private String username;
	
	private String password;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public CollegeLogin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public CollegeLogin() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CollegeLogin [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
