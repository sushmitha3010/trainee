package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class TimeDepositPayment {

	private String userName;
	private Integer amount;
	private Date paymentDate;

	public TimeDepositPayment() {

	}

	public TimeDepositPayment(String userName, Integer amount, Date paymentDate) {
		super();

		this.userName = userName;

		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "TimeDepositPayment [ userName=" + userName + ", accountNo=" + +amount + ", paymentDate=" + paymentDate
				+ "]";
	}

}
