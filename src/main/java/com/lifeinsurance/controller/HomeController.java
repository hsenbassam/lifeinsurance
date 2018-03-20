package com.lifeinsurance.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	public static final String INDEX_PAGE = "index.html";

	@RequestMapping(value = { "/", "/products/**", "/products", "/quote/**", "/shopping-cart", "/login",
							"/register", "/checkout", "/my-orders",
							"/order-success", "/admin/**", "/about" }, method = RequestMethod.GET)
	public String showHome() {

		return INDEX_PAGE;

	}
	
//	@RequestMapping(value = "/*", method = RequestMethod.GET)
//	public String index() {
//	    return "index";
//	}

}
