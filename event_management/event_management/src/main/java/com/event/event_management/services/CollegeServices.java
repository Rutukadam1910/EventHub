package com.event.event_management.services;

import java.util.List;

import com.event.event_management.module.College;

public interface CollegeServices {

	public College saveCollege(College college);
	
	public List<College>collegeList();
	
	public void deleteById(int id);
	
	public College findById(int id);
	
	public College updateCollege(College college);
	
}
