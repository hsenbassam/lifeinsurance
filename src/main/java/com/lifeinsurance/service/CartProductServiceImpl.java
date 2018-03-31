package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.CartProductDaoImpl;
import com.lifeinsurance.model.CartProduct;

public class CartProductServiceImpl implements CartProductService {
	
	@Autowired
	CartProductDaoImpl cartproductDao;

	@Override
	public List<CartProduct> getAll(int userId) {
		return cartproductDao.getAll(userId);
	}

	@Override
	public CartProduct add(CartProduct product, int userId) {
		return cartproductDao.add(product, userId);
	}

	@Override
	public void delete(int id) {
		cartproductDao.delete(id);
	}

}
