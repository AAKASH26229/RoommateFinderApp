package com.springrest.roommateapp.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.Userdto;

public interface UserService {

	 Userdto addUser(Userdto userDto);
	 
	 Userdto updateUser(Userdto userDto,long userId);
	 
	 Userdto getUser(long userId);
	 
	 List<Userdto> getUsers();
	 
	 void deleteUser(long userId);
	 
	 public Userdto getUserByEmailAndPass(String email,String password);
	 
	 List<Userdto> findMatchingUsersByHighPreference( String diet, String role, String gender, String shift, String state);

	 public List<Userdto> getMatchingUsers(long userId);

}
