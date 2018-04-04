package com.lifeinsurance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lifeinsurance.exception.NotFoundException;

public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int add(int userId) throws NotFoundException {
		
		String sql = "update orders set pending = false where user_id = ?" ;
		
		int ordersCount = jdbcTemplate.update(sql, new Object[] {userId});
		
		if(ordersCount == 0)
			throw new NotFoundException("Adding Order Failed", "There is no user with id = " + userId);

		return ordersCount;
		
	}

}
