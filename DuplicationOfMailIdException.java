package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicationOfMailIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
	Logger logger=LoggerFactory.getLogger(DuplicationOfMobileException.class);
	
   
	logger.info("This Mail Id is Already Exsist Use Another Mail Id");

}

}
