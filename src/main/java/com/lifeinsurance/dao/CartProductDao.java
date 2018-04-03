package com.lifeinsurance.dao;

import java.util.List;

import com.lifeinsurance.model.CartProduct;

public interface CartProductDao {
	
	List<CartProduct> getAll(int userId);

	CartProduct add(CartProduct product, int userId);

	void delete(int id);

}
