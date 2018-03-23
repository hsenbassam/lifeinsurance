package com.lifeinsurance.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.User;
import com.lifeinsurance.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody User registerProcess(@RequestBody User user) throws ParseException {	
		
		User userReturned = userService.register(user);
		return userReturned;
	}

}
