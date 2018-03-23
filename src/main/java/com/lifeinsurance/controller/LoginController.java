package com.lifeinsurance.controller;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.JwtUser;
import com.lifeinsurance.model.User;
import com.lifeinsurance.security.JwtGenerator;
import com.lifeinsurance.service.UserService;

@Controller
public class LoginController {
	
	//Key key = MacProvider.generateKey();
	
	@Autowired
	UserService userService;
	
	@Autowired
	JwtGenerator jwtGenerator;
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST, consumes = {"application/json"})
	public @ResponseBody User login(@RequestBody AuthenticationCredentials credentials, HttpServletResponse response) {	
		
		User user = userService.validateUser(credentials);
		
		if (user != null) {

			JwtUser jwtUser = new JwtUser(user.getUsername(), new Random().nextInt(1000), userService.getRoles(user.getId()));
			String token = jwtGenerator.generate(jwtUser);
			
			response.setHeader("Token", token);
		}
	
		
		return user;
	}

}
