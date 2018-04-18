package com.lifeinsurance.service;

import java.util.List;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;

public interface ShoppingCartService {

	List<Order> getAll(int userId) throws NotFoundException;

	Order add(Order product, int userId) throws InternalServerException;

	void delete(int id) throws NotFoundException;

}
