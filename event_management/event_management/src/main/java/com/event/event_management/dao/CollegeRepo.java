package com.event.event_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.event_management.module.College;

public interface CollegeRepo extends JpaRepository<College, Integer>{

}
