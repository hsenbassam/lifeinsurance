package com.lifeinsurance.service;

import org.springframework.stereotype.Service;

import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;

@Service
public interface UserService {
	
	void register(User user);
	
	User validateUser(Login login);

}
