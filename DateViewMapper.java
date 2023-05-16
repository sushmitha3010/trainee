package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RecurringDepositModel;


public class DateViewMapper implements RowMapper<RecurringDepositModel> {

	@Override
	public RecurringDepositModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		RecurringDepositModel recurringDepositModel= new RecurringDepositModel();
		recurringDepositModel.setDepositDate(rs.getDate("deposit_date"));
		recurringDepositModel.setDepositReturnDate(rs.getDate("return_date"));
		
		
		return recurringDepositModel;
		
	
	}

}
