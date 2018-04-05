package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.CartProductDaoImpl;
import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.CartProduct;

public class CartProductServiceImpl implements CartProductService {
	
	@Autowired
	CartProductDaoImpl cartproductDao;

	@Override
	public List<CartProduct> getAll(int userId) throws NotFoundException {
		return cartproductDao.getAll(userId);
	}

	@Override
	public CartProduct add(CartProduct product, int userId) throws InternalServerException {
		return cartproductDao.add(product, userId);
	}

	@Override
	public void delete(int id) throws NotFoundException {
		cartproductDao.delete(id);
	}

}
