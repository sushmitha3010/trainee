package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RegisteredPostModel;



public class TrackingMapper implements RowMapper<RegisteredPostModel> {

	
	
	RegisteredPostModel  register = new RegisteredPostModel();
	
	
	@Override
	public RegisteredPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Integer trcakingNo=rs.getInt("tracking_no");
		register.setTrackingNo(trcakingNo);
		return register;
	}

}
