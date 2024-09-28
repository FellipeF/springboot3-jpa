package com.java.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.cursojava.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//JpaRepository already has default implementation
}