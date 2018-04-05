package com.lifeinsurance.service;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifeinsurance.dao.UserDaoImpl;
import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDao;
	
	public User register(User user) throws ParseException, InternalServerException {
		return userDao.register(user);
	}

	public User validateUser(AuthenticationCredentials credentials) throws NotFoundException {
		return userDao.validateUser(credentials);
	}

	@Override
	public List<String> getRoles(int userId) throws NotFoundException {
		return userDao.getRoles(userId);
	}

	@Override
	public List<User> getAll() throws NotFoundException {
		return userDao.getAll();
	}

	@Override
	public User get(int id) throws NotFoundException {
		return userDao.get(id);
	}

	@Override
	public User update(int id, User user) throws ParseException, NotFoundException, InternalServerException {
		return userDao.update(id, user);
	}

	@Override
	public void delete(int id) throws NotFoundException {
	   userDao.delete(id);
		
	}

	@Override
	public User changePassword(int id, String passObj) throws InternalServerException, NotFoundException {
		return userDao.changePassword(id, passObj);
	}

}
