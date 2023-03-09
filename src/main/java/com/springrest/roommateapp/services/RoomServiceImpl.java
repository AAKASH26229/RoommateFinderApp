package com.springrest.roommateapp.services;



import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.roommateapp.Exception.ResourceNotFoundException;
import com.springrest.roommateapp.dao.RoomDao;
import com.springrest.roommateapp.dao.UserDao;
import com.springrest.roommateapp.entities.Room;
import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.RoomDto;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public RoomDto createRoom(RoomDto roomDto, Long userId) {

		User user=this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id", userId));
		
		Room room = this.modelMapper.map(roomDto, Room.class);
		room.setOccupancy(roomDto.getOccupancy());
		room.setAddedDate(new Date());
		room.setUser(user);
		
		Room newRoom = this.roomDao.save(room);
		
		return this.modelMapper.map(newRoom, RoomDto.class);
	}

	@Override
	public RoomDto updateRoom(RoomDto roomDto, Long roomId) {
		Room room = this.roomDao.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room", "Room id", roomId));

		room.setOccupancy(roomDto.getOccupancy());
//		room.setUser(roomDto.getUser());
		
		Room updatedRoom = this.roomDao.save(room);
		return this.modelMapper.map(updatedRoom, RoomDto.class);
	}

	@Override
	public void deleteRoom(Long roomId) {

		Room room = this.roomDao.findById(roomId).orElseThrow(()-> new ResourceNotFoundException("Room", "Room id", roomId));
		this.roomDao.delete(room);
	}

	@Override
	public List<RoomDto> getAllRoom() {
		List<Room> allRooms = this.roomDao.findAll();
		List<RoomDto> roomDtos = allRooms.stream().map((room)-> this.modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
		
		return roomDtos;
	}

	@Override
	public RoomDto getRoomById(Long roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomDto> getRoomByUser(Long userId) {
		
		User user = this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","user_id", userId));
		List<Room> rooms = this.roomDao.findByuser(user);
		
		List<RoomDto> roomDtos = rooms.stream().map((room)->this.modelMapper.map(room, RoomDto.class)).collect(Collectors.toList());
		return roomDtos;
	}

	@Override
	public List<RoomDto> searchRoom(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
