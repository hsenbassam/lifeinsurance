package com.lifeinsurance.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifeinsurance.dao.UserDaoImpl;
import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDaoImpl userDaoImpl;
	
	//@Transactional
	public void register(User user) {
		userDaoImpl.register(user);
	}

	public User validateUser(Login login) {
		return userDaoImpl.validateUser(login);
	}

}
