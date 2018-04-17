package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.ShoppingCartDaoImpl;
import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	ShoppingCartDaoImpl shoppingCartDao;

	@Override
	public List<Order> getAll(int userId) throws NotFoundException {
		return shoppingCartDao.getAll(userId);
	}

	@Override
	public Order add(Order product, int userId) throws InternalServerException {
		return shoppingCartDao.add(product, userId);
	}

	@Override
	public void delete(int id) throws NotFoundException {
		shoppingCartDao.delete(id);
	}

}
