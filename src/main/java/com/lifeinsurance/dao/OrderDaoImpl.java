package com.lifeinsurance.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.Order;

public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int add(int userId) throws NotFoundException {
		
		String sql = "update orders set pending = false and timestamp = now() where user_id = ?" ;
		
		int ordersCount = jdbcTemplate.update(sql, new Object[] {userId});
		
		if(ordersCount == 0)
			throw new NotFoundException("Adding Order Failed", "There is no user with id = " + userId);

		return ordersCount;
		
	}

	@Override
	public List<Order> getAll() throws NotFoundException {
		
		String sql = "select o.id, o.timestamp, u.firstname, u.lastname, u.email, o.type, o.coverage,o.package as product_package, o.amount, o.premium from orders as o inner join users as u on(u.id = o.user_id) where o.pending=false";
	
		List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
		
		if (orders.size() == 0)
			throw new NotFoundException("Fetching Orders Failed", "There are no Orders");

		return orders.size() > 0 ? orders : null;
	}

	@Override
	public List<Order> getByUserId(int userId) throws NotFoundException {
		String sql = "select id, timestamp, type, coverage, package as product_package, amount, premium from orders where pending=false and user_id=" + userId;
		
		List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Order>(Order.class));
		
		if (orders.size() == 0)
			throw new NotFoundException("Fetching Policies Failed", "There are no Policies for user with id "+ userId);
	
		return orders.size() > 0 ? orders : null;
	}

}
