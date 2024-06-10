package com.event.event_management.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO.SEQUENCE)
	private int id;
	
	private String clgName;
	
	private String clgId;
	
	private String facultyname;
	
	private String email;
	
	private String mobile;
	
	private String username;
	
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClgName() {
		return clgName;
	}

	public void setClgName(String clgName) {
		this.clgName = clgName;
	}

	public String getClgId() {
		return clgId;
	}

	public void setClgId(String clgId) {
		this.clgId = clgId;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	public College(int id, String clgName, String clgId, String facultyname, String email, String mobile,
			String username, String password) {
		super();
		this.id = id;
		this.clgName = clgName;
		this.clgId = clgId;
		this.facultyname = facultyname;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
	}

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", clgName=" + clgName + ", clgId=" + clgId + ", facultyname=" + facultyname
				+ ", email=" + email + ", mobile=" + mobile + ", username=" + username + ", password=" + password + "]";
	}
	
	
	

}
