package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.ProductDaoImpl;
import com.lifeinsurance.model.Product;

public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductDaoImpl productDao;

	public List<Product> getAll() {
		
		return productDao.getAll();
	}
	
	public Product get(int id) {
		return productDao.get(id);
	}

	public Product add(Product product) {
		
		return productDao.add(product);
	}

	

}
