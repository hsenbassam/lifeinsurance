package com.lifeinsurance.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDaoImpl orderDao;


	@Override
	public int add(int userId) {
		return orderDao.add(userId);
	}

}
