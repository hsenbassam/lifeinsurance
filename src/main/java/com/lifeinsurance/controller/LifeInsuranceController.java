package com.lifeinsurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LifeInsuranceController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		
		String message = "<div><h3>Life Insurance Service !</h3></div>";
		return new ModelAndView("welcome", "message", message);
		
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView helloWorld2() {
		
		String message = "<div><h3>Hello World </h3></div>";
		return new ModelAndView("index", "message", message);
		
	}
	
}
