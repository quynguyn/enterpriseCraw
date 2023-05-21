package com.example.enterprise.controller;

import com.example.enterprise.model.Account;
import com.example.enterprise.model.Product;
import com.example.enterprise.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    @GetMapping("products/vendor/{businessName}")
    public List<Product> getProductsByVendor(@PathVariable String businessName){
        return productRepo.findByVendor(businessName);
    }

    @PostMapping("/product")
    public String updateAccount(@PathVariable String id, @RequestBody Product updatedProduct) {
        Optional<Product> productOptional = productRepo.findById(id);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            System.out.println(existingProduct);
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImage(updatedProduct.getImage());
            existingProduct.setDescription(updatedProduct.getDescription());

            // Save the updated account in the repository

            System.out.println(existingProduct);
            productRepo.save(existingProduct);
            return "redirect:http://localhost:8080/myAccount.html";
        }
        return null; // Return null or handle the case where the account with the given ID doesn't exist
    }
}
