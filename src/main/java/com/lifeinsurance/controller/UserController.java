package com.lifeinsurance.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.User;
import com.lifeinsurance.service.UserService;

@Controller
@RequestMapping(value = "/api/users", produces = "application/json" , consumes = "application/json")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody List<User> getUsers() {

		List<User> users = userService.getAll();
		return users;
	}

	@GetMapping("{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		User user = userService.get(id);
		return user;
	}
	

	@PutMapping("{id}")
	public @ResponseBody User updateUser(@PathVariable int id, @RequestBody User user) throws ParseException {
		User userUpdated = userService.update(id, user);
		return userUpdated;
	}

	@DeleteMapping("{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable int id, HttpServletResponse response) throws ParseException {
		userService.delete(id);

	}
	
	
	//Password Management
	
	@PutMapping("changePassword/{id}")
	public @ResponseBody User changePassword(@PathVariable int id, @RequestBody String passObj) throws ParseException {

		User userUpdated = userService.changePassword(id, passObj);
		return userUpdated;
	}

}
