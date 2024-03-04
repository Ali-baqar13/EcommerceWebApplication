package com.sheryians.major.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheryians.major.model.Carts;
import com.sheryians.major.model.Product;
import com.sheryians.major.repository.CartRepository;

@Service
public class CartsService {
	@Autowired
	CartRepository cartRepo;

	public Optional<Carts> getCart(long id) {
		// TODO Auto-generated method stub
		
		
		
		return cartRepo.findById(id);
	}

	public Carts addCart(Carts cart) {
		return cartRepo.save(cart);
	}

	public List<Long> getAllIds() {
		List<Carts> entities = cartRepo.findAll();
		List<Long> ids = new ArrayList<>();

		for (Carts cart : entities) {
			ids.add(cart.getId());
		}

		return ids;

	}

}
