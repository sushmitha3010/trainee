package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.User;

public class ProfileMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User register=new User();
		
		String uName=rs.getString("user_name");
		register.setUserName(uName);
		
		String pass=rs.getString("password");
		register.setPassword(pass);
		
		Long mobNo=rs.getLong("mobile_no");
		register.setMobileNo(mobNo);
		
		Long acctNo=rs.getLong("account_no");
		register.setAccountNo(acctNo);
		
		String mail=rs.getString("mail_id");
		register.setMailId(mail);
		
		String address=rs.getString("address");
		register.setAddress(address);
		
		return register;
		
	}

}
