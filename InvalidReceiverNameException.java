package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidReceiverNameException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(InvalidReceiverNameException.class);
		logger.info("Invalid User Name!!!...User Name Allowed Only for Alphabets ");
	}

	
	
}
