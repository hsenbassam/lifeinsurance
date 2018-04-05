package com.lifeinsurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public static final String INDEX_PAGE = "index.html";

	@GetMapping(value = { "/", "/products", "/profile", "/shopping-cart", "/login", "/register", "/checkout","/about" })
	public String showHome() {

		return INDEX_PAGE;

	}


	@GetMapping(value = { "/products/**", "/profile/**", "/quote/**", "/admin/**", "/payment/**" })
	public String redirectHome() {

		return "redirect:/" + INDEX_PAGE;

	}

}
