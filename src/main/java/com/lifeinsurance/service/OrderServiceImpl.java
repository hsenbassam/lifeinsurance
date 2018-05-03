package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import com.lifeinsurance.dao.OrderDaoImpl;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDaoImpl orderDao;


	@Override
	public int add(int userId) throws NotFoundException {
		return orderDao.add(userId);
	}


	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public List<Order>  getAll() throws NotFoundException {
		return orderDao.getAll();
	}


	@Override
	public List<Order> getByUserId(int userId) throws NotFoundException {
		return orderDao.getByUserId(userId);
	}

}
