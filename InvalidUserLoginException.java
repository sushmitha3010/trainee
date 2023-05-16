package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidUserLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static{
		Logger logger=LoggerFactory.getLogger(InvalidUserLoginException.class);
		
	   
		logger.info("Invalid Credentials");

	}


}
