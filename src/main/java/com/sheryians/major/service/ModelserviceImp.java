package com.sheryians.major.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.ProdRepository;

import jakarta.transaction.Transactional;

@Service

public class ModelserviceImp implements Modelservice {
	@Autowired
	private ProdRepository product;

	@Override
	public void addModel(Category category) {
		product.save(category);

	}

	@Override
	public List<Category> getAllModel() {

		List<Category> listed = product.findAll();

		return listed;
	}

	@Override
	public void removeCat(int id) {
		product.deleteById(id);
		
	}

	@Override
	public void updateCategory(Category category, int id) {
		
		
	}

	@Override
	public Optional<Category> getCategory(int id) {
		return product.findById(id);
		//return Optional.empty();
	}

	

	
   
    
	

	

	
		
	

}

	
