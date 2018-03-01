package com.lifeinsurance.service;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifeinsurance.dao.UserDaoImpl;
import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired 
	UserDaoImpl userDao;
	
	public User register(User user) throws ParseException {
		return userDao.register(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
