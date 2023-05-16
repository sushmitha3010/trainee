package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicationOfMobileException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
	Logger logger=LoggerFactory.getLogger(DuplicationOfMobileException.class);
	
	logger.info("This Mobile No is Already Exsist Use Another Mobile No");

}
}
