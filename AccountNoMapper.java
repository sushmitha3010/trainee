package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.User;

public class AccountNoMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User register = new User();
		Long accountNo = rs.getLong("account_no");
		register.setAccountNo(accountNo);
		return register;
	}

}
