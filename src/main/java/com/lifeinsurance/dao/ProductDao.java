package com.lifeinsurance.dao;

import java.util.List;

import com.lifeinsurance.model.Product;

public interface ProductDao {
	
	List<Product> getAll();
	
	Product get(int id);
	
	Product add(Product product);
	

}
