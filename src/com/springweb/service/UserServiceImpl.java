package com.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngweb.model.User;
import com.springweb.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
	public UserServiceImpl() {
		System.out.println("user service successfully done");
	}

	private UserDaoImpl userService;

	@Autowired
	public void setUserService(UserDaoImpl userService) {
		this.userService = userService;
	}
	public boolean Insert(User user) {
		return userService.Insert(user);
	}
	public List<User> getusers() {
		
		return userService.getusers();
	}
}
