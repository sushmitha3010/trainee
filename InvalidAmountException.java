package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidAmountException extends Exception {
	

	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(InvalidAadharNoException.class);
		logger.info("Invalid Amount!!!...Amount Cannot Enter Zero Value and Negative Values ");
	}

}
