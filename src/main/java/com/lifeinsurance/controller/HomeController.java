package com.lifeinsurance.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/", "/products", "/shopping-cart", 
							"/login", "/register", "/checkout", 
							"/my-orders", "/order-success","/admin/**"
							})
	
	public String showHome() {
		
		return "index.html";
		
	}
	
	
}
