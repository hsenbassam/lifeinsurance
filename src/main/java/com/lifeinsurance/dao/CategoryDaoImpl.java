package com.lifeinsurance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lifeinsurance.model.Category;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public List<Category> getAll() {
		
		String sql = "select * from categories";
		
		List<Category> categories = jdbcTemplate.query(sql, new CategoryMapper());
		
		return categories.size() > 0 ? categories : null;
		
	}

}
