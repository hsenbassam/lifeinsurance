package com.lifeinsurance.service;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifeinsurance.dao.UserDaoImpl;
import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDao;
	
	public User register(User user) throws ParseException {
		return userDao.register(user);
	}

	public User validateUser(AuthenticationCredentials credentials) {
		return userDao.validateUser(credentials);
	}

	@Override
	public List<String> getRoles(int userId) {
		return userDao.getRoles(userId);
	}

}
