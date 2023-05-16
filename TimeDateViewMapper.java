package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.TimeDepositModel;

public class TimeDateViewMapper implements RowMapper<TimeDepositModel> {

	@Override
	public TimeDepositModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		TimeDepositModel timeDepositModel= new TimeDepositModel();
		timeDepositModel.setDepositDate(rs.getDate("deposit_date"));
		timeDepositModel.setCompletedate(rs.getDate("return_date"));
		
		
		return timeDepositModel;
	}	

}
