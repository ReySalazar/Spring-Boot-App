package com.reysl.SpringBootApp.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reysl.SpringBootApp.Entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	
}
