package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RecurringPayment;

public class RecurringPaymentMapper implements RowMapper<RecurringPayment> {

	@Override
	public RecurringPayment mapRow(ResultSet rs, int rowNum) throws SQLException {

		RecurringPayment recuringPayment = new RecurringPayment();

		
		String userName = rs.getString("user_name");
		
		Integer amount = rs.getInt("amount");
		Date paymentDate = rs.getDate("payment_date");

		
		recuringPayment.setDepositUserName(userName);
		
		recuringPayment.setRecurPrincipleAmount(amount);
		recuringPayment.setDepositDate(paymentDate);
		return recuringPayment;

	}

}
