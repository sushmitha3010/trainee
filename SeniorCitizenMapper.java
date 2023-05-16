package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.SeniorCitizenModel;

public class SeniorCitizenMapper implements RowMapper<SeniorCitizenModel> {

	@Override
	public SeniorCitizenModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		SeniorCitizenModel seniorCitizenDepsoit = new SeniorCitizenModel();
		
		String userName = rs.getString(1);
		Long mobileNo = rs.getLong(2);
		Long accountNo = rs.getLong(3);
		Integer principleAmount = rs.getInt(4);
		Integer age=rs.getInt(5);
		Date depositDate = rs.getDate(6);
		Date returnDate =rs.getDate(7);
		float simpleInterest = rs.getInt(8);
		float maturityAmount = rs.getInt(9);
		float totalAMount = rs.getInt(10);
		
		
		
		seniorCitizenDepsoit.setCustomerName(userName);
		seniorCitizenDepsoit.setCustomermobileNo(mobileNo);
		seniorCitizenDepsoit.setCustomeraccountNo(accountNo);
		seniorCitizenDepsoit.setDepositAmount(principleAmount);
		seniorCitizenDepsoit.setAge(age);
		seniorCitizenDepsoit.setAmountDepositDate(depositDate);
		seniorCitizenDepsoit.setSimpleInterest(simpleInterest);
		seniorCitizenDepsoit.setPaymentMaturity(maturityAmount);
		seniorCitizenDepsoit.setAmountTotal(totalAMount);
		seniorCitizenDepsoit.setReturnDate(returnDate);
		
		
		return seniorCitizenDepsoit;
	}

}
