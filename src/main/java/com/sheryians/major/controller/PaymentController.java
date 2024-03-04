package com.sheryians.major.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.model.Carts;
import com.sheryians.major.model.Entry;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CartsService;
import com.sheryians.major.service.EntryService;
import com.sheryians.major.service.Productservice;

@Controller
public class PaymentController {

	@Autowired
	public EntryService entryservice;
	@Autowired
	Productservice prodservice;
	@Autowired
	CartsService cartservice;

	@PostMapping("/payNow")
	public String payment(Model model) {

		Carts cart = new Carts();
		List<Carts> carted = new ArrayList<>();

		List<Long> productids = new ArrayList<>();
		for (Product product : GlobalData.cart) {
			cart.setId(product.getId());
			cart.setProductName(product.getName());
			cart.setPrice(product.getPrice());

			Carts addCart = cartservice.addCart(cart);

			carted.add(addCart);
			System.out.println(addCart);
		}

		for (int i = 0; i <= cartservice.getAllIds().size() - 1; i++) {
			productids.add(cartservice.getAllIds().get(i));
			System.out.println(productids);
		}

		List<Carts> list =new ArrayList<>();
		for (long m : productids) {
			for (int j = 0; j <= carted.size() - 1; j++) {

				if (carted.get(j).getId() != m) {
					System.out.println(carted.get(j).getId() + "-->" + m);
				} else {
					System.out.println("got sucess");
					System.out.println(carted.get(j).getId() + "-->" + m);
					Carts cartt = cartservice.getCart(m).get();
					list.add(cartt);
					
				}
				model.addAttribute("parameters", list);
				model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());

			}

		}

		return "orderPlaced";
	}

}
