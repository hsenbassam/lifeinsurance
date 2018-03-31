package com.lifeinsurance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lifeinsurance.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> getAll() {
		
		String sql = "select * from products";
				
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		
		return products.size() > 0 ? products : null;
	}
	
	
	public Product get(int id) {
		
		String sql = "select * from products where id =" + id;
		
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		
		return products.size() > 0 ? products.get(0) : null;
	}

	public Product add(Product product) {
		String sql = "insert into products(category_id, description, title, price) values(?,?,?,?)";

		
		jdbcTemplate.update(sql, new Object[] {
				product.getCategory(), product.getDescription(),
				product.getTitle(), product.getPrice()
		});
		
		return product;
	}


	@Override
	public Product update(int id, Product product) {
		
		String sql = "update products set category_id = ?, description = ?, title = ?, price = ? where id = ?";

		
		jdbcTemplate.update(sql, new Object[] {
				product.getCategory(), product.getDescription(),
				product.getTitle(), product.getPrice(), id
		});
		
		return product;
	}


	@Override
	public void delete(int id) {
		
	String sql = "delete from products where id = ?";

		jdbcTemplate.update(sql, new Object[] { id });
		
	}



}
