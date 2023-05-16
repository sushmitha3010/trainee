package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidMobileNoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(InvalidMobileNoException.class);
		logger.info("Invalid MobileNo!!!...Mobile No Must Contain 10 Digits and Not Allowed for Alphabets");
	}

}
