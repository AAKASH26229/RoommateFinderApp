package com.springrest.roommateapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.roommateapp.entities.User;
import com.springrest.roommateapp.payloads.Userdto;
import java.util.List;


public interface UserDao extends JpaRepository<User, Long> {
	
	
	public User findByEmail(String email);
	
	@Query(value = "select * from users u where u.email = ?1   and u.password=?2", nativeQuery = true)
	User getUserByEmailAndPass(String email, String password);
	
	
	@Query(value = "SELECT * FROM users u WHERE u.diet= ?1 and u.role= ?2 and u.shift= ?4 and u.gender=?3 and u.state=?5", nativeQuery = true)
	List<User> findMatchingUsersByHighPreference( String diet, String role, String gender, String shift, String state);
	
//	@Query(value="select * from User u where (u.diet= ?1 and u.role= ?2 and u.shift= ?3 and u.gender= ?4) or (u.role= ?2 and u.shift= ?3 and u.state= ? and u.gender=:gender) or (u.diet=:diet and u.shift=:shift and u.state=:state and u.gender=:gender) or (u.diet=:diet and u.role=:role and u.state=:state and u.gender=:gender)")
//	List<User> findMatchingUsersByMediumPreference( String diet, String role, String gender, String shift, String state);
	
//	@Query(value="select * from User u where (u.diet=:diet and u.role=:role and u.gender=:gender) or (u.diet=:diet and u.gender=:gender and u.shift=:shift) or (u.diet=:diet and u.gender=:gender and u.state=:state) or (u.role=:role and u.gender=:gender and u.shift=:shift) or (u.role=:role and u.gender=:gender and u.state=:state) or (u.gender=:gender and u.shift=:shift and u.state=:state)")
//	List<User> findMatchingUsersByLowPreference( String diet, String role, String gender, String shift, String state);
	
}
