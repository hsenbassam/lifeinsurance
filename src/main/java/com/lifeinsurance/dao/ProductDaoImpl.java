package com.lifeinsurance.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lifeinsurance.model.Product;
import com.lifeinsurance.dao.ProductDao;
import com.lifeinsurance.dao.ProductMapper;

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
		String sql = "insert into products(category, description, title, price) values(?,?,?,?)";

		
		jdbcTemplate.update(sql, new Object[] {
				product.getCategory(), product.getDescription(),
				product.getTitle(), product.getPrice()
		});
		
		return product;
	}



}
