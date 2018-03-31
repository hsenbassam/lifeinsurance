package com.lifeinsurance.service;

import java.util.List;

import com.lifeinsurance.model.CartProduct;

public interface CartProductService {

	List<CartProduct> getAll(int userId);

	CartProduct add(CartProduct product, int userId);

	void delete(int id);

}
