package com.springrest.roommateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.Userdto;
import com.springrest.roommateapp.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	// get single user through id
//		@GetMapping("/{userId}")
//		public ResponseEntity<Userdto> getUser(@PathVariable Long userId) {
//			return ResponseEntity.ok(this.userService.getUser(userId));
//		}
	
	@GetMapping("/home")
	public ModelAndView getHome(Authentication auth) {
		
		User user=userService.getUserByEmail(auth.getName());
		
		return new ModelAndView("User/home","user",user);
	}
}
