package com.event.event_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.event_management.module.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
