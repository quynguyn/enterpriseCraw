package com.example.enterprise.controller;

import com.example.enterprise.model.Product;
import com.example.enterprise.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@GetMapping("products/vendor/{businessName}")
	public List<Product> getProductsByVendor(@PathVariable String businessName) {
		return productRepo.findByVendor(businessName);
	}

	@PostMapping("/products")
	public String createProduct(@ModelAttribute Product product) {
		product.set_id(UUID.randomUUID().toString());
		productRepo.save(product);
		return "redirect:http://localhost:8080/vendor.html";
	}

	@GetMapping("/products/descend")
	public List<Product> getProductsByPriceDescend() {
		return productRepo.findAllByOrderByPriceDesc();
	}

	@GetMapping("/products/ascend")
	public List<Product> getProductsByPriceAscend() {
		return productRepo.findAllByOrderByPriceAsc();
	}
}
