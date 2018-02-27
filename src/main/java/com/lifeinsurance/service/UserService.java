package com.lifeinsurance.service;

import java.text.ParseException;

import org.springframework.stereotype.Service;

import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;

@Service
public interface UserService {
	
	User register(User user) throws ParseException;
	
	User validateUser(Login login);

}
