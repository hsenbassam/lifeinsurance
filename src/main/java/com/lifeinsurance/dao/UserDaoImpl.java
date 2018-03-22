package com.lifeinsurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lifeinsurance.model.AuthenticationCredentials;
import com.lifeinsurance.model.Product;
import com.lifeinsurance.model.User;
import com.lifeinsurance.dao.UserDao;
import com.lifeinsurance.dao.UserMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User validateUser(AuthenticationCredentials credentials) {

		String sql = "select * from users where username = '" + credentials.getUsername() + "' and password = '"
				+ credentials.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;

	}

	public User register(User user) throws ParseException {
		String sql = "insert into users "
				+ "(username, password, firstname, lastname, email, address, phone, birthday, datecreated) "
				+ " values(?,?,?,?,?,?,?,?,?)";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());
		Date dateCreated = format.parse(user.getDatecreated());
		// String hashPass = passwordEncoder.encode(user.getPassword());

		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(), dateBirthday, dateCreated });

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

		String sql = "update users set firstname = ?, lastname = ?, email = ?, username = ?, password = ?,birthday = ?, address = ?,phone = ? where id = ?";

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());
		
		jdbcTemplate.update(sql, new Object[] { user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getPassword(), dateBirthday, user.getAddress(), user.getPhone(), id });

		return user;
	}

	@Override
	public void delete(int id) {
		
		String sql = "delete from users where id = ?";

		jdbcTemplate.update(sql, new Object[] { id });
		
		
	}

}
