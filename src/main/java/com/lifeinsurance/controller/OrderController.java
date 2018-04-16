package com.lifeinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;
import com.lifeinsurance.service.OrderService;

@Controller
@RequestMapping(value = "/api/orders", produces = "application/json", consumes = "application/json")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public @ResponseBody int addOrder(@RequestParam("userId") int userId) throws NotFoundException {

		int ordersCount = orderService.add(userId);
		return ordersCount;

	}
	
	@GetMapping @ResponseBody List<Order> getOrders() throws NotFoundException {
		return orderService.getAll();
	}

}
