package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RegisteredPostModel;


public class RegisterViewMapper implements RowMapper<RegisteredPostModel> {

	@Override
	public RegisteredPostModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		RegisteredPostModel registeredPostModel = new RegisteredPostModel();

		
		String status = rs.getString("status");
		
		registeredPostModel.setTrackingStatus(status);
		return registeredPostModel;
}

}