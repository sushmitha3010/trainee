package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class InvalidAccountNoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(InvalidAccountNoException.class);
		logger.info("Invalid AccountNo!!!...Account No Must Contain 12 Digits and Not Allowed for Alphabets");
	}
}

