package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SeniorCitizenPayment;

public class SeniorCitizenPaymentMapper implements RowMapper<SeniorCitizenPayment> {

	@Override
	public SeniorCitizenPayment mapRow(ResultSet rs, int rowNum) throws SQLException {

		SeniorCitizenPayment seniorPayment= new SeniorCitizenPayment();
		
		
		String userName = rs.getString("user_name");
		
		Integer amount = rs.getInt("amount");
		Date paymentDate = rs.getDate("payment_date");

		
		seniorPayment.setCustomerName(userName);
		
		seniorPayment.setDepositAmount1(amount);
		seniorPayment.setPaidDate(paymentDate);

		
		return seniorPayment;

	}


}
