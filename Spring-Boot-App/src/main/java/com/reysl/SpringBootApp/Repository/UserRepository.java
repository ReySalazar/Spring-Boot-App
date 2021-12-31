package com.reysl.SpringBootApp.Repository;

import java.util.Optional;

//import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.SpringBootApp.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	public Optional<User> findByUsername(String username);
	//public Iterable<User> findAllByStatus(String status);
	
}
