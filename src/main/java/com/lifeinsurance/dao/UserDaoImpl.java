package com.lifeinsurance.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;


public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User validateUser(Login login) {
		
		String sql = "select * from users where username = '" +  login.getUsername() + "' and password = '" + login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users.size() > 0 ? users.get(0) : null;
		
	}

	public User register(User user) throws ParseException {
		String sql = "insert into users values(?,?,?,?,?,?,?,?,?)";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date dateBirthday = format.parse(user.getBirthday());
		Date dateCreated = format.parse(user.getDatecreated());
		
		jdbcTemplate.update(sql, new Object[] {
				user.getUsername(), user.getPassword(), 
				user.getFirstname(),user.getLastname(),
				user.getEmail(), user.getAddress(),
				user.getPhone(), dateBirthday,dateCreated});
		
		return user;
		
	}


	
}

