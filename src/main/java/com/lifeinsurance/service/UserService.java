package com.lifeinsurance.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

@Service
public interface UserService {
	
	User register(User user) throws ParseException;

	User validateUser(AuthenticationCredentials credentials);
	
	List<String> getRoles(int userId);
	
	List<User> getAll();
	
	User get(int id);
	
	User update(int id, User user) throws ParseException;
	
	void delete(int id);

}
