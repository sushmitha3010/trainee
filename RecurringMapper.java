package com.chainsys.postofficemanagement.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.chainsys.postofficemanagement.model.RecurringDepositModel;

public class RecurringMapper implements RowMapper<RecurringDepositModel> {

	@Override
	public RecurringDepositModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		RecurringDepositModel recurringDepsoit = new RecurringDepositModel();
				
		String userName = rs.getString("user_name");
		Long mobileNo = rs.getLong("mobile_no");
		Long accountNo = rs.getLong("account_no");
		Integer principleAmount = rs.getInt("principle_amount");
		Integer noOfMonths = rs.getInt("no_of_months");
		Date depositDate = rs.getDate("deposit_date");
		Date returnDate = rs.getDate("return_date");
		float interest = rs.getInt("interest");
		float matAmount = rs.getInt("maturity_amount");
		float totAMount = rs.getInt("total_amount");
		

		
		recurringDepsoit.setDeposituserName(userName);
		recurringDepsoit.setDepositUserMobileNo(mobileNo);
		recurringDepsoit.setUserAccountNumber(accountNo);
		recurringDepsoit.setDepositAmount(principleAmount);
		recurringDepsoit.setNoOfMonths(noOfMonths);
		recurringDepsoit.setDepositDate(depositDate);
		recurringDepsoit.setDepositReturnDate(returnDate);
		recurringDepsoit.setInterest(interest);
		recurringDepsoit.setMaturityAMount(matAmount);
		recurringDepsoit.setTotalAmount(totAMount);

		
		return recurringDepsoit;
	}
}
