package com.lifeinsurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lifeinsurance.model.CartProduct;

public class CartProductMapper implements RowMapper<CartProduct> {

	@Override
	public CartProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CartProduct product = new CartProduct();
		
		product.setId(rs.getInt("id"));
		product.setAmount(rs.getDouble("amount"));
		product.setCoverage(rs.getString("coverage"));
		product.setPremium(rs.getDouble("premium"));
		product.setType(rs.getString("type"));
		product.setProduct_package(rs.getString("package"));
		
		return product;
	}



}
