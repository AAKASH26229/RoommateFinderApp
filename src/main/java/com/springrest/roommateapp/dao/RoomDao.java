package com.springrest.roommateapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.roommateapp.entities.Room;
import com.springrest.roommateapp.entities.User;

public interface RoomDao extends JpaRepository<Room, Long>{

	List<Room> findByuser(User user);

}
