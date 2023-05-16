package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class TimeDepositModel {

	private String name;
	private Long phoneNo;
	private Long accountNo;
	private Integer amount;
	private Integer periods;
	private Date depositDate;
	private Date completedate;
	private double simpleInterest;
	private float maturity;
	private float total;

	public TimeDepositModel() {

	}

	public TimeDepositModel(String name, Long phoneNo, Long accountNo, Integer amount, Integer periods) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.accountNo = accountNo;
		this.amount = amount;
		this.periods = periods;
	}

	public TimeDepositModel(Date depositDate, Date completedate, double simpleInterest, float maturity, float total) {
		super();
		this.depositDate = depositDate;
		this.completedate = completedate;
		this.simpleInterest = simpleInterest;
		this.maturity = maturity;
		this.total = total;
	}

	public Date getCompletedate() {
		return completedate;
	}

	public void setCompletedate(Date completedate) {
		this.completedate = completedate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public double getSimpleInterest() {
		return simpleInterest;
	}

	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}

	public float getMaturity() {
		return maturity;
	}

	public void setMaturity(float maturity) {
		this.maturity = maturity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "TimeDepositModel [name=" + name + ", phoneNo=" + phoneNo + ", accountNo=" + accountNo + ", amount="
				+ amount + ", periods=" + periods + ", depositDate=" + depositDate + ", completedate=" + completedate
				+ ", simpleInterest=" + simpleInterest + ", maturity=" + maturity + ", total=" + total + "]";
	}

}
