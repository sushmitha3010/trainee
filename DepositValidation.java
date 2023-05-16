package com.chainsys.postofficemanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.ui.Model;

public class DepositValidation {

	public boolean amountValidation(Integer amount, Model model) {
		String regex = "^0*?[1-9]\\d*$";
		String amount1 = Long.toString(amount);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(amount1);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Amount Does Not Contain Zero ";
			model.addAttribute("errorMessage15", errorMessage);
			return false;
		}

	}

	public boolean monthValidation(Integer noOfMonths, Model model) {
		String regex = "^0*?[1-9]\\d*$";
		String month = Long.toString(noOfMonths);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(month);
		boolean b = m.matches();
		if (b) {
			return true;
		} else {
			String errorMessage = "Months Cannot Enter Zero And Not Contain Negative Values";
			model.addAttribute("errorMessage16", errorMessage);
			return false;
		}
	}

	public boolean ageValidation(Integer age, Model model) {
		String regex = "^[\\d]{1,2}$";
		String age1 = Integer.toString(age);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(age1);
		boolean b = m.matches();
		if (b) {

			return true;
		}
		String errorMessage = "Age Cannot be Greater than 60 years only Allowed";
		model.addAttribute("errorMessage17", errorMessage);
		return false;
	}

}
