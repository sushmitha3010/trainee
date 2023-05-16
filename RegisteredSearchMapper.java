package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RegisteredPostModel;

public class RegisteredSearchMapper implements RowMapper<RegisteredPostModel> {

	@Override
	public RegisteredPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		RegisteredPostModel registerPost = new RegisteredPostModel();
		
		String sendUserName = rs.getString("sender_name");
		Long sendUserMobileNo = rs.getLong("sender_mobile_no");
		String sendUserAddress = rs.getString("sender_address");
		float weight = rs.getFloat("parcel_weight");
		String receiveUserName = rs.getString("receiver_name");
		Long receiveUserMobileNo = rs.getLong("receiver_mobile_no");
		String receiveUserAddress = rs.getString("receiver_address");
		Date parcelBookingDate = rs.getDate("booking_date");
		Integer trackingCode = rs.getInt("tracking_no");
		String parcelStatus = rs.getString("status");

		registerPost.setSendUserName(sendUserName);
		registerPost.setSendUserMobileNo(sendUserMobileNo);
		registerPost.setSendUserAddress(sendUserAddress);
		
		registerPost.setParcelWeight(weight);
		registerPost.setReceiveUserName(receiveUserName);
		registerPost.setReceiveUserMobileNo(receiveUserMobileNo);
		registerPost.setReceiveUserAddress(receiveUserAddress);
		registerPost.setBookingDate(parcelBookingDate);
		registerPost.setTrackingNo(trackingCode);
		registerPost.setTrackingStatus(parcelStatus);

		
		return registerPost;
	}


}
