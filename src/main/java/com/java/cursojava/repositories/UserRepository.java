package com.java.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.cursojava.entities.User;

//JpaRepository is already registered as a Spring component, so no need to @Repository in this interface

public interface UserRepository extends JpaRepository<User, Long> {
	//JpaRepository already has default implementation
}