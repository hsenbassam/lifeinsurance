package com.lifeinsurance.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class OrderController {
	
	@RequestMapping(value = "/api/orders", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody String getOrders() {		
		return "Test Orders";
	}

}
