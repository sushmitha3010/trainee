package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.TimeDepositPayment;

public class PassTimeBookMapper  implements RowMapper<TimeDepositPayment> {

	
	
	TimeDepositPayment  time = new TimeDepositPayment();
	
	
	@Override
	public TimeDepositPayment mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		
		Integer amount=rs.getInt("amount");
		time.setAmount(amount);
		
		Date payDate =rs.getDate("payment_date");
		time.setPaymentDate(payDate);
		
		return time;
	}

}
