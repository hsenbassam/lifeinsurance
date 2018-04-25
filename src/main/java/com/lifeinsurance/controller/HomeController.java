package com.lifeinsurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public static final String INDEX_PAGE = "index.html";

	@GetMapping("/")
	public String showHome() {

		return INDEX_PAGE;

	}
}
