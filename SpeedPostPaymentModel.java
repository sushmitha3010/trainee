package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class SpeedPostPaymentModel {

	private String postSenderName;
	private float charge;
	private Integer trackingNo;
	private String speedPostStatus;
	private Date payDate;

	public SpeedPostPaymentModel() {

	}

	public SpeedPostPaymentModel(String postSenderName, float charge, Integer trackingNo, String speedPostStatus,
			Date payDate) {
		super();
		this.postSenderName = postSenderName;
		this.charge = charge;
		this.trackingNo = trackingNo;
		this.speedPostStatus = speedPostStatus;
		this.payDate = payDate;
	}

	public String getSpeedPostStatus() {
		return speedPostStatus;
	}

	public void setSpeedPostStatus(String speedPostStatus) {
		this.speedPostStatus = speedPostStatus;
	}

	public Integer getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(Integer trackingNo) {
		this.trackingNo = trackingNo;
	}

	public String getPostSenderName() {
		return postSenderName;
	}

	public void setPostSenderName(String postSenderName) {
		this.postSenderName = postSenderName;
	}

	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Override
	public String toString() {
		return "SpeedPostPaymentModel [postSenderName=" + postSenderName + ", charge=" + charge + ", trackingNo="
				+ trackingNo + ", speedPostStatus=" + speedPostStatus + ", payDate=" + payDate + "]";
	}

}
