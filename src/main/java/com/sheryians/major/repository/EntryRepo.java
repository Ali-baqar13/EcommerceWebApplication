package com.sheryians.major.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Entry;

public interface EntryRepo extends JpaRepository<Entry, Integer>{
	
	

	
}
