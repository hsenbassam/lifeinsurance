package com.lifeinsurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.lifeinsurance.model.Login;
import com.lifeinsurance.model.User;
import com.lifeinsurance.dao.UserDao;
import com.lifeinsurance.dao.UserMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public User validateUser(Login login) {
		
		String sql = "select * from users where username = '" +  login.getUsername() + "' and password = '" + login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users.size() > 0 ? users.get(0) : null;
		
	}
	
//	
//	public User findUserInfo(String username) {
//		
//		String sql = "select * from users where username = '" +  username +  "'";
//		List<User> users = jdbcTemplate.query(sql, new UserMapper());
//		
//		return users.size() > 0 ? users.get(0) : null;
//		
//	}
	
	

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


	@Override
	public List<String> getRoles(String username) {
		String sql = "select role from user_roles where username = '" +  username +  "'";
		List<String> roles = jdbcTemplate.queryForList(sql, String.class );
		return roles.size() > 0 ? roles : null;
	}
	
	
}

