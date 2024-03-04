package com.sheryians.major.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.dto.ProductDto;
import com.sheryians.major.global.GlobalData;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.Productservice;

@Controller
public class CartController {
	@Autowired
	Productservice productservice;

	@GetMapping("/addToCart/{id}")
	public String cart1(@PathVariable long id, Model model) {

		Product pro = productservice.getProduct(id).get();
		GlobalData.cart.add(pro);
		int m = pro.getQuantity();
		m = m - 1;
		pro.setQuantity(m);
		productservice.addProduct(pro);
		return "redirect:/shop";
	}

	@GetMapping("/cart")
	public String cart2(Model model) {

		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("cart", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "cart";

	}

	@GetMapping("/cart/removeItem/{index}")
	public String cart3(@PathVariable int index, Model model) {

		
		GlobalData.cart.remove(index);
//		Product product= productservice.getProduct(id).get();
//		
//		int m = product.getQuantity();
//		
//		m = m + 1;
//		product.setQuantity(m);
//		productservice.addProduct(product);
		
		
		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String cart4(Model model) {
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());

		return "checkout";

	}

}
