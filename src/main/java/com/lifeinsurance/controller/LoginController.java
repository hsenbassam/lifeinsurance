package com.lifeinsurance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;
import com.lifeinsurance.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("login", new Login());
		
		return modelAndView;
	}
	
//	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
//		
//		ModelAndView modelAndView = null;
//		
//		User user = userService.validateUser(login);
//		
//		if(null != user) {
//			modelAndView = new ModelAndView("welcome");
//			modelAndView.addObject("firstname", user.getFirstname());
//		}
//		else {
//			modelAndView = new ModelAndView("login");
//			modelAndView.addObject("message", "Username or Password is Incorrect");
//		}
//		
//		return modelAndView;
//		
//	}
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody User loginProcess(@RequestBody Login login) {	
		
		User user = userService.validateUser(login);
		return user;
	}

}
