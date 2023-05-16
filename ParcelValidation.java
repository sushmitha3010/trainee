package com.chainsys.postofficemanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.Model;

public class ParcelValidation {


	// Validation for userName
	public boolean receiverNameValidation(String receiverName, Model model) {
		String regex = "[a-zA-Z]+\\.?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(receiverName);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Name should contains only letters and not digits ";
			model.addAttribute("errorMessage8", errorMessage);
			return false;
		}
	}

	// Validation for mobileNo
	public boolean receiverMobileNoValidation(long receiverMobileNo, Model model) {
		String regex = "[6-9][\\d]{9}";
		String mobileNo1 = Long.toString(receiverMobileNo);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobileNo1);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Mobile Number Must Contain 10 digits only and cannot contain Alphabets ";
			model.addAttribute("errorMessage9", errorMessage);
			return false;
		}
	}

	// Validation for Address
	public boolean senderAddressValidation(String senederAddress, Model model) {
		String regex = "^(.+){10,50}[a-z,.\\-A-Z0-9\s]";// ,.-numbers,a-zA-Z must include
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(senederAddress);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Address should Contain Less than 10 characters and Greater than 50 characters and must include ,.-numbers,a-zA-Z ";
			model.addAttribute("errorMessage10", errorMessage);
			return false;
		}
	}

	public boolean parcelWeightValidation(float parcelWeight, Model model) {
		if (parcelWeight > 0) {
			return true;
		} else {
			String errorMessage = "Parcel Weight Cannot Enter Zero and Negative Values ";
			model.addAttribute("errorMessage11", errorMessage);
			return false;
		}
	}

	public boolean kmsValidation(float kms, Model model) {
		if (kms > 0) {
			return true;
		} else {
			String errorMessage = "Kilometers Cannot Enter Zero and Negative Values ";
			model.addAttribute("errorMessage12", errorMessage);
			return false;
		}
	}
}
