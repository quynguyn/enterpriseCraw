package com.example.enterprise.repo;

import com.example.enterprise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, String> {

	List<Product> findByVendor(String businessName);

	List<Product> findAllByOrderByPriceDesc();

	List<Product> findAllByOrderByPriceAsc();
}
