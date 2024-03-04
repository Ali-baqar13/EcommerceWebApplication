package com.sheryians.major.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sheryians.major.dto.ProductDto;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProdRepository;
import com.sheryians.major.service.Modelservice;
import com.sheryians.major.service.ModelserviceImp;
import com.sheryians.major.service.Productservice;

import jakarta.persistence.criteria.Path;

@Controller
public class AdminController {

	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

	@Autowired
	private ModelserviceImp modelservice;

	@Autowired
	private Productservice productservice;

	@GetMapping("/admin")
	public String Admin() {

		return "adminHome";
	}

//...........................................................................................................................
	Category category = new Category();

	@GetMapping("/admin/categories")
	public String getCatagories(Model model) {

		try {

			model.addAttribute("categories", modelservice.getAllModel());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "categories";
		// .......correct works..........//

	}
//.........................................................................................................................

	@GetMapping("/admin/categories/add")
	public String addCategories(Model model) {
		try {
			model.addAttribute("category", new Category());
			return "categoriesAdd";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "categoriesAdd";
		// .......works correct...........//
	}

//.........................................................................................................................

	@PostMapping("/admin/categories/add")
	public String addcat(@ModelAttribute("category") Category category) {

		modelservice.addModel(category);

		return "redirect:/admin/categories";

	}

	@GetMapping("/admin/categories/delete/{id}")
	public String removeCategory(@PathVariable int id) {
		modelservice.removeCat(id);
		return "redirect:/admin/categories";

	}

	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id, Model model) {
		Optional<Category> categories = modelservice.getCategory(id);
		if (categories.isPresent()) {
			model.addAttribute("category", categories.get());
			return "categoriesAdd";

		} else {
			return "404";
		}

	}

	// ..................................................Product.............................................................................................................................

	@GetMapping("/admin/products")
	public String product(Model model) {

		model.addAttribute("products", productservice.getAllProducts());
		return "products";

	}

	@GetMapping("/admin/products/add")
	public String productAdd(Model model) {
		model.addAttribute("productDTO", new ProductDto());
		model.addAttribute("categories", modelservice.getAllModel());
		return "productsAdd";

	}

	@PostMapping("/admin/products/add")
	public String postProduct(@ModelAttribute("productsDTO") ProductDto productdto,
			@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgname)
			throws IOException {

		Product product = new Product();
		product.setId(productdto.getId());
		product.setPrice(productdto.getPrice());
		product.setQuantity(productdto.getQuantity());
		product.setDescription(productdto.getDescription());
		product.setName(productdto.getName());
		product.setWeight(productdto.getWeight());
		product.setCategory(modelservice.getCategory(productdto.getCategoryId()).get());
		String imageuuid;
		if (!file.isEmpty()) {
			imageuuid = file.getOriginalFilename();
			java.nio.file.Path fileNameAndPath = Paths.get(uploadDir, imageuuid);
			Files.write(fileNameAndPath, file.getBytes());

		} else {
			imageuuid = imgname;
		}
		product.setImageName(imageuuid);
		productservice.addProduct(product);

		return "redirect:/admin/products";
	}

	@GetMapping("/admin/product/update/{id}")
	public String updatedProduct(@PathVariable long id, Model model) {

		Product product = productservice.getProduct(id).get();
		ProductDto productdto = new ProductDto();
		productdto.setWeight(product.getWeight());
		productdto.setDescription(product.getDescription());
		productdto.setQuantity(product.getQuantity());
		productdto.setName(product.getName());
		productdto.setId(product.getId());
		productdto.setCategoryId(product.getCategory().getId());
		productdto.setImageName(product.getImageName());
		model.addAttribute("categories", modelservice.getAllModel());
		model.addAttribute("productDTO", productdto);

		return "productsAdd";
	}

	@GetMapping("/admin/product/delete/{id}")
	public String DeleteProduct(@PathVariable long id) {
		productservice.removeProduct(id);
		return "redirect:/admin/products";
	}

}
