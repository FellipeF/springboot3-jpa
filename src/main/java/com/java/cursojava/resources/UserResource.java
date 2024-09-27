package com.java.cursojava.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.cursojava.entities.User;

//Defines that this class is a Web Resource that is implemented by a Rest Controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//Endpoint that access users
	
	//Returns responses from Web Requests

	@GetMapping	//Responds to HTTP GET requests
	public ResponseEntity<User> findAll()
	{
		//Begin testing
		User u = new User(1L, "Maria", "maria@gmail.com", "9555-5555", "1147");
		return ResponseEntity.ok().body(u);
	}
}
