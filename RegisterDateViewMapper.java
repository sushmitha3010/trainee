package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RegisteredPostModel;

public class RegisterDateViewMapper implements RowMapper<RegisteredPostModel> {

	@Override
	public RegisteredPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegisteredPostModel registeredPostModel= new RegisteredPostModel();
		registeredPostModel.setBookingDate(rs.getDate("booking_date"));
		registeredPostModel.setTrackingNo(rs.getInt("tracking_no"));
		
		
		return registeredPostModel;
		
	
	}

}
