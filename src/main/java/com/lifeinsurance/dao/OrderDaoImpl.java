package com.lifeinsurance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int add(int userId) {
		
		String sql = "update orders set pending = false where user_id = ?" ;
		
		int ordersCount = jdbcTemplate.update(sql, new Object[] {userId});

		return ordersCount;
		
	}

}
