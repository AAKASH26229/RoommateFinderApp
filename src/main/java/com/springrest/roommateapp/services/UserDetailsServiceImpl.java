package com.springrest.roommateapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springrest.roommateapp.dao.UserDao;
import com.springrest.roommateapp.entities.SecurityUser;
import com.springrest.roommateapp.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user=userDao.findByEmail(email);
		if(user == null)
			throw new UsernameNotFoundException("User not found with email" + email);
		
		return new SecurityUser(user);
	}
}
