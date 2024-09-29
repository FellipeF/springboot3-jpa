package com.java.cursojava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.cursojava.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}