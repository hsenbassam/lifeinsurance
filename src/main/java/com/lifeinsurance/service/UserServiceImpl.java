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

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public User update(int id, User user) throws ParseException {
		return userDao.update(id, user);
	}

	@Override
	public void delete(int id) {
	   userDao.delete(id);
		
	}

}
