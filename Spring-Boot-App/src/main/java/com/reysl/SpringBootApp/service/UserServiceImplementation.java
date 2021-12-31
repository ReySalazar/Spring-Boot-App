package com.reysl.SpringBootApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reysl.SpringBootApp.Entity.User;
import com.reysl.SpringBootApp.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}
	
	private boolean checkUsernameAvailable(User user) throws Exception {
		
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new Exception("El usuario ingresado no está disponible");
		}
		return true;
		
	}

	private boolean chekPasswordValid(User user) throws Exception {
		
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("La confirmacion de password no coincide");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && chekPasswordValid(user)) {
			user = repository.save(user);
		}
		return user;
	}
}
