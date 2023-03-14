package com.springrest.roommateapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springrest.roommateapp.dao.UserDao;
import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.ApiResponse;
import com.springrest.roommateapp.payloads.RoomDto;
import com.springrest.roommateapp.payloads.Userdto;
import com.springrest.roommateapp.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api")
public class MyController {

	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String home(Model model) {

		return "index";
	}

	@GetMapping("/view-all-users")
	public String viewAllUsers() {
		return "admin-view-all-users";
	}

	@GetMapping("/matches")
	public String viewAllMatches() {
		return "my-matches";
	}

	@GetMapping("/view-a-user")
	public String viewAUser(@RequestParam("user_id") String itemId, Model model) {
		System.out.println(itemId);

		model.addAttribute("userId", itemId);
		return "admin-view-a-user";
	}

	@GetMapping("/view-all-rooms")
	public String viewAllRooms() {
		return "admin-view-all-rooms";
	}

	@GetMapping("/view-a-room")
	public String viewARoom(@RequestParam("room_id") String itemId, Model model) {
		System.out.println(itemId);

		model.addAttribute("roomId", itemId);
		return "admin-view-a-room";
	}

	@ModelAttribute("user")
	public Userdto userDto() {
		return new Userdto();
	}

	@GetMapping("/registration")
	public String registration() {

		return "registration";
	}

	@PostMapping("/registration")
	public String addUser(@ModelAttribute("user") Userdto userDto) {
		userService.addUser(userDto);
		// session.setAttribute("message", "User registerd successfully!!");
		return "redirect:/api/registration?success";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String loginUser(ModelMap model, @RequestParam String email, @RequestParam String password,
			HttpSession session) {
		Userdto u = userService.getUserByEmailAndPass(email, password);
		if (u != null) {
			session.setAttribute("Userdto", u);
			System.out.println(session.getAttribute("Userdto"));
			return "redirect:/api/home";
		} else {
			session.setAttribute("msg", "Oops...Something went wrong..Try again....");
			return "redirect:/api/login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("Userdto");
		return "redirect:/api/login";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
		
	}

	// add new user
	// @PostMapping("/registration")
	// public ResponseEntity<Userdto> addUser(@Valid @RequestBody Userdto userDto)
	// {
	// Userdto addUserDto = this.userService.addUser(userDto);
	// return new ResponseEntity<>(addUserDto,HttpStatus.CREATED);
	// }

	// update existing user
	@PutMapping("/users/{userId}")
	public ResponseEntity<Userdto> updateUser(@Valid @RequestBody Userdto userDto,
			@PathVariable("userID") Long userId) {
		Userdto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	//
	//

	// deleting the existing user
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
		System.out.println("DELTED");
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);

	}
	//

	// get the list of users
	@GetMapping("/users")
	public ResponseEntity<List<Userdto>> getUsers() {
		return ResponseEntity.ok(this.userService.getUsers());
	}
	//
	//

	// get single user through id
	@GetMapping("/users/{userId}")
	public ResponseEntity<Userdto> getUser(@PathVariable Long userId) {
		return ResponseEntity.ok(this.userService.getUser(userId));
	}
	//

	@GetMapping("/users/{userId}/match-user")
	public ResponseEntity<List<Userdto>> getMatchingUsers(@PathVariable Long userId) {
		List<Userdto> user = this.userService.getMatchingUsers(userId);
		return ResponseEntity.ok(user);
	}
}
