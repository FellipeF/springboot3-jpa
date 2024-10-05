package com.java.cursojava.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.cursojava.entities.User;
import com.java.cursojava.services.UserService;

//Defines that this class is a Web Resource that is implemented by a Rest Controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// Returns responses from Web Requests
	// Endpoint that access users

	@GetMapping // Responds to HTTP GET requests
	public ResponseEntity<List<User>> findAll() {
		// Call to Service Layer
		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
		// TODO: Error Treating
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User u) // This object is requested as a JSON that will be
															// de-serialized as the User object.
	{
		u = service.insert(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		// Location header that contains newly added resource address - 201 HTTP Code
		return ResponseEntity.created(uri).body(u);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		service.delete(id);
		return ResponseEntity.noContent().build();	//204 code
		//TODO : Treat integrity constraint violation. That is, deleting Users that have Orders associated with them.
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u)
	{
		u = service.update(id, u);
		return ResponseEntity.ok().body(u);
	}
}
