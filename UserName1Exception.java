package com.chainsys.postofficemanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserName1Exception  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static{
		Logger logger = LoggerFactory.getLogger(UserName1Exception.class);
		logger.info("Invalid User Name!!!...User Name Allowed Only For Alphabets ");
	}

}
