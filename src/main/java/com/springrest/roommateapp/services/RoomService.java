package com.springrest.roommateapp.services;

import java.util.List;

import com.springrest.roommateapp.entities.Room;
import com.springrest.roommateapp.payloads.RoomDto;

public interface RoomService {

	
	// create room
	
	RoomDto createRoom(RoomDto roomDto, Long userId);
	
	// update
	
	Room updateRoom(RoomDto roomDto,Long roomId);
	
	// delete 
	
	void deletePost(Long roomId);
	
	// get all rooms
	
	List<RoomDto> getAllRoom();
	
	// get single room details
	
	Room getRoomById(Long roomId);
	
	//get all room by user
	
	List<RoomDto> getRoomByUser(Long userId);
	
	// search room
	List<Room> searchRoom(String keyword);
	
}
