package com.java.cursojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.java.cursojava.entities.User;
import com.java.cursojava.repositories.UserRepository;
import com.java.cursojava.services.exceptions.DatabaseException;
import com.java.cursojava.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

//UserService needs to be registered as a Spring Component if using dependency injection

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User u) {
		return repository.save(u);
	}
	
	public void delete(Long id) {
	    User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

	    if (!user.getOrders().isEmpty()) {
	        throw new DatabaseException("User has associated orders and cannot be deleted.");
	    }

	    try {
	        repository.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DatabaseException("Integrity violation - " + e.getMessage());
	    }
	}

	public User update(Long id, User u) {
		try
		{
			User monitoredEntity = repository.getReferenceById(id); // Prepares an object instead of searching it directly in the DB, like the findById method
			updateData(monitoredEntity, u);
			return repository.save(monitoredEntity);
		} catch (EntityNotFoundException e)
		{
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User monitoredEntity, User u) {
		monitoredEntity.setName(u.getName());
		monitoredEntity.setEmail(u.getEmail());
		monitoredEntity.setPhone(u.getPhone());
	}
}
