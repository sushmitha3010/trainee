package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SeniorCitizenPayment;



public class SeniorPassBookMapper implements RowMapper<SeniorCitizenPayment> {

	
	
	SeniorCitizenPayment  senior = new SeniorCitizenPayment();
	
	
	@Override
	public SeniorCitizenPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String name=rs.getString("user_name");
		senior.setCustomerName(name);
		
		Integer amount=rs.getInt("amount");
		senior.setDepositAmount1(amount);
		
		Date payDate =rs.getDate("payment_date");
		senior.setPaidDate(payDate);
		return senior;
	}


}
