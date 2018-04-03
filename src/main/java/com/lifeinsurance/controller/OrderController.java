package com.lifeinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.service.OrderService;



@Controller
@RequestMapping(value = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public @ResponseBody int addOrder(@RequestParam("userId") int userId) {

		int ordersCount = orderService.add(userId);
		return ordersCount;

	}

}
