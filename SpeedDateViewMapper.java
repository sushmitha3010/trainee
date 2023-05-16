package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SpeedPostModel;

public class SpeedDateViewMapper implements RowMapper<SpeedPostModel> {

	@Override
	public SpeedPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SpeedPostModel speedPostModel= new SpeedPostModel();
		speedPostModel.setBookingDate(rs.getDate("booking_date"));
		speedPostModel.setTrackingNo(rs.getInt("tracking_no"));
		
		
		return speedPostModel;
		
	
	}


}
