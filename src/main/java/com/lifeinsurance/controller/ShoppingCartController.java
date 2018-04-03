package com.lifeinsurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.CartProduct;
import com.lifeinsurance.service.CartProductService;

@Controller
@RequestMapping(value = "/api/shopping-cart", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {

	@Autowired
	CartProductService cartProductService;

	@GetMapping
	public @ResponseBody List<CartProduct> getCartProducts(@RequestParam("userId") int userId) {

		List<CartProduct> products = cartProductService.getAll(userId);
		return products;

	}

	@PostMapping
	public @ResponseBody CartProduct addProductToCart(@RequestBody CartProduct product,
			@RequestParam("userId") int userId) {

		CartProduct cartProduct = cartProductService.add(product, userId);
		return cartProduct;

	}
	
	@DeleteMapping(value="/{id}")
	public void deleteProduct(@PathVariable int id, HttpServletResponse response) {	
		cartProductService.delete(id);
	}
	

}
