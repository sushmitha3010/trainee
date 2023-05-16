package com.chainsys.postofficemanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlingDeviation {
	@ExceptionHandler({ Exception.class, RuntimeException.class })

	// @ExceptionHandler
	public ModelAndView handleExceptions(Exception ex) {
		Logger logger = LoggerFactory.getLogger(HandlingDeviation.class);
		ModelAndView view = new ModelAndView();
		try {
		view.addObject("ErrorMessage", "An unexpected error occurred.");
		view.setViewName("ErrorPopup");
		}
		finally {
			ex.printStackTrace();
		}
		logger.info(ex.getLocalizedMessage());
		return view;
	}
}