package com.example.enterprise.controller;

import com.example.enterprise.model.Order;
import com.example.enterprise.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class OrderController {

	@Autowired
	OrderRepo orderRepo;

	@PostMapping("/product")
	public Order updateAccount(@PathVariable String id, @RequestBody Order updatedProduct) {
		Optional<Order> orderOptional = orderRepo.findById(id);
		if (orderOptional.isPresent()) {
			Order existingProduct = orderOptional.get();
			System.out.println(existingProduct);
			// existingProduct.setName(updatedProduct.getName());
			// existingProduct.setPrice(updatedProduct.getPrice());
			// existingProduct.setImage(updatedProduct.getImage());
			// existingProduct.setDescription(updatedProduct.getDescription());

			// Save the updated account in the repository

			System.out.println(existingProduct);
			return orderRepo.save(existingProduct);
		}
		return null; // Return null or handle the case where the account with the given ID doesn't
						// exist
	}
}
