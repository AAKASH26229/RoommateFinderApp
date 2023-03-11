package com.springrest.roommateapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.ApiResponse;
import com.springrest.roommateapp.payloads.Userdto;
import com.springrest.roommateapp.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class MyController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home()
	{
		return "index";
	}

	@GetMapping("/registration")
	public String registration()
	{
		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addUser(@ModelAttribute Userdto user, HttpSession session )
	{
		userService.addUser(user);
		session.setAttribute("message", "User registerd successfully!!");
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	// add new user
//	@PostMapping("/registration")
//	public ResponseEntity<Userdto> addUser(@Valid @RequestBody Userdto userDto)
//	{
//			Userdto addUserDto = this.userService.addUser(userDto);
//			return new ResponseEntity<>(addUserDto,HttpStatus.CREATED);
//	}
	
//	
//		// update existing user
//		@PutMapping("/users/{userId}")
//		public ResponseEntity<Userdto> updateUser(@Valid @RequestBody Userdto userDto,@PathVariable("userID") Long userId)
//		{
//			Userdto updatedUser =  this.userService.updateUser(userDto,userId);
//			return ResponseEntity.ok(updatedUser);
//		}
//		
//		
//		
//		// deleting the existing user
//		@DeleteMapping("/users/{userId}")
//		public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId){
//				this.userService.deleteUser(userId);
//				return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true),HttpStatus.OK);
//			
//		}
//		
//		
//		// get the list of users
//		@GetMapping("/users")
//		public ResponseEntity<List<Userdto>> getUsers()
//		{ 
//			 return ResponseEntity.ok(this.userService.getUsers());
//		}
//		
//		
//		
//		// get single user through id
//		@GetMapping("/users/{userId}")
//		public ResponseEntity<Userdto> getUser(@PathVariable Long userId)
//		{
//			return ResponseEntity.ok(this.userService.getUser(userId));
//		}
//			
}
