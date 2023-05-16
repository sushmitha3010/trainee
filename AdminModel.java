package com.chainsys.postofficemanagement.model;



public class AdminModel {
	
	private String mailId;
	private String password;
	
	
	public AdminModel() {
		
	}
	public AdminModel(String mailId, String password) {
		super();
		this.mailId = mailId;
		this.password = password;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminModel [mailId=" + mailId + ", password=" + password + "]";
	}

	
}


