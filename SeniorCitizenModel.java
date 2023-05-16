package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class SeniorCitizenModel {

	private String customerName;
	private Long customermobileNo;
	private Long customeraccountNo;
	private Integer depositAmount;
	private Integer age;
	private Date amountDepositDate;
	private Date returnDate;
	private float simpleInterest;
	private float paymentMaturity;
	private float amountTotal;

	public SeniorCitizenModel() {

	}

	public SeniorCitizenModel(String customerName, Long customermobileNo, Long customeraccountNo, Integer depositAmount,
			Integer age) {
		super();
		this.customerName = customerName;
		this.customermobileNo = customermobileNo;
		this.customeraccountNo = customeraccountNo;
		this.depositAmount = depositAmount;
		this.age = age;
	}

	public SeniorCitizenModel(Date amountDepositDate, Date returnDate, float simpleInterest, float paymentMaturity,
			float amountTotal) {
		super();
		this.amountDepositDate = amountDepositDate;
		this.returnDate = returnDate;
		this.simpleInterest = simpleInterest;
		this.paymentMaturity = paymentMaturity;
		this.amountTotal = amountTotal;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public float getSimpleInterest() {
		return simpleInterest;
	}

	public void setSimpleInterest(float simpleInterest) {
		this.simpleInterest = simpleInterest;
	}

	public float getPaymentMaturity() {
		return paymentMaturity;
	}

	public void setPaymentMaturity(float paymentMaturity) {
		this.paymentMaturity = paymentMaturity;
	}

	public float getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(float amountTotal) {
		this.amountTotal = amountTotal;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomermobileNo() {
		return customermobileNo;
	}

	public void setCustomermobileNo(Long customermobileNo) {
		this.customermobileNo = customermobileNo;
	}

	public Long getCustomeraccountNo() {
		return customeraccountNo;
	}

	public void setCustomeraccountNo(Long customeraccountNo) {
		this.customeraccountNo = customeraccountNo;
	}

	public Integer getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Integer depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getAmountDepositDate() {
		return amountDepositDate;
	}

	public void setAmountDepositDate(Date amountDepositDate) {
		this.amountDepositDate = amountDepositDate;
	}

	@Override
	public String toString() {
		return "SeniorCitizenModel [customerName=" + customerName + ", customermobileNo=" + customermobileNo
				+ ", customeraccountNo=" + customeraccountNo + ", depositAmount=" + depositAmount + ", age=" + age
				+ ", amountDepositDate=" + amountDepositDate + ", returnDate=" + returnDate + ", simpleInterest="
				+ simpleInterest + ", paymentMaturity=" + paymentMaturity + ", amountTotal=" + amountTotal + "]";
	}

}