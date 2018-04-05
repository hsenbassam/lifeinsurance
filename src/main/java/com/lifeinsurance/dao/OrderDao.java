package com.lifeinsurance.dao;

import com.lifeinsurance.exception.NotFoundException;

public interface OrderDao {
	
	int add(int userId) throws NotFoundException;

}
