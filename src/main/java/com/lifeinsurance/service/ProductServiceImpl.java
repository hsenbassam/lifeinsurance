package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.ProductDaoImpl;
import com.lifeinsurance.model.Product;

import com.lifeinsurance.service.ProductService;

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

	@Override
	public Product update(int id, Product product) {
		
		return productDao.update(id, product);
	}

	@Override
	public void delete(int id) {
		
	    productDao.delete(id);
	}

	

}
