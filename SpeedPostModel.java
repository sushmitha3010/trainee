package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class SpeedPostModel {

	private String senderName;
	private Long senderMobileNo;
	private String senderAddress;
	private Float parcelWeight;
	private Float kms;
	private String receiverName;
	private Long receiverMobileNo;
	private String receiverAddress;
	private Date bookingDate;
	private Integer trackingNo;
	private String status;
	private float charge;

	public SpeedPostModel() {

	}

	public SpeedPostModel(String senderName, Long senderMobileNo, String senderAddress, Float parcelWeight, Float kms,
			String receiverName) {
		super();
		this.senderName = senderName;
		this.senderMobileNo = senderMobileNo;
		this.senderAddress = senderAddress;
		this.parcelWeight = parcelWeight;
		this.kms = kms;
		this.receiverName = receiverName;
	}

	public SpeedPostModel(Long receiverMobileNo, String receiverAddress, Date bookingDate, Integer trackingNo,
			String status, float charge) {
		super();
		this.receiverMobileNo = receiverMobileNo;
		this.receiverAddress = receiverAddress;
		this.bookingDate = bookingDate;
		this.trackingNo = trackingNo;
		this.status = status;
		this.charge = charge;
	}

	public float getCharge() {
		return charge;
	}

	public void setCharge(float charge) {
		this.charge = charge;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Long getSenderMobileNo() {
		return senderMobileNo;
	}

	public void setSenderMobileNo(Long senderMobileNo) {
		this.senderMobileNo = senderMobileNo;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public Float getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(Float parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public Float getKms() {
		return kms;
	}

	public void setKms(Float kms) {
		this.kms = kms;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Long getReceiverMobileNo() {
		return receiverMobileNo;
	}

	public void setReceiverMobileNo(Long receiverMobileNo) {
		this.receiverMobileNo = receiverMobileNo;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SpeedPostModel [senderName=" + senderName + ", senderMobileNo=" + senderMobileNo + ", senderAddress="
				+ senderAddress + ", parcelWeight=" + parcelWeight + ", kms=" + kms + ", receiverName=" + receiverName
				+ ", receiverMobileNo=" + receiverMobileNo + ", receiverAddress=" + receiverAddress + ", bookingDate="
				+ bookingDate + ", trackingNo=" + trackingNo + ", status=" + status + ", charge=" + charge + "]";
	}

}
