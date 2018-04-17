package com.lifeinsurance.dao;

import java.util.List;

import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;

public interface OrderDao {
	
	int add(int userId) throws NotFoundException;
	
	List<Order> getAll() throws NotFoundException;

}
