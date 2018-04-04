package com.lifeinsurance.controller;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.JwtUser;
import com.lifeinsurance.model.User;
import com.lifeinsurance.security.JwtGenerator;
import com.lifeinsurance.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	JwtGenerator jwtGenerator;

	@PostMapping(value = "/loginProcess", consumes = "application/json")
	public User login(@RequestBody AuthenticationCredentials credentials, HttpServletResponse response) {

		User user = userService.validateUser(credentials);

		if (user != null) {

			JwtUser jwtUser = new JwtUser(user.getEmail(), new Random().nextInt(1000),
					userService.getRoles(user.getId()));
			String token = jwtGenerator.generate(jwtUser);

			response.setHeader("Token", token);
		}

		return user;
	}

}
