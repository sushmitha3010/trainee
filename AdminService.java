package com.chainsys.postofficemanagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;

import com.chainsys.postofficemanagement.dao.AdminDao;
import com.chainsys.postofficemanagement.dao.PostDao;
import com.chainsys.postofficemanagement.model.AdminModel;
import com.chainsys.postofficemanagement.model.RecurringDepositModel;
import com.chainsys.postofficemanagement.model.RegisteredPostModel;
import com.chainsys.postofficemanagement.model.SeniorCitizenModel;
import com.chainsys.postofficemanagement.model.SpeedPostModel;
import com.chainsys.postofficemanagement.model.TimeDepositModel;
import com.chainsys.postofficemanagement.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AdminService {
	PostDao registerDao = new PostDao();
	AdminDao adminDao = new AdminDao();

	public void listOfRegisteredPostUser(Model model) throws JsonProcessingException, DataAccessException {
		adminDao.listRegisterPostUser(model);
	}

	public void listOfSpeedPostUser(Model model) throws JsonProcessingException {
		adminDao.listspeedPostUser(model);
	}

	public void listOfRecurringDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		List<RecurringDepositModel> registers = adminDao.listRecurringDepositUser(model);
		session.setAttribute("RecurringDepositUser_List", registers);
	}

	public void listOfTimeDepositUser(Model model, HttpSession session) throws JsonProcessingException {
		List<TimeDepositModel> registers = adminDao.listTimeDepositUser(model);
		session.setAttribute("TimeDepositUser_List", registers);
	}

	public void listOfSeniorCitizenUser(Model model, HttpSession session) throws JsonProcessingException {
		List<SeniorCitizenModel> registers = adminDao.listSeniorCitizenDepositUser(model);
		session.setAttribute("SeniorCitizenDepositUser_List", registers);
	}

	public boolean login2(User register, HttpSession session, Model model) {
		return adminDao.adminLogin(register, session, model);
	}

	public void registeredPostReached(RegisteredPostModel registeredPostModel) {
		adminDao.registeredPostDeliveredMethod(registeredPostModel);
	}

	public void registerProcessing(RegisteredPostModel registeredPostModel) {
		adminDao.registeredPostProcessingMethod(registeredPostModel);
	}

	public void speedPostReached(SpeedPostModel speedPostModel) {
		adminDao.speedPostDeliveredMethod(speedPostModel);
	}

	public void speedPostProcessing(SpeedPostModel speedPostModel) {
		adminDao.speedPostProcessingMethod(speedPostModel);
	}

	public void recurringDepositCount(Model model) {
		Integer recurringCount = adminDao.totalRecurringDepositCount();
		model.addAttribute("recurring_count", recurringCount);
	}

	public void timeDepositCount(Model model) {
		Integer timeCount = adminDao.totalTimeDepositCount();
		model.addAttribute("time_count", timeCount);
	}

	public void seniorCitizenDepositCount(Model model) {
		Integer seniorCount = adminDao.totalSeniorCitizenDepositCount();
		model.addAttribute("senior_count", seniorCount);
	}

	public void registerePostCount(Model model) {
		Integer registerCount = adminDao.totalRegisteredPostCount();
		model.addAttribute("registered_count", registerCount);
	}

	public void speedPostCount(Model model) {
		Integer speedCount = adminDao.totalSpeedPostCount();
		model.addAttribute("speed_count", speedCount);
	}

}
