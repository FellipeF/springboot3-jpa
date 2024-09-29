package com.java.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.cursojava.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}