package com.java.cursojava.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.cursojava.entities.Category;
import com.java.cursojava.repositories.CategoryRepository;

//CategoryService needs to be registered as a Spring Component if using dependency injection

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll()
	{
		return repository.findAll();
	}
	
	public Category findById(Long id)
	{
		Optional<Category> obj = repository.findById(id);
		return obj.get();	//Return a Category type object.
	}
}
