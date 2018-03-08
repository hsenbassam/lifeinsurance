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

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;
import java.util.Random;

import com.lifeinsurance.model.JwtUser;
import com.lifeinsurance.model.Login;
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
	public @ResponseBody User login(@RequestBody Login login, HttpServletResponse response) {	
		
		User user = userService.validateUser(login);
		
		if (user != null) {

			JwtUser jwtUser = new JwtUser();
			
			jwtUser.setUserName(user.getUsername());
			jwtUser.setRole(userService.getRoles(user.getUsername()));
			jwtUser.setId(new Random().nextInt(1000));
			
			String token = jwtGenerator.generate(jwtUser);
			response.setHeader("Token", token);
		}
	
		
//		if (user != null) {
//			Key key = MacProvider.generateKey();
//	
//			String compactJws = Jwts.builder()
//			  //.setSubject(user.getUsername())
//			  .claim("username", user.getUsername())
//			  .claim("name", user.getFirstname() + " " + user.getLastname())
//			  .claim("admin", true)
//			  .signWith(SignatureAlgorithm.HS512, key)
//			  .compact();
//			
//			System.out.println(compactJws);
//			
//			response.setHeader("Token", compactJws);
//		}
//		else {
//			response.setStatus(401);
//		}
		
		
		return user;
	}

}
