package com.springrest.roommateapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/home")
	public String admin() {
		return "Admin/Home";
	}
	
	@GetMapping("/view-all-users")
	public String viewAllUsers() {
		return "Admin/admin-view-all-users";
	}

	@GetMapping("/view-a-user")
	public String viewAUser(@RequestParam("user_id") String itemId, Model model) {
		System.out.println(itemId);

		model.addAttribute("userId", itemId);
		return "Admin/admin-view-a-user";
	}

	@GetMapping("/view-all-rooms")
	public String viewAllRooms() {
		return "Admin/admin-view-all-rooms";
	}

	@GetMapping("/view-a-room")
	public String viewARoom(@RequestParam("room_id") String itemId, Model model) {
		System.out.println(itemId);

		model.addAttribute("roomId", itemId);
		return "Admin/admin-view-a-room";
	}
	
}
