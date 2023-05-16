package com.chainsys.postofficemanagement.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.chainsys.postofficemanagement.dao.AdminDao;
import com.chainsys.postofficemanagement.dao.PostDao;
import com.chainsys.postofficemanagement.model.RecurringDepositModel;
import com.chainsys.postofficemanagement.model.RecurringPayment;
import com.chainsys.postofficemanagement.model.RegisteredPostModel;
import com.chainsys.postofficemanagement.model.RegisteredPostPaymentModel;
import com.chainsys.postofficemanagement.model.SeniorCitizenModel;
import com.chainsys.postofficemanagement.model.SeniorCitizenPayment;
import com.chainsys.postofficemanagement.model.SpeedPostModel;
import com.chainsys.postofficemanagement.model.SpeedPostPaymentModel;
import com.chainsys.postofficemanagement.model.TimeDepositModel;
import com.chainsys.postofficemanagement.model.TimeDepositPayment;
import com.chainsys.postofficemanagement.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class PostService {
	
	PostDao registerDao = new PostDao();
	AdminDao adminDao = new AdminDao();
	
	public void userRegister(User register,HttpSession session) {
		registerDao.saveRegisterDetails(register, session);
    }

	public boolean login1(User register,HttpSession session) {
		return registerDao.userLogin(register, session);
	}

	public void recurringDepositDetails(RecurringDepositModel recurringDeposit,HttpSession session ) {
		registerDao.saveRecurringDepositDetails(recurringDeposit, session);
	}
	public void recurringCount(HttpSession session,Model model) {
		registerDao.recurringDepositCount( session, model);
	}
	public void timeDepositDetails(TimeDepositModel timeDeposit,HttpSession session ) {
		registerDao.saveTimeDepositDetails(timeDeposit, session);
	}
	public void seniorDepositDetails(SeniorCitizenModel seniorCitizen,HttpSession session ) {
		registerDao.saveSeniorCitizenDetail(seniorCitizen, session);
	}
	public void registeredPostDetails( RegisteredPostModel registerPost,HttpSession session ) {
		registerDao.saveRegisterPostDetail(registerPost,session);
	}

	public void speedPostDetails(SpeedPostModel speedPost ,HttpSession session) {
		registerDao.saveSpeedPostDetail(speedPost, session);
	}
	public void recurringPaymentDetails(RecurringPayment recuringPayment,HttpSession session ) {
		registerDao.recurringDepositPayment(recuringPayment,session);
	}
	public void timePaymentDetails(TimeDepositPayment timePayment ) {
		registerDao.timeDepositPayment(timePayment);
	}
	public void seniorPaymentDetails(SeniorCitizenPayment seniorPayment ) {
		registerDao.seniorCitizenDepositPayment(seniorPayment);
	}
	public void registeredPostPaymentDetails(RegisteredPostPaymentModel registerPayment,HttpSession session) {
		registerDao.registerPostPayment(registerPayment, session);
	}
	public void speedPostPaymentdetails(SpeedPostPaymentModel speedPayment) {
		registerDao.speedPostPayment(speedPayment);
	}
	public void forgetPassword(User register) {
		registerDao.passwordUpdate(register);	
	}
	public void recurringPassBook(HttpSession session,Model model) throws JsonProcessingException {
		registerDao.listRecurringDepositPassbook(model,session);
	}
	public void timePassBook(HttpSession session,Model model) throws JsonProcessingException {
		registerDao.listTimeDepositPassbook(model,session);
	}
	public void seniorPassBook(HttpSession session,Model model) throws JsonProcessingException {
		registerDao.listSeniorCitizenDepositPassbook(model,session);
	}
	public void registeredPostPassBook(HttpSession session,Model model) throws JsonProcessingException {
		registerDao.listRegisterPostUserProfile(model, session);
	}
	public void speedPostPassBook(HttpSession session,Model model) throws JsonProcessingException {
		registerDao.listspeedPostUserProfile(model, session);
	}
	public void registeredPostStatusView(RegisteredPostModel registeredPostModel,Model model,HttpSession session) throws JsonProcessingException, DataAccessException {
		 adminDao.listRegisterPostUser(model);
			List<RegisteredPostModel> status = registerDao.registeredPostTracking(registeredPostModel,model);
			session.setAttribute("status_List", status);
	}
	
	public void speedPostStatusView(SpeedPostModel speedPost,Model model,HttpSession session) throws JsonProcessingException, DataAccessException {
		adminDao.listspeedPostUser(model);
		String status = registerDao.speedPostTracking(speedPost);
		session.setAttribute("status1_List", status);
    }
	
	public void profileGetMethod(HttpSession session) {
		registerDao.getProfileDetails( session);
    }
	public void profileUpdateMethod(User register,HttpSession session) {
		registerDao.registerUserProfile(register, session);
    }
	public void recurringSlip(HttpSession session) {
		registerDao.getRecurringPayment(session);
    }

}



