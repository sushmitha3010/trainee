package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NegativeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
	
		Logger logger = LoggerFactory.getLogger(NegativeException.class);
		logger.info("Not Contain negative Values");
	}

}
