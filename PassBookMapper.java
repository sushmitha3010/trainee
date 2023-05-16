package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RecurringPayment;


public class PassBookMapper implements RowMapper<RecurringPayment> {

	
	
	RecurringPayment  recurring = new RecurringPayment();
	
	
	@Override
	public RecurringPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		String name=rs.getString("user_name");
		recurring.setDepositUserName(name);
		
		Integer amount=rs.getInt("amount");
		recurring.setRecurPrincipleAmount(amount);
		
		Date payDate =rs.getDate("payment_date");
		recurring.setDepositDate(payDate);
		return recurring;
	}

}
