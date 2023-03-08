package com.springrest.roommateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.roommateapp.entities.Room;
import com.springrest.roommateapp.payloads.RoomDto;
import com.springrest.roommateapp.services.RoomService;

@RestController
@RequestMapping("/api/")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	//create
	@PostMapping("/user/{userId}/rooms")
	public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto, @PathVariable Long userId)
	{
		RoomDto createdRoom =  this.roomService.createRoom(roomDto, userId);
		return new ResponseEntity<RoomDto>(createdRoom,HttpStatus.CREATED);
	}
	
}
