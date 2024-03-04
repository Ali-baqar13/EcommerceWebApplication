package com.sheryians.major.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Product;

public interface ProductRepsitory extends JpaRepository<Product, Long> {
	public List<Product> getAllProductBycategory_id(int id); 
	
	
	

}
