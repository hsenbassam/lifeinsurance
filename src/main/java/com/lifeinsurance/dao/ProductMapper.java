package com.lifeinsurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lifeinsurance.model.Product;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Product product = new Product();
		
		product.setId(rs.getLong("id"));
		product.setCategory(rs.getLong("category_id"));
		product.setDescription(rs.getString("description"));
		product.setTitle(rs.getString("title"));
		product.setPrice(rs.getInt("price"));
		
		return product;
		
	}
	
	

}
