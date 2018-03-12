package com.lifeinsurance.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lifeinsurance.model.Product;

@Service
public interface ProductService {
	
	List<Product> getAll();
	
	Product get(int id);
	
	Product add(Product product);
	
	Product update(int id, Product product);
	
	void delete(int id);

}
