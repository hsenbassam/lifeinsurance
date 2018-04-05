package com.lifeinsurance.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.model.User;
import com.lifeinsurance.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	UserService userService;

	@PostMapping(value = "/registerProcess", consumes = "application/json")
	public User registerProcess(@RequestBody User user) throws ParseException, InternalServerException {	
		
		User userReturned = userService.register(user);
		return userReturned;
	}

}
