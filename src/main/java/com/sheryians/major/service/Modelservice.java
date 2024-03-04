package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sheryians.major.model.Category;


public interface Modelservice {
	public List<Category> getAllModel();
	public void addModel(Category category);
	public void removeCat(int id);
	public void updateCategory(Category category, int id);
	public Optional<Category> getCategory(int id);
	
	
	

}
