package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class RecurringDepositModel {
	private String deposituserName;
	private Long depositUserMobileNo;
	private Long userAccountNumber;
	private Integer depositAmount;
	private Integer noOfMonths;
	private Integer noOfMonthsToBePaid;
	private Date depositDate;
	private Date depositReturnDate;
	private float interest;
	private float maturityAMount;
	private float totalAmount;

	public RecurringDepositModel() {

	}

	public RecurringDepositModel(String deposituserName, Long depositUserMobileNo, Long userAccountNumber,
			Integer depositAmount, Integer noOfMonths, Integer noOfMonthsToBePaid) {
		super();
		this.deposituserName = deposituserName;
		this.depositUserMobileNo = depositUserMobileNo;
		this.userAccountNumber = userAccountNumber;
		this.depositAmount = depositAmount;
		this.noOfMonths = noOfMonths;
		this.noOfMonthsToBePaid = noOfMonthsToBePaid;
	}

	public RecurringDepositModel(Date depositDate, Date depositReturnDate, float interest, float maturityAMount,
			float totalAmount) {
		super();
		this.depositDate = depositDate;
		this.depositReturnDate = depositReturnDate;
		this.interest = interest;
		this.maturityAMount = maturityAMount;
		this.totalAmount = totalAmount;
	}

	public Integer getNoOfMonthsToBePaid() {
		return noOfMonthsToBePaid;
	}

	public void setNoOfMonthsToBePaid(Integer noOfMonthsToBePaid) {
		this.noOfMonthsToBePaid = noOfMonthsToBePaid;
	}

	public Date getDepositReturnDate() {
		return depositReturnDate;
	}

	public void setDepositReturnDate(Date depositReturnDate) {
		this.depositReturnDate = depositReturnDate;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public float getMaturityAMount() {
		return maturityAMount;
	}

	public void setMaturityAMount(float maturityAMount) {
		this.maturityAMount = maturityAMount;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDeposituserName() {
		return deposituserName;
	}

	public void setDeposituserName(String deposituserName) {
		this.deposituserName = deposituserName;
	}

	public Long getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(Long userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

	public Long getDepositUserMobileNo() {
		return depositUserMobileNo;
	}

	public void setDepositUserMobileNo(Long depositUserMobileNo) {
		this.depositUserMobileNo = depositUserMobileNo;
	}

	public Integer getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(Integer depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Integer getNoOfMonths() {
		return noOfMonths;
	}

	public void setNoOfMonths(Integer noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	@Override
	public String toString() {
		return "RecurringDepositModel [deposituserName=" + deposituserName + ", depositUserMobileNo="
				+ depositUserMobileNo + ", userAccountNumber=" + userAccountNumber + ", depositAmount=" + depositAmount
				+ ", noOfMonths=" + noOfMonths + ", noOfMonthsToBePaid=" + noOfMonthsToBePaid + ", depositDate="
				+ depositDate + ", depositReturnDate=" + depositReturnDate + ", interest=" + interest
				+ ", maturityAMount=" + maturityAMount + ", totalAmount=" + totalAmount + "]";
	}

}