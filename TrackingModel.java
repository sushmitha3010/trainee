package com.chainsys.postofficemanagement.model;

import java.sql.Date;

public class TrackingModel {

	private String trackingNo;
	private Date bookingDate;
	private String status;

	public TrackingModel() {
	}

	public TrackingModel(String trackingNo, Date bookingDate, String status) {
		super();
		this.trackingNo = trackingNo;
		this.bookingDate = bookingDate;
		this.status = status;
	}

	public String gettrackingNo() {
		return trackingNo;
	}

	public String setTrackingNo(String trackingNo) {
		return trackingNo;
	}

	public String getStatus() {
		return status;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TrackingModel [trackingNo=" + trackingNo + ", bookingDate=" + bookingDate + ", status=" + status + "]";
	}

}
