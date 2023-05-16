package com.chainsys.postofficemanagement.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.chainsys.postofficemanagement.exception.InvalidAccountNoException;
import com.chainsys.postofficemanagement.exception.InvalidUserLoginException;
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

public interface PostInterface {

	public void saveRegisterDetails(User register, HttpSession session);

	public boolean userLogin(User register, HttpSession session)
			throws InvalidUserLoginException, InvalidAccountNoException;

	public void saveRecurringDepositDetails(RecurringDepositModel recurringDeposit, HttpSession session);

	public void recurringDepositCount(HttpSession session, Model model);

	public void saveTimeDepositDetails(TimeDepositModel timeDeposit, HttpSession session);

	public void saveSeniorCitizenDetail(SeniorCitizenModel seniorCitizen, HttpSession session);

	public void saveRegisterPostDetail(RegisteredPostModel registerPost, HttpSession session);

	public List<RegisteredPostModel> registeredPostTracking(RegisteredPostModel registeredPost, Model model);

	public String speedPostTracking(SpeedPostModel speedPost);

	public void saveSpeedPostDetail(SpeedPostModel speedPost, HttpSession session);

	public void recurringDepositPayment(RecurringPayment recurringPayment, HttpSession session);

	public void timeDepositPayment(TimeDepositPayment timePayment);

	public void seniorCitizenDepositPayment(SeniorCitizenPayment seniorPayment);

	public void registerPostPayment(RegisteredPostPaymentModel registerPayment, HttpSession session);

	public void speedPostPayment(SpeedPostPaymentModel speedPayment);

	public void passwordUpdate(User register);

	public List<RecurringDepositModel> listRecurringDepositPassbook(Model model, HttpSession session)
			throws JsonProcessingException;

	public List<TimeDepositModel> listTimeDepositPassbook(Model model, HttpSession session)
			throws JsonProcessingException;

	public List<SeniorCitizenModel> listSeniorCitizenDepositPassbook(Model model, HttpSession session)
			throws JsonProcessingException;

	public void listRegisterPostUserProfile(Model model, HttpSession session) throws JsonProcessingException;

	public void listspeedPostUserProfile(Model model, HttpSession session) throws JsonProcessingException;

	public Boolean existingMailIdCheck(String mailId, Model model);

	public Boolean existingMobileNoCheck(Long mobileNo, Model model);

}
