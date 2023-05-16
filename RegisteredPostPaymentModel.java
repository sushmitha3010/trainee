package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class RegisteredPostPaymentModel {

	private String registeredPostUserName;
	private float registeredPostParcelCharge;
	private Integer registertrackNo;
	private String registeredPostStatus;
	private Date parcelPaidDate;

	public RegisteredPostPaymentModel() {
		super();

	}

	public RegisteredPostPaymentModel(String registeredPostUserName, float registeredPostParcelCharge,
			Integer registertrackNo, String registeredPostStatus, Date parcelPaidDate) {
		super();
		this.registeredPostUserName = registeredPostUserName;
		this.registeredPostParcelCharge = registeredPostParcelCharge;
		this.registertrackNo = registertrackNo;
		this.registeredPostStatus = registeredPostStatus;
		this.parcelPaidDate = parcelPaidDate;
	}

	public String getRegisteredPostUserName() {
		return registeredPostUserName;
	}

	public void setRegisteredPostUserName(String registeredPostUserName) {
		this.registeredPostUserName = registeredPostUserName;
	}

	public float getRegisteredPostParcelCharge() {
		return registeredPostParcelCharge;
	}

	public void setRegisteredPostParcelCharge(float registeredPostParcelCharge) {
		this.registeredPostParcelCharge = registeredPostParcelCharge;
	}

	public Integer getRegistertrackNo() {
		return registertrackNo;
	}

	public void setRegistertrackNo(Integer registertrackNo) {
		this.registertrackNo = registertrackNo;
	}

	public String getRegisteredPostStatus() {
		return registeredPostStatus;
	}

	public void setRegisteredPostStatus(String registeredPostStatus) {
		this.registeredPostStatus = registeredPostStatus;
	}

	public Date getParcelPaidDate() {
		return parcelPaidDate;
	}

	public void setParcelPaidDate(Date parcelPaidDate) {
		this.parcelPaidDate = parcelPaidDate;
	}

	@Override
	public String toString() {
		return "RegisteredPostPaymentModel [registeredPostUserName=" + registeredPostUserName
				+ ", registeredPostParcelCharge=" + registeredPostParcelCharge + ", registertrackNo=" + registertrackNo
				+ ", registeredPostStatus=" + registeredPostStatus + ", parcelPaidDate=" + parcelPaidDate + "]";
	}

}
