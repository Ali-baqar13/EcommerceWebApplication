package com.sheryians.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.service.Modelservice;
import com.sheryians.major.service.Productservice;

@Controller
public class HomeController {
	@Autowired
	private Modelservice modelservice;
	@Autowired
	private Productservice productservice;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("cart", GlobalData.cart);
		return "index";
	}

	@GetMapping("/shop")
	public String home1(Model model) {
		model.addAttribute("categories", modelservice.getAllModel());
		model.addAttribute("cart", GlobalData.cart);
		model.addAttribute("products", productservice.getAllProducts());
		return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String home2(@PathVariable int id, Model model) {

		model.addAttribute("cart", GlobalData.cart);
		model.addAttribute("categories", modelservice.getAllModel());
		model.addAttribute("products", productservice.getAllProductsByCatagory_Id(id));

		return "shop";
	}

	@GetMapping("/shop/viewproduct/{id}")
	public String home3(Model model, @PathVariable int id) {

		model.addAttribute("product", productservice.getProduct(id).get());
		model.addAttribute("cart", GlobalData.cart);

		return "viewProduct";

	}

}
