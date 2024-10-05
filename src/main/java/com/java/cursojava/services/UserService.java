package com.java.cursojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.cursojava.entities.User;
import com.java.cursojava.repositories.UserRepository;

//UserService needs to be registered as a Spring Component if using dependency injection

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll()
	{
		return repository.findAll();
	}
	
	public User findById(Long id)
	{
		Optional<User> obj = repository.findById(id);
		return obj.get();	//Return a User type object.
	}
	
	public User insert(User u)
	{
		return repository.save(u);
	}
}
