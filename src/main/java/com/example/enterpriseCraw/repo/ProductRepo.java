package com.example.enterpriseCraw.repo;

import com.example.enterpriseCraw.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,String> {
    List<Product> findByName(String name);
}
