package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class RegisteredPostModel {

	private String sendUserName;
	private Long sendUserMobileNo;
	private String sendUserAddress;
	private float parcelWeight;
	private String receiveUserName;
	private Long receiveUserMobileNo;
	private String receiveUserAddress;
	private Date bookingDate;
	private Integer trackingNo;
	private String trackingStatus;
	private float parcelCharge;

	public RegisteredPostModel() {

	}

	public RegisteredPostModel(String sendUserName, Long sendUserMobileNo, String sendUserAddress, float parcelWeight,
			String receiveUserName) {
		super();
		this.sendUserName = sendUserName;
		this.sendUserMobileNo = sendUserMobileNo;
		this.sendUserAddress = sendUserAddress;
		this.parcelWeight = parcelWeight;
		this.receiveUserName = receiveUserName;
	}

	public RegisteredPostModel(Long receiveUserMobileNo, String receiveUserAddress, Date bookingDate,
			Integer trackingNo, String trackingStatus, float parcelCharge) {
		super();
		this.receiveUserMobileNo = receiveUserMobileNo;
		this.receiveUserAddress = receiveUserAddress;
		this.bookingDate = bookingDate;
		this.trackingNo = trackingNo;
		this.trackingStatus = trackingStatus;
		this.parcelCharge = parcelCharge;
	}

	public String getSendUserName() {
		return sendUserName;
	}

	public float getParcelCharge() {
		return parcelCharge;
	}

	public void setParcelCharge(float parcelCharge) {
		this.parcelCharge = parcelCharge;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public Long getSendUserMobileNo() {
		return sendUserMobileNo;
	}

	public void setSendUserMobileNo(Long sendUserMobileNo) {
		this.sendUserMobileNo = sendUserMobileNo;
	}

	public String getSendUserAddress() {
		return sendUserAddress;
	}

	public void setSendUserAddress(String sendUserAddress) {
		this.sendUserAddress = sendUserAddress;
	}

	public float getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(float parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getReceiveUserName() {
		return receiveUserName;
	}

	public void setReceiveUserName(String receiveUserName) {
		this.receiveUserName = receiveUserName;
	}

	public Long getReceiveUserMobileNo() {
		return receiveUserMobileNo;
	}

	public void setReceiveUserMobileNo(Long receiveUserMobileNo) {
		this.receiveUserMobileNo = receiveUserMobileNo;
	}

	public String getReceiveUserAddress() {
		return receiveUserAddress;
	}

	public void setReceiveUserAddress(String receiveUserAddress) {
		this.receiveUserAddress = receiveUserAddress;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getTrackingNo() {
		return trackingNo;
	}

	public void setTrackingNo(Integer trackingNo) {
		this.trackingNo = trackingNo;
	}

	public String getTrackingStatus() {
		return trackingStatus;
	}

	public void setTrackingStatus(String trackingStatus) {
		this.trackingStatus = trackingStatus;
	}

	@Override
	public String toString() {
		return "RegisteredPostModel [sendUserName=" + sendUserName + ", sendUserMobileNo=" + sendUserMobileNo
				+ ", sendUserAddress=" + sendUserAddress + ", parcelWeight=" + parcelWeight + ", receiveUserName="
				+ receiveUserName + ", receiveUserMobileNo=" + receiveUserMobileNo + ", receiveUserAddress="
				+ receiveUserAddress + ", bookingDate=" + bookingDate + ", trackingNo=" + trackingNo
				+ ", trackingStatus=" + trackingStatus + ", parcelCharge=" + parcelCharge + "]";
	}

}
