package com.lifeinsurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	public static final String INDEX_PAGE = "index.html";

	@RequestMapping(value = { "/", "/products", "/profile", "/shopping-cart", "/login", "/register", "/checkout",
			"/about" })
	public String showHome() {

		return INDEX_PAGE;

	}


	@RequestMapping(value = { "/products/**", "/profile/**", "/quote/**", "/admin/**", "/payment/**" }, method = RequestMethod.GET)
	public String redirectHome() {

		return "redirect:/" + INDEX_PAGE;

	}

}
