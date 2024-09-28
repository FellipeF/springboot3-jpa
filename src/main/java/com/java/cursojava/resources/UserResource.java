package com.java.cursojava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.cursojava.entities.User;
import com.java.cursojava.services.UserService;

//Defines that this class is a Web Resource that is implemented by a Rest Controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;	
	
	//Returns responses from Web Requests
	//Endpoint that access users
	
	@GetMapping	//Responds to HTTP GET requests
	public ResponseEntity<List<User>> findAll()
	{
		//Call to Service Layer
		List <User> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
		//TODO: Error Treating
	}
}
