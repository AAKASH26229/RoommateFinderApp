package com.springrest.roommateapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springrest.roommateapp.dao.UserDao;

@SpringBootTest
class RoommateappApplicationTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	void contextLoads() {
	}

	
	public void daoTest()
	{
		String className = this.userDao.getClass().getName();
		String packName = this.userDao.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packName);
	}
	
}
