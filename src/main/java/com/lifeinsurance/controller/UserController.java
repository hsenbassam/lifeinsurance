package com.lifeinsurance.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.User;
import com.lifeinsurance.service.UserService;

@Controller
@RequestMapping(produces = { "application/json" }, consumes = { "application/json" })
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody List<User> getUsers() {

		List<User> users = userService.getAll();
		return users;
	}

	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable int id) {
		User user = userService.get(id);
		return user;
	}
	

	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT)
	public @ResponseBody User updateUser(@PathVariable int id, @RequestBody User user) throws ParseException {
		User userUpdated = userService.update(id, user);
		return userUpdated;
	}

	@RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@PathVariable int id, HttpServletResponse response) throws ParseException {
		userService.delete(id);

	}
	
	
	//Password Mgt
	
	@RequestMapping(value = "/api/users/changePassword/{id}", method = RequestMethod.PUT)
	public @ResponseBody User changePassword(@PathVariable int id, @RequestBody String passObj) throws ParseException {

		User userUpdated = userService.changePassword(id, passObj);
		return userUpdated;
	}

}
