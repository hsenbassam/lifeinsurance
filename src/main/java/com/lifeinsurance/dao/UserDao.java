package com.lifeinsurance.dao;

import java.text.ParseException;
import java.util.List;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

public interface UserDao {
	
	User register(User user) throws ParseException, InternalServerException;
	
	User validateUser(AuthenticationCredentials credentials) throws NotFoundException;
	
	List<String> getRoles(int userId) throws NotFoundException;
	
	void setRoles(int userId, List<String> roles) throws InternalServerException;
	
	void deleteRoles(int userId) throws InternalServerException;
	
	List<User> getAll() throws NotFoundException;
	
	User get(int id) throws NotFoundException;
	
	User update(int id, User user) throws ParseException, NotFoundException, InternalServerException;
	
	void delete(int id) throws NotFoundException;

	User changePassword(int id, String passObj) throws InternalServerException, NotFoundException;
}
