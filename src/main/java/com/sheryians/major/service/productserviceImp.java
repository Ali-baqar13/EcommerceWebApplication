package com.sheryians.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepsitory;


@Service
public class productserviceImp implements Productservice{
	@Autowired
	private ProductRepsitory productRepository;

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=productRepository.findAll();
		return list;
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void removeProduct(long id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public void updateProduct(Product product, long id) {
		
		
	}

	@Override
	public Optional<Product> getProduct(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	

	@Override
	public List<Product> getAllProductsByCatagory_Id(int id) {
		
		List<Product> list=productRepository.getAllProductBycategory_id(id);
		return list;
	}

}
