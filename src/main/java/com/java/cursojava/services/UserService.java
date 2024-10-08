package com.java.cursojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.cursojava.entities.User;
import com.java.cursojava.repositories.UserRepository;
import com.java.cursojava.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User u)
	{
		return repository.save(u);
	}
	
	public void delete(Long id)
	{
		repository.deleteById(id);
	}
	
	public User update(Long id, User u)
	{
		User monitoredEntity = repository.getReferenceById(id);	//Prepares an object instead of searching it directly in the DB, like the findById method
		updateData(monitoredEntity, u);
		return repository.save(monitoredEntity);
	}

	private void updateData(User monitoredEntity, User u) {
		monitoredEntity.setName(u.getName());
		monitoredEntity.setEmail(u.getEmail());
		monitoredEntity.setPhone(u.getPhone());
	}
}
