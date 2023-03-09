package com.springrest.roommateapp.services;

import java.util.List;

import com.springrest.roommateapp.entities.Room;
import com.springrest.roommateapp.payloads.RoomDto;

public interface RoomService {

	
	// create room
	
	RoomDto createRoom(RoomDto roomDto, Long userId);
	
	// update
	
	RoomDto updateRoom(RoomDto roomDto,Long roomId);
	
	// delete 
	
	void deleteRoom(Long roomId);
	
	// get all rooms
	
	List<RoomDto> getAllRoom();
	
	// get single room details
	
	RoomDto getRoomById(Long roomId);
	
	//get all room by user
	
	List<RoomDto> getRoomByUser(Long userId);
	
	// search room
	List<RoomDto> searchRoom(String keyword);
	
}
