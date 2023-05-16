package com.chainsys.postofficemanagement.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.chainsys.postofficemanagement.model.RecurringDepositModel;
import com.chainsys.postofficemanagement.model.RegisteredPostModel;
import com.chainsys.postofficemanagement.model.SeniorCitizenModel;
import com.chainsys.postofficemanagement.model.SpeedPostModel;
import com.chainsys.postofficemanagement.model.TimeDepositModel;
import com.chainsys.postofficemanagement.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AdminInterface {

	public void listRegisterPostUser(Model model) throws JsonProcessingException;

	public void listspeedPostUser(Model model) throws JsonProcessingException;

	public List<RecurringDepositModel> listRecurringDepositUser(Model model) throws JsonProcessingException;

	public List<TimeDepositModel> listTimeDepositUser(Model model) throws JsonProcessingException;

	public List<SeniorCitizenModel> listSeniorCitizenDepositUser(Model model) throws JsonProcessingException;

	public boolean adminLogin(User register, HttpSession session, Model model);

	public Integer totalRecurringDepositCount();

	public Integer totalTimeDepositCount();

	public Integer totalSeniorCitizenDepositCount();

	public Integer totalRegisteredPostCount();

	public Integer totalSpeedPostCount();

	public void registeredPostDeliveredMethod(RegisteredPostModel registeredPostModel);

	public void registeredPostProcessingMethod(RegisteredPostModel registeredPostModel);

	public void speedPostDeliveredMethod(SpeedPostModel speedPostModel);

	public void speedPostProcessingMethod(SpeedPostModel speedPostModel);

}
