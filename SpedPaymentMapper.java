package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SpeedPostPaymentModel;

public class SpedPaymentMapper implements RowMapper<SpeedPostPaymentModel> {

	@Override
	public SpeedPostPaymentModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		SpeedPostPaymentModel speedPayment = new SpeedPostPaymentModel();

		
		String senderName = rs.getString("sender_name");
		float amount = rs.getInt("amount");
		Integer trackNo = rs.getInt("tracking_no");
		Date paidDate = rs.getDate("paid_date");
		String status = rs.getString("status");

		
		speedPayment.setPostSenderName(senderName);
		speedPayment.setCharge(amount);
		speedPayment.setTrackingNo(trackNo);
		speedPayment.setPayDate(paidDate);
		speedPayment.setSpeedPostStatus(status);

		return speedPayment;

	}


}
