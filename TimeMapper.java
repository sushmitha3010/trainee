package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.TimeDepositModel;

public class TimeMapper implements RowMapper<TimeDepositModel> {

	@Override
	public TimeDepositModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		TimeDepositModel timeDeposit = new TimeDepositModel();
		
	
		String userName = rs.getString("user_name");
		Long mobileNo = rs.getLong("mobile_no");
		Long accountNo = rs.getLong("account_no");
		Integer principleAmount = rs.getInt("principle_amount");
		Integer periods = rs.getInt("periods");
		Date date=rs.getDate("deposit_date");
		Date returnDate = rs.getDate("return_date");
		float interest = rs.getInt("interest");
		float matAmount = rs.getInt("maturity_amount");
		float totAMount = rs.getInt("total_amount");
		

		
		timeDeposit.setName(userName);
		timeDeposit.setPhoneNo(mobileNo);
		timeDeposit.setAccountNo(accountNo);
		timeDeposit.setAmount(principleAmount);
		timeDeposit.setPeriods(periods);
		timeDeposit.setDepositDate(date);
		timeDeposit.setSimpleInterest(interest);
		timeDeposit.setMaturity(matAmount);
		timeDeposit.setTotal(totAMount);
		timeDeposit.setCompletedate(returnDate);
		

		
		return timeDeposit;
	}

}
