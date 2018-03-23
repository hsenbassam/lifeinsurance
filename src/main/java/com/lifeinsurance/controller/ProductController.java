package com.lifeinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.Product;
import com.lifeinsurance.service.ProductService;

@Controller
@RequestMapping(produces = {"application/json"}, consumes = {"application/json"})
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/productsProcess", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProducts() {	
		
		List<Product> products = productService.getAll();
		return products;
	}
	
	@RequestMapping(value = "/productsProcess/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable int id) {	
		
		Product product = productService.get(id);
		return product;
	}
	
	@RequestMapping(value = "/productsProcess/{id}", method = RequestMethod.PUT)
	public @ResponseBody Product updateProduct(@PathVariable int id, @RequestBody Product product) {	
		
		Product productUpdated = productService.update(id, product);
		return productUpdated;
	}
	
	@RequestMapping(value = "/productsProcess", method = RequestMethod.POST)
	public @ResponseBody Product addProduct(@RequestBody Product product) {	
		
		Product addedProduct = productService.add(product);
		return addedProduct;
	}
	
	@RequestMapping(value = "/productsProcess/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {	
		productService.delete(id);
	}
	
	

}
