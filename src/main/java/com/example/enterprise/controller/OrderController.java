package com.example.enterprise.controller;

import com.example.enterprise.model.Order;
import com.example.enterprise.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.*;

import java.lang.ProcessBuilder.Redirect;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping
public class OrderController {

	@Autowired
	OrderRepo orderRepo;

	@PostMapping("/orders")
	public RedirectView createOrder(@RequestParam Map<String, String> body) {
		// work with Map
		System.out.println(body);
		Order order = new Order();
		
		order.set_id(UUID.randomUUID().toString());

		order.setActivity(body.get("activity"));
		order.setOrderAddress(body.get("orderAddress"));
		order.setOrdererName(body.get("orderName"));
		order.setProductList(body.get("productList"));


		orderRepo.save(order);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost:8080/customer.html");
		return redirectView;
	}
}
