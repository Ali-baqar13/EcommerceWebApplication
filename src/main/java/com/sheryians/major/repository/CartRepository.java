package com.sheryians.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Carts;

public interface CartRepository extends JpaRepository<Carts, Long>{
	

	
}
