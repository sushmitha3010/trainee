package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidPasswordException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(InvalidPasswordException.class);
		logger.info("Invalid password!!!...Please Enter  Must Include One Lower Case and Upper Case");
	}

}
