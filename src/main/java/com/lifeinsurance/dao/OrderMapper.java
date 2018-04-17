package com.lifeinsurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lifeinsurance.model.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order order = new Order();
		
		order.setId(rs.getInt("id"));
		order.setFirstname(rs.getString("firstname"));
		order.setLastname(rs.getString("lastname"));
		order.setEmail(rs.getString("email"));
		order.setAmount(rs.getDouble("amount"));
		order.setCoverage(rs.getString("coverage"));
		order.setPremium(rs.getDouble("premium"));
		order.setType(rs.getString("type"));
		order.setProduct_package(rs.getString("package"));
		
		return order;
	}



}
