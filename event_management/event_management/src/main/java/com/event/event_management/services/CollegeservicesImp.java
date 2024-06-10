package com.event.event_management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.event_management.dao.CollegeRepo;
import com.event.event_management.module.College;
@Service
public class CollegeservicesImp implements CollegeServices {

	@Autowired
	private CollegeRepo collegeRepo;
	@Override
	public College saveCollege(College college) {

		return collegeRepo.save(college);
	}

	@Override
	public List<College> collegeList() {
		List<College> findAll = collegeRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteById(int id) {
		
	}

	@Override
	public College findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public College updateCollege(College college) {
		// TODO Auto-generated method stub
		return null;
	}

}
