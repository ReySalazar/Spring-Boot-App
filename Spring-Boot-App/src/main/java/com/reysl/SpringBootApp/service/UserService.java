package com.reysl.SpringBootApp.service;

import com.reysl.SpringBootApp.Entity.User;

public interface UserService {
	
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;
	
	public User getUserById(Long id) throws Exception;

	public User updateUser(User user) throws Exception;
		
}
