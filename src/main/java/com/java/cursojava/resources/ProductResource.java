package com.java.cursojava.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.cursojava.entities.Product;
import com.java.cursojava.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll()
	{
		//Call to Service Layer
		List <Product> list = service.findAll();
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id)
	{
		Product u = service.findById(id);
		return ResponseEntity.ok().body(u);
		//TODO: Error Treating
	}
}
