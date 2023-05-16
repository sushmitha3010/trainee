package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserIdException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(UserIdException.class);
		logger.info("Invalid user id!!!... User Id Must Contain  4 Digits");
	}

}
