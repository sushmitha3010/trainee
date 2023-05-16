package com.chainsys.postofficemanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.Model;

public class RegisterValidation {

	// Validation for userName
	public boolean userNameValidation(String userName, Model model) {
		String regex = "[a-zA-Z]+\\.?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(userName);
		boolean b = m.matches();
		if (b) {
			return true;

		}

		else {
			String errorMessage = "Name should contains only letters ";
			model.addAttribute("errorMessage1", errorMessage);
			return false;
		}
	}

	// Validation for password
	public boolean passwordValidation(String password, Model model) {
		Boolean wname = password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");// password must include one
																						// lower case and upper case
		if (Boolean.TRUE.equals(wname)) {
			return true;
		} else {
			String errorMessage = "Password Should be more than 6 characters and Must Contain Atleat One Special Character ";
			model.addAttribute("errorMessage2", errorMessage);
			return false;
		}
	}

	// Validation for mobileNo
	public boolean mobileNoValidation(long mobileNo, Model model) {
		String regex = "[6-9][\\d]{9}";
		String mobileNo1 = Long.toString(mobileNo);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobileNo1);
		boolean b = m.matches();
		if (b) {
			return true;

		} else {
			String errorMessage = "Mobile Number Must Conatin 10 Digits and Only Starts With 6,7,8 or 9";
			model.addAttribute("errorMessage3", errorMessage);
			return false;
		}

	}

	// Validation for aadharNo
	public boolean accountNoValidation(long aadharNo, Model model) {
		String regex = "\\d{12}";
		String aadharNo1 = Long.toString(aadharNo);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(aadharNo1);
		boolean b = m.matches();
		if (b) {
			return true;
		}

		else {
			String errorMessage = "Aadhar Number Must Conatin 12 Digits ";
			model.addAttribute("errorMessage4", errorMessage);
			return false;
		}
	}

	public boolean emailValidation(String mailId, Model model) {

		String regex = "^[a-zA-Z0-9+._]+@[a-zA-Z._]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mailId);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Mail Id Conatin minimum 5 and maximum 50 Characters";
			model.addAttribute("errorMessage5", errorMessage);
			return false;
		}

	}

	public boolean addressValidation(String address, Model model) {
		String regex = "^(.+){10,50}[a-z,.\\-A-Z0-9\s]";// ,.-numbers,a-zA-Z must include
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(address);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Address  Must Conatin minimum 10 and maximum 50 Characters ,.-numbers,a-zA-Z must include ";
			model.addAttribute("errorMessage6", errorMessage);
			return false;
		}
	}

}
