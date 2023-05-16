package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;




import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SpeedPostModel;

public class SpeedMapper implements RowMapper<SpeedPostModel> {

	@Override
	public SpeedPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		SpeedPostModel speedPost = new SpeedPostModel();
		
		String senderName = rs.getString("sender_name");
		Long senderMobileNo = rs.getLong("sender_mobile_no");
		String senderAddress = rs.getString("sender_address");

		float kms = rs.getFloat("distance");
		String receiverName = rs.getString("receiver_name");
		Long receiverMobileNo = rs.getLong("receiver_mobile_no");
		String receiverAddress = rs.getString("receiver_address");
		Date bookingDate = rs.getDate("booking_date");
		Integer trackingNo = rs.getInt("tracking_no");
		String status = rs.getString("status");
		float charge = rs.getFloat("parcel_charge");
		

		speedPost.setSenderName(senderName);
		speedPost.setSenderMobileNo(senderMobileNo);
		speedPost.setSenderAddress(senderAddress);
		speedPost.setKms(kms);
		speedPost.setReceiverName(receiverName);
		speedPost.setReceiverMobileNo(receiverMobileNo);
		speedPost.setReceiverAddress(receiverAddress);
		speedPost.setBookingDate(bookingDate);
		speedPost.setTrackingNo(trackingNo);
		speedPost.setStatus(status);
		speedPost.setCharge(charge);

		
		return speedPost;
	}
}
