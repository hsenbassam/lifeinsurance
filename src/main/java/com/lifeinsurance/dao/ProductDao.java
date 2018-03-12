package com.lifeinsurance.dao;

import java.util.List;

import com.lifeinsurance.model.Product;

public interface ProductDao {
	
	List<Product> getAll();
	
	Product get(int id);
	
	Product add(Product product);
	
	Product update(int id, Product product);
	
	void delete(int id);

}
