package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.TimeDepositPayment;

public class TimePaymentMapper implements RowMapper<TimeDepositPayment> {

	@Override
	public TimeDepositPayment mapRow(ResultSet rs, int rowNum) throws SQLException {

		TimeDepositPayment timePayment= new TimeDepositPayment();
		
	
		String userName = rs.getString("user_name");
		
		Integer amount = rs.getInt("amount");
		Date paymentDate = rs.getDate("payment_date");

	
		timePayment.setUserName(userName);
		
		timePayment.setAmount(amount);
		timePayment.setPaymentDate(paymentDate);

		
		return timePayment;

	}

}
