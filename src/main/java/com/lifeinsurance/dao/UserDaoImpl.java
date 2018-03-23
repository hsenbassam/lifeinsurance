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

import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public User validateUser(AuthenticationCredentials credentials) {
		
		String sql = "select * from users where username = '" + credentials.getUsername() + "' and isenabled = true";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		User user = users.size() > 0 ? users.get(0) : null;
		
		if(user != null) {	
			if (passwordEncoder.matches(credentials.getPassword(),user.getPassword()) == false)
				user = null;	
		}
		return user;

	}

	public User register(User user) throws ParseException {
		String sql = "insert into users "
				+ "(username, password, firstname, lastname, email, address, phone, birthday) "
				+ "values(?,?,?,?,?,?,?,?)";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());
		String hashPass = passwordEncoder.encode(user.getPassword());

		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getUsername());
				statement.setString(2, hashPass);
				statement.setString(3, user.getFirstname());
				statement.setString(4, user.getLastname());
				statement.setString(5, user.getEmail());
				statement.setString(6, user.getAddress());
				statement.setString(7, user.getPhone());
				statement.setDate(8, new java.sql.Date(dateBirthday.getTime()));
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
	public List<String> getRoles(int userId) {
		String sql = "SELECT r.name FROM roles AS r INNER JOIN user_roles AS ur ON r.id = ur.role_id "
				+ "INNER JOIN users AS u ON u.id = ur.user_id where u.id= " + userId;
		List<String> roles = jdbcTemplate.queryForList(sql, String.class);
		return roles.size() > 0 ? roles : null;
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

		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public User update(int id, User user) throws ParseException {

		String sql = "update users set firstname = ?, lastname = ?, email = ?, username = ?,birthday = ?, address = ?,phone = ? where id = ?";

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());

		jdbcTemplate.update(sql, new Object[] { user.getFirstname(), user.getLastname(), user.getEmail(),
				user.getUsername(), dateBirthday, user.getAddress(), user.getPhone(), id });

		return user;
	}

	@Override
	public void delete(int id) {

		String sql = "delete from users where id = ?";

		jdbcTemplate.update(sql, new Object[] { id });

	}

}
