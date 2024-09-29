package com.java.cursojava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.cursojava.entities.Category;
import com.java.cursojava.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;	
	
	@GetMapping	//Responds to HTTP GET requests
	public ResponseEntity<List<Category>> findAll()
	{
		//Call to Service Layer
		List <Category> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id)
	{
		Category u = service.findById(id);
		return ResponseEntity.ok().body(u);
		//TODO: Error Treating
	}
}
