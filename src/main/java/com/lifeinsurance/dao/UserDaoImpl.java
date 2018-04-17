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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lifeinsurance.exception.InternalServerException;
import com.lifeinsurance.exception.NotFoundException;
import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PasswordEncoder passwordEncoder;

	public User validateUser(AuthenticationCredentials credentials) throws NotFoundException {

		String sql = "select * from users where email = '" + credentials.getEmail() + "' and isenabled = true";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		User user = users.size() > 0 ? users.get(0) : null;

		if (user == null
				|| user != null && passwordEncoder.matches(credentials.getPassword(), user.getPassword()) == false) {
			throw new NotFoundException("Login Failed", "Username or Password Not Found");
		}
		return user;

	}

	public User register(User user) throws ParseException, InternalServerException {
		String sql = "insert into users (email, password, firstname, lastname, address, phone, birthday) "
				+ "values(?,?,?,?,?,?,?)";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());
		String hashPass = passwordEncoder.encode(user.getPassword());
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		try {
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
		} catch (Exception e) {
			throw new InternalServerException("Registration Failed", "Username already exists");
		}

		int newId;
		if (holder.getKeys().size() > 1)
			newId = (int) holder.getKeys().get("id");
		else
			newId = holder.getKey().intValue();

		user.setId(newId);

		return user;
	}

	@Override
	public List<User> getAll() throws NotFoundException {

		String sql = "select * from users";

		List<User> users = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<User>(User.class));
		
		if (users.size() == 0)
			throw new NotFoundException("Fetching User Failed", "There are no users");

		return users.size() > 0 ? users : null;

	}

	@Override
	public User get(int id) throws NotFoundException {
		String sql = "select * from users where id =" + id;

		List<User> users = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<User>(User.class));

		if (users.size() == 0)
			throw new NotFoundException("Fetching User Failed", "There is no user with id = " + id);

		List<String> roles = users.size() > 0 ? this.getRoles(users.get(0).getId()) : null;

		users.get(0).setRoles(roles);

		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public User update(int id, User user) throws ParseException, NotFoundException, InternalServerException {

		String sql = "update users set firstname = ?, lastname = ?, email = ?,birthday = ?, address = ?,phone = ?, isenabled = ? where id = ?";
		Date dateBirthday = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(user.getBirthday());
		int affectedRows = jdbcTemplate.update(sql, new Object[] { user.getFirstname(), user.getLastname(),
				user.getEmail(), dateBirthday, user.getAddress(), user.getPhone(), user.isEnabled(), id });
		if (affectedRows == 0)
			throw new NotFoundException("Updating User Failed", "There is no user with id = " + id);

		if (user.getRoles() != null && !this.getRoles(id).equals(user.getRoles())) {
			this.deleteRoles(id);
			this.setRoles(id, user.getRoles());
		}

		return user;
	}

	@Override
	public void delete(int id) throws NotFoundException {

		String sql = "delete from users where id = ?";

		int affectedRows = jdbcTemplate.update(sql, new Object[] { id });

		if (affectedRows == 0)
			throw new NotFoundException("Deleting User Failed", "There is no user with id = " + id);

	}

	@Override
	public User changePassword(int id, String passObj) throws InternalServerException, NotFoundException {
		JsonObject jsonPassObject = new Gson().fromJson(passObj, JsonObject.class);
		String newPass = jsonPassObject.get("newpass").getAsString();
		String oldPass = jsonPassObject.get("oldpass").getAsString();

		String sql = "select * from users where id = " + id;
		List<User> users = jdbcTemplate.query(sql,  new BeanPropertyRowMapper<User>(User.class));
		User user = users.size() > 0 ? users.get(0) : null;

		if (user == null)
			throw new NotFoundException("Changing Password Failed", "There is no user with id = " + id);

		if (user != null && passwordEncoder.matches(oldPass, user.getPassword()) == false)
			throw new InternalServerException("Changing Password Failed", "Old Password is Incorrect");

		sql = "update users set password = ? where id = ?";
		String hashPass = passwordEncoder.encode(newPass);

		int affectedRows = jdbcTemplate.update(sql, new Object[] { hashPass, id });
		if (affectedRows > 0) {
			user.setPassword(hashPass);
			return user;
		} else
			throw new InternalServerException("Changing Password Failed", "An error occured");

	}

	@Override
	public List<String> getRoles(int userId) throws NotFoundException {
		String sql = "SELECT r.name FROM roles AS r INNER JOIN user_roles AS ur ON r.id = ur.role_id "
				+ "INNER JOIN users AS u ON u.id = ur.user_id where u.id= " + userId;
		List<String> roles = jdbcTemplate.queryForList(sql, String.class);
		
		if (roles.size() == 0)
			throw new NotFoundException("Fetching User Roles Failed", "There are no roles for the user with id = " + userId);

		return roles.size() > 0 ? roles : null;
	}

	@Override
	public void setRoles(int userId, List<String> roles) throws InternalServerException {

		String sql = "insert into user_roles (user_id, role_id) values(?, (select id from roles where name =?))";

		for (String role : roles) {
			if(jdbcTemplate.update(sql, new Object[] { userId, role }) == 0)
				throw new InternalServerException("Setting Role Failed", "An error occured");
		}

	}

	@Override
	public void deleteRoles(int userId) throws InternalServerException {

		String sql = "delete from user_roles where user_id = ?";

		int affectedRows = jdbcTemplate.update(sql, new Object[] { userId });
		
		if(affectedRows == 0)
			throw new InternalServerException("Deleting Role Failed", "An error occured");

	}

}
