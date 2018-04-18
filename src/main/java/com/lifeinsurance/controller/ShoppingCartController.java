package com.lifeinsurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;
import com.lifeinsurance.service.ShoppingCartService;

@Controller
@RequestMapping(value = "/api/shopping-cart", produces = "application/json" , consumes = "application/json")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;

	@GetMapping
	public @ResponseBody List<Order> getCartProducts(@RequestParam("userId") int userId) throws NotFoundException {

		List<Order> products = shoppingCartService.getAll(userId);
		return products;

	}

	@PostMapping
	public @ResponseBody Order addProductToCart(@RequestBody Order product,
			@RequestParam("userId") int userId) throws InternalServerException {

		Order cartProduct = shoppingCartService.add(product, userId);
		return cartProduct;

	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id, HttpServletResponse response) throws NotFoundException {	
		shoppingCartService.delete(id);
	}
	

}
