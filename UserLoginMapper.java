package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.User;

public class UserLoginMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User register = new User();
		String userName = rs.getString("user_name");
		register.setUserName(userName);
		String password = rs.getString("password");
		register.setPassword(password);
		Long mobileNo = rs.getLong("mobile_no");
		register.setMobileNo(mobileNo);
		Long accoutNo = rs.getLong("account_no");
		register.setAccountNo(accoutNo);
		return register;
	}

}
