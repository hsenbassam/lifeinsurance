package com.lifeinsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PasswordEncoder passwordEncoder;

	public User validateUser(AuthenticationCredentials credentials) {

		String sql = "select * from users where email = '" + credentials.getEmail() + "' and isenabled = true";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		User user = users.size() > 0 ? users.get(0) : null;

		if (user != null) {
			if (passwordEncoder.matches(credentials.getPassword(), user.getPassword()) == false)
				user = null;
		}
		return user;

	}

	public User register(User user) throws ParseException {
		String sql = "insert into users (email, password, firstname, lastname, address, phone, birthday) "
				+ "values(?,?,?,?,?,?,?)";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());
		String hashPass = passwordEncoder.encode(user.getPassword());

		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getEmail());
				statement.setString(2, hashPass);
				statement.setString(3, user.getFirstname());
				statement.setString(4, user.getLastname());
				statement.setString(5, user.getAddress());
				statement.setString(6, user.getPhone());
				statement.setDate(7, new java.sql.Date(dateBirthday.getTime()));
				return statement;
			}
		}, holder);

		int newId;
		if (holder.getKeys().size() > 1)
			newId = (int) holder.getKeys().get("id");
		else
			newId = holder.getKey().intValue();

		user.setId(newId);

		return user;
	}

	@Override
	public List<User> getAll() {

		String sql = "select * from users";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users : null;

	}

	@Override
	public User get(int id) {
		String sql = "select * from users where id =" + id;

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		List<String> roles = users.size() > 0 ? this.getRoles(users.get(0).getId()) : null;

		users.get(0).setRoles(roles);

		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public User update(int id, User user) throws ParseException {

		if (user.getRoles() != null && !this.getRoles(id).equals(user.getRoles())) {
			System.out.println(user.getRoles());
			this.deleteRoles(id);
			this.setRoles(id, user.getRoles());
		}
		String sql = "update users set firstname = ?, lastname = ?, email = ?,birthday = ?, address = ?,phone = ?, isenabled = ? where id = ?";

		Date dateBirthday = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(user.getBirthday());
		jdbcTemplate.update(sql, new Object[] { user.getFirstname(), user.getLastname(), user.getEmail(), dateBirthday,
				user.getAddress(), user.getPhone(), user.isEnabled(), id });
		return user;
	}

	@Override
	public void delete(int id) {

		String sql = "delete from users where id = ?";

		jdbcTemplate.update(sql, new Object[] { id });

	}

	@Override
	public User changePassword(int id, String passObj) {
		JsonObject jsonPassObject = new Gson().fromJson(passObj, JsonObject.class);
		String newPass = jsonPassObject.get("newpass").getAsString();
		String oldPass = jsonPassObject.get("oldpass").getAsString();

		String sql = "select * from users where id = " + id;
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		User user = users.size() > 0 ? users.get(0) : null;

		if (user == null) {
			System.out.println("User Not found");
			return null;
		}

		if (user != null && passwordEncoder.matches(oldPass, user.getPassword()) == false) {
			System.out.println("Old Password is Incorrect");
			return null;
		}

		sql = "update users set password = ? where id = ?";
		String hashPass = passwordEncoder.encode(newPass);

		int affectedRows = jdbcTemplate.update(sql, new Object[] { hashPass, id });
		if (affectedRows > 0) {
			user.setPassword(hashPass);
			return user;
		}
		return null;

	}

	@Override
	public List<String> getRoles(int userId) {
		String sql = "SELECT r.name FROM roles AS r INNER JOIN user_roles AS ur ON r.id = ur.role_id "
				+ "INNER JOIN users AS u ON u.id = ur.user_id where u.id= " + userId;
		List<String> roles = jdbcTemplate.queryForList(sql, String.class);
		return roles.size() > 0 ? roles : null;
	}

	@Override
	public void setRoles(int userId, List<String> roles) {
		
		String sql = "insert into user_roles (user_id, role_id) values(?, (select id from roles where name =?))";
		
		for (String role : roles) {
			jdbcTemplate.update(sql, new Object[] { userId, role });
		}
			
	}

	@Override
	public void deleteRoles(int userId) {

		String sql = "delete from user_roles where user_id = ?";

		jdbcTemplate.update(sql, new Object[] { userId });

	}

}
