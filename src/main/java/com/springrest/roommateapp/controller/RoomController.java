package com.springrest.roommateapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.roommateapp.entities.Room;
import com.springrest.roommateapp.payloads.ApiResponse;
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
	
	
	// get by user
	@GetMapping("/user/{userId}/rooms")
	public ResponseEntity<List<RoomDto>> getRoomByUser(@PathVariable Long userId)
	{
		List<RoomDto> rooms = this.roomService.getRoomByUser(userId);
		return new ResponseEntity<List<RoomDto>>(rooms,HttpStatus.OK);
	}
	
	// get all rooms
	@GetMapping("/rooms")
	public ResponseEntity<List<RoomDto>> getAllRoom()
	{
		List<RoomDto> allRoom = this.roomService.getAllRoom();
		return new ResponseEntity<List<RoomDto>>(allRoom,HttpStatus.OK);
	}
	
	//Delete room
	@DeleteMapping("/rooms/{roomId}")
	public ApiResponse deleteRoom(@PathVariable Long roomId)
	{
		this.roomService.deleteRoom(roomId);
		return new ApiResponse("Room is successfully deleted.", true);
	}
	
	//update room
	@PutMapping("/rooms/{roomId}")
	public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto roomDto,@PathVariable Long roomId)
	{
		RoomDto updatedRoom = this.roomService.updateRoom(roomDto, roomId);		
		return new ResponseEntity<RoomDto>(updatedRoom,HttpStatus.OK);
	}
	
	
	
}
