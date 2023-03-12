package com.springrest.roommateapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.Userdto;

public interface UserDao extends JpaRepository<User, Long> {
	
	@Query(value = "select * from users u where u.email = ?1   and u.password=?2", nativeQuery = true)
	User getUserByEmailAndPass(String email, String password);
}
