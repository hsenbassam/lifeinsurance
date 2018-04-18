package com.lifeinsurance.service;

import java.util.List;

import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;

public interface OrderService {

	int add(int userId) throws NotFoundException;
	
	List<Order> getAll() throws NotFoundException;
	
	List<Order> getByUserId(int userId) throws NotFoundException;

}
