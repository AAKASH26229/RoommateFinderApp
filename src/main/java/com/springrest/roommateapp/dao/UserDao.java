package com.springrest.roommateapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springrest.roommateapp.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
	
	
}
