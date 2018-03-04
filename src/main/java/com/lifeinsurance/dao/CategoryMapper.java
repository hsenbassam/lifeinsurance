package com.lifeinsurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lifeinsurance.model.Category;


public class CategoryMapper implements RowMapper<Category> {

	public Category mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Category category = new Category();
		
		category.setId(rs.getLong("id"));
		category.setName(rs.getString("name"));
	
		
		return category;
		
	}
	
}
