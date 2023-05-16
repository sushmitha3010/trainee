package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class RecurringPayment {

	private String depositUserName;

	private Integer recurPrincipleAmount;
	private Date depositDate;

	public RecurringPayment() {

	}

	public RecurringPayment(String depositUserName, Integer recurPrincipleAmount, Date depositDate) {
		super();
		this.depositUserName = depositUserName;
		this.recurPrincipleAmount = recurPrincipleAmount;
		this.depositDate = depositDate;
	}

	public String getDepositUserName() {
		return depositUserName;
	}

	public void setDepositUserName(String depositUserName) {
		this.depositUserName = depositUserName;
	}

	public Integer getRecurPrincipleAmount() {
		return recurPrincipleAmount;
	}

	public void setRecurPrincipleAmount(Integer recurPrincipleAmount) {
		this.recurPrincipleAmount = recurPrincipleAmount;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	@Override
	public String toString() {
		return "RecurringPayment [depositUserName=" + depositUserName + ", recurPrincipleAmount=" + recurPrincipleAmount
				+ ", depositDate=" + depositDate + "]";
	}

}