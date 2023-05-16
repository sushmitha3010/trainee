package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class InvalidEmailException  extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger=LoggerFactory.getLogger(InvalidLoginException.class);
		
	   
		logger.info("Invalid MailId Use Another Mail Id");

	}
	
	
}
