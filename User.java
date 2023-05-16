package com.chainsys.postofficemanagement.model;

public class User {

	// To Using the Variables
	private String userName;
	private String password;
	private Long mobileNo;
	private Long accountNo;
	private String mailId;
	private String address;

	// To Get the Default Constructor
	public User() {

	}

	// To Get the Parameterized Constructor

	public User(String userName, String password, Long mobileNo, Long accountNo, String mailId, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.accountNo = accountNo;
		this.mailId = mailId;
		this.address = address;
	}

	// Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// To String
	@Override
	public String toString() {
		return "UserModel [ userName=" + userName + ", password=" + password + ", mobileNo=" + mobileNo + ", accountNo="
				+ accountNo + ", mailId=" + mailId + ", address=" + address + "]";
	}

}
