package com.lifeinsurance.service;

import java.util.List;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.CartProduct;

public interface CartProductService {

	List<CartProduct> getAll(int userId) throws NotFoundException;

	CartProduct add(CartProduct product, int userId) throws InternalServerException;

	void delete(int id) throws NotFoundException;

}
