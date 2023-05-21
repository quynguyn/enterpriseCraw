package com.example.enterpriseCraw.controller;

import com.example.enterpriseCraw.model.GearVn;
import com.example.enterpriseCraw.model.Product;
import com.example.enterpriseCraw.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping()
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    @GetMapping("/{name}")
    public List<Product> getProductByName (@PathVariable String name){
        return productRepo.findByName(name);
    }

}
