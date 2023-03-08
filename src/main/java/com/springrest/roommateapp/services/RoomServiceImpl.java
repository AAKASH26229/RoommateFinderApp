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
	public Room updateRoom(RoomDto roomDto, Long roomId) {
		
		
		
		return null;
	}

	@Override
	public void deletePost(Long roomId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoomDto> getAllRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room getRoomById(Long roomId) {
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
	public List<Room> searchRoom(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
