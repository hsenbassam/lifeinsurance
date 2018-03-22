package com.lifeinsurance.dao;

import java.text.ParseException;
import java.util.List;

import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

public interface UserDao {
	
	User register(User user) throws ParseException;
	
	User validateUser(AuthenticationCredentials credentials);
	
	List<String> getRoles(int userId);
	

}
