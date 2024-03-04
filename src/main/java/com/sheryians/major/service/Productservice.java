package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sheryians.major.model.Product;
@Service
public interface Productservice {
	public List<Product> getAllProducts();
	public void addProduct(Product product);
	public void removeProduct(long id);
	public void updateProduct(Product product, long id);
	public Optional<Product> getProduct(long id);
	public List<Product> getAllProductsByCatagory_Id(int id);

}
