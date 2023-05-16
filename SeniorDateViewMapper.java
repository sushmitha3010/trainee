package com.chainsys.postofficemanagement.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SeniorCitizenModel;

public class SeniorDateViewMapper implements RowMapper<SeniorCitizenModel> {

	@Override
	public SeniorCitizenModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		SeniorCitizenModel seniuCitizenModel= new SeniorCitizenModel();
		seniuCitizenModel.setAmountDepositDate(rs.getDate("deposit_date"));
		seniuCitizenModel.setReturnDate(rs.getDate("return_date"));
		
		
		return seniuCitizenModel;
	}	

}
