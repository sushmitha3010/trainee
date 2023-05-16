package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RegisteredPostPaymentModel;

public class RegisteredPaymentMapper implements RowMapper<RegisteredPostPaymentModel> {

	@Override
	public RegisteredPostPaymentModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		RegisteredPostPaymentModel registeredPayment = new RegisteredPostPaymentModel();

		Integer trackNo = rs.getInt("trcaking_no");
		String senderName = rs.getString("sender_name");
		Date paidDate = rs.getDate("paid_date");
		float amt = rs.getInt("amount");
		String status=rs.getString("status");

		registeredPayment.setRegistertrackNo(trackNo);
		registeredPayment.setRegisteredPostUserName(senderName);
		registeredPayment.setParcelPaidDate(paidDate);
		registeredPayment.setRegisteredPostParcelCharge(amt);
		registeredPayment.setRegisteredPostStatus(status);

		return registeredPayment;

	}


}
