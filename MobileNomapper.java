package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.User;

public class MobileNomapper implements RowMapper<User> {

	
	@Autowired
	User  register;
	
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Long acctNo=rs.getLong("account_no");
		
		register.setAccountNo(acctNo);
		
		return register;
	}

}
