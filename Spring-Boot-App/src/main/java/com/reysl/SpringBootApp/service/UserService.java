package com.reysl.SpringBootApp.service;

import com.reysl.SpringBootApp.Entity.User;

public interface UserService {
	
	public Iterable<User> getAllUsers();
	
}
