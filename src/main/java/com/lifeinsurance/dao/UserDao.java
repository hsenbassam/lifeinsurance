package com.lifeinsurance.dao;

import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;

public interface UserDao {
	
	void register(User user);
	
	User validateUser(Login login);

}
