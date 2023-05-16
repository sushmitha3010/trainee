package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class InvalidAddressException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
	Logger logger = LoggerFactory.getLogger(InvalidAddressException.class);
	logger.info("Invalid Address!!!...Your Address Should Contain More than 10 characters and it should include  a number,uppercase letter,lower case letter,',','-','.'");
	}

}
