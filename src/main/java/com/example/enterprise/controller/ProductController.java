package com.example.enterprise.controller;

import com.example.enterprise.model.Product;
import com.example.enterprise.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
