package com.springrest.roommateapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.roommateapp.Exception.ResourceNotFoundException;
import com.springrest.roommateapp.dao.UserDao;
import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.Userdto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper modelMapper;

//	List<User> list;

	public UserServiceImpl() {

//		list=new ArrayList<>();
//		list.add(new User(101, "Akash", "Parate", "Male", "16-07-1998", "996436943217", "Bhilai",
//				"Chhattisgarh", "Working", "domain@gmail.com", "9928892221", "admin", "admin@123"));
//		list.add(new User(102, "Chirag", "Goyal", "Male", "16-08-1994", "996436942317", "Noida",
//				"UP", "Working", "domain@gmail.com", "8828892221", "chirag", "chirag@123"));
	}

	// add user
	@Override
	public Userdto addUser(Userdto userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = this.userDao.save(user);
		return this.userToDto(savedUser);

	}

	// update user
	@Override
	public Userdto updateUser(Userdto userDto, long userId) {

		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user.setFname(userDto.getFname());
		user.setLname(userDto.getLname());
		user.setGender(userDto.getGender());
		user.setDob(userDto.getDob());
		user.setAadhar(userDto.getAadhar());
		user.setCity(userDto.getCity());
		user.setState(userDto.getState());
		user.setRole(userDto.getRole());
		user.setMobile(userDto.getMobile());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setShift(userDto.getShift());
		user.setOccupancy(userDto.getOccupancy());
		user.setDiet(userDto.getDiet());

		User updatedUser = this.userDao.save(user);
		Userdto userDto1 = this.userToDto(updatedUser);

		return userDto1;
	}

	// get user by id
	@Override
	public Userdto getUser(long userId) {

		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.userToDto(user);
	}

	// get all user
	@Override
	public List<Userdto> getUsers() {

		List<User> users = this.userDao.findAll();

		List<Userdto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	// delete user by id
	@Override
	public void deleteUser(long userId) {

//		list=this.list.stream().filter(e->e.getUserid()!=parseLong).collect(Collectors.toList());

		User user = this.userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userDao.delete(user);
	}

	/**
	 * @param userDto
	 * @return modelmapper dependency you have to install
	 */
	public User dtoToUser(Userdto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

//		user.setFname(userDto.getFname());
//		user.setLname(userDto.getLname());
//		user.setGender(userDto.getGender());
//		user.setDob(userDto.getDob());
//		user.setAadhar(userDto.getAadhar());
//		user.setCity(userDto.getCity());
//		user.setState(userDto.getState());
//		user.setRole(userDto.getRole());
//		user.setEmail(userDto.getEmail());
//		user.setMobile(userDto.getMobile());
//		user.setUsername(userDto.getUsername());
//		user.setPassword(userDto.getPassword());
		return user;
	}

//
	public Userdto userToDto(User user) {
		Userdto userDto = this.modelMapper.map(user, Userdto.class);

//		userDto.setFname(user.getFname());
//		userDto.setLname(user.getLname());
//		userDto.setGender(user.getGender());
//		userDto.setDob(user.getDob());
//		userDto.setAadhar(user.getAadhar());
//		userDto.setCity(user.getCity());
//		userDto.setState(user.getState());
//		userDto.setRole(user.getRole());
//		userDto.setEmail(user.getEmail());
//		userDto.setMobile(user.getMobile());
//		userDto.setUsername(user.getUsername());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}

	public Userdto getUserByEmailAndPass(String email, String password) {
		User u = this.userDao.getUserByEmailAndPass(email, password);
		Userdto userDtos = this.modelMapper.map(u, Userdto.class);
		return userDtos;
	}

//	@Override
//	public List<Userdto> findMatchingUsersByHighPreference(String diet, String role, String gender, String shift,
//			String state) {
//
//		List<User> matchingUsers = new ArrayList<User>();
//		matchingUsers.addAll(this.userDao.findMatchingUsersByHighPreference(user.getDiet(), user.getRole(),
//				users.getGender(), user.getShift(), user.getState()));
//
//		return null;
//	}

	@Override
	public List<Userdto> getMatchingUsers(long userId) {
	
		User user = this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		if(user.getOccupancy() == "single")
			return Collections.EMPTY_LIST;
		else if (user.getOccupancy().equals("double")) {
			
//			List<User> matchingUsers = new ArrayList<User>();
//		matchingUsers.addAll (this.userDao.findMatchingUsersByHighPreference(user.getDiet(),user.getRole(),user.getGender(),user.getShift(),user.getState()));
			
			List<User> matchingUsers = this.userDao.findMatchingUsersByHighPreference(user.getDiet(),user.getRole(),user.getGender(),user.getShift(),user.getState());
			matchingUsers.remove(user);
			List<Userdto> userDtos = matchingUsers.stream().map(matchingUser -> this.userToDto(matchingUser)).collect(Collectors.toList());
			return userDtos;
		
		
		}
		else {
			return Collections.EMPTY_LIST;
		}

}

	@Override
	public List<Userdto> findMatchingUsersByHighPreference(String diet, String role, String gender, String shift,
			String state) {
		// TODO Auto-generated method stub
		return null;
	}
}
