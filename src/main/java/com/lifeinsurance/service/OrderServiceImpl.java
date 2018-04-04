package com.lifeinsurance.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.OrderDaoImpl;
import com.lifeinsurance.exception.NotFoundException;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDaoImpl orderDao;


	@Override
	public int add(int userId) throws NotFoundException {
		return orderDao.add(userId);
	}

}
