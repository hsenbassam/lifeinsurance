package com.lifeinsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.CartProduct;

public class CartProductDaoImpl implements CartProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<CartProduct> getAll(int userId) throws NotFoundException {
		String sql = "select * from orders where user_id = " + userId + " and pending=true";

		List<CartProduct> products = jdbcTemplate.query(sql, new CartProductMapper());

		if (products.size() == 0)
			throw new NotFoundException("Fetching Shopping Cart Product Failed",
					"There are no products in your cart / user id is incorrect");

		return products.size() > 0 ? products : null;
	}

	@Override
	public CartProduct add(CartProduct product, int userId) throws InternalServerException {
		String sql = "insert into orders(amount, premium, type, coverage, package, user_id) values(?,?,?,?,?,?)";
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		try {
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					statement.setDouble(1, product.getAmount());
					statement.setDouble(2, product.getPremium());
					statement.setString(3, product.getType());
					statement.setString(4, product.getCoverage());
					statement.setString(5, product.getProduct_package());
					statement.setInt(6, userId);
					return statement;
				}
			}, holder);
		} catch (Exception e) {
			throw new InternalServerException("Adding Product to the cart Failed", "An error occured");
		}

		int newId;
		if (holder.getKeys().size() > 1)
			newId = (int) holder.getKeys().get("id");
		else
			newId = holder.getKey().intValue();

		product.setId(newId);

		return product;
	}

	@Override
	public void delete(int id) throws NotFoundException {
		String sql = "delete from orders where id = ?";

		int affectedRows = jdbcTemplate.update(sql, new Object[] { id });
		if (affectedRows == 0)
			throw new NotFoundException("Deleting Product from Cart Failed", "There is no cart product with id " + id);
	}

}
