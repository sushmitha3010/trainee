package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class SeniorCitizenPayment {

	private String customerName;
	private Integer depositAmount1;
	private Date paidDate;

	public SeniorCitizenPayment() {

	}

	public SeniorCitizenPayment(String customerName, Integer depositAmount1, Date paidDate) {
		super();

		this.customerName = customerName;

		this.depositAmount1 = depositAmount1;
		this.paidDate = paidDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getDepositAmount1() {
		return depositAmount1;
	}

	public void setDepositAmount1(Integer depositAmount1) {
		this.depositAmount1 = depositAmount1;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	@Override
	public String toString() {
		return "SeniorCitizenPayment [customerId=" + ", customerName=" + customerName + ", cusAccountNo="
				+ ", depositAmount1=" + depositAmount1 + ", paidDate=" + paidDate + "]";
	}

}
