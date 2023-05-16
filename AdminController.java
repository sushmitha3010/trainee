package com.chainsys.postofficemanagement.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chainsys.postofficemanagement.model.RegisteredPostModel;
import com.chainsys.postofficemanagement.model.SpeedPostModel;
import com.chainsys.postofficemanagement.model.User;
import com.chainsys.postofficemanagement.service.AdminService;
import com.chainsys.postofficemanagement.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class AdminController {

	PostService postService = new PostService();
	AdminService adminService = new AdminService();

	Integer obj = null;

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	private static final String ADMINLOGIN = "Admin.html";

	private static final String ADMINDASHBOARD = "AdminDashBoard.html";

	@GetMapping("/adminDashBoard")
	public String adminDashBoard() {
		return ADMINDASHBOARD;
	}

	@RequestMapping("/listOfRegisterPostUser")
	public String getRegisterPostUser(@ModelAttribute("registeredPost") RegisteredPostModel registeredPostModel,
			Model model, HttpSession session) throws JsonProcessingException, DataAccessException {
		adminService.listOfRegisteredPostUser(model);
		return "RegisteredPostList.html";
	}

	@GetMapping("/listOfSpeedPostUser")
	public String getSpeedPostUser(@ModelAttribute("speedPost") SpeedPostModel speedPostModel, Model model,
			HttpSession session) throws JsonProcessingException {
		adminService.listOfSpeedPostUser(model);
		return "SpeedPostList.html";
	}

	@GetMapping("/listOfRecurringDepositUser")
	public String getRecurringDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		adminService.listOfRecurringDepositUser(model, session);
		return "RecurringDepositList.html";
	}

	@GetMapping("/listOfTimeDepositUser")
	public String getTimeDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		adminService.listOfTimeDepositUser(model, session);
		return "TimeDepositList.html";
	}

	@GetMapping("/listOfSeniorCitizenDepositUser")
	public String getSeniorCitizenDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		adminService.listOfSeniorCitizenUser(model, session);
		return "SeniorCitizenList.html";
	}

	@RequestMapping("/loginAdminModel")
	public String loginAdminModel(@ModelAttribute("adminLogin") User register, Model model) {
		return ADMINLOGIN;
	}

	@RequestMapping("/loginAdmin")
	public String loginAdmin(@ModelAttribute("adminLogin") User register,
			@ModelAttribute("registeredPost") RegisteredPostModel registeredPostModel,
			@ModelAttribute("speedPost") SpeedPostModel speedPostModel, Model model, HttpSession session)
			throws JsonProcessingException, DataAccessException {

		if (Boolean.TRUE.equals(adminService.login2(register, session, model))) {
			adminService.recurringDepositCount(model);
			logger.info("Recurring Deposit Count");
			adminService.timeDepositCount(model);
			logger.info("Time Deposit Count");
			adminService.seniorCitizenDepositCount(model);
			logger.info("Senior Deposit Count");
			adminService.registerePostCount(model);
			logger.info("Registered Post Count");
			adminService.speedPostCount(model);
			logger.info("Speed Post Count");

			adminService.listOfRegisteredPostUser(model);
			adminService.listOfSpeedPostUser(model);
			adminService.listOfRecurringDepositUser(model, session);
			adminService.listOfTimeDepositUser(model, session);
			adminService.listOfSeniorCitizenUser(model, session);

			return ADMINDASHBOARD;
		} else if (Boolean.FALSE.equals(adminService.login2(register, session, model))) {

			return ADMINLOGIN;
		}
		return ADMINLOGIN;
	}

	@GetMapping("/registerCheck")
	public String registerPostCheck(@ModelAttribute("registeredPost") RegisteredPostModel registeredPostModel,
			Model model) {
		adminService.registeredPostReached(registeredPostModel);
		return "Delivered.html";
	}

	@GetMapping("/registerProcess")
	public String registerPostProcessing(@ModelAttribute("registeredPost") RegisteredPostModel registeredPostModel,
			Model model) {
		adminService.registerProcessing(registeredPostModel);
		return "Processing.html";
	}

	@GetMapping("/speedReach")
	public String speedPostCheck(@ModelAttribute("speedPost") SpeedPostModel speedPostModel, Model model) {
		adminService.speedPostReached(speedPostModel);
		return "Delivered.html";
	}

	@GetMapping("/speedProcess")
	public String speedPostProcessing(@ModelAttribute("speedPost") SpeedPostModel speedPostModel, Model model) {
		adminService.speedPostProcessing(speedPostModel);
		return "Processing.html";
	}
}