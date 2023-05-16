package com.chainsys.postofficemanagement.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import com.chainsys.postofficemanagement.mapper.AdminLoginMapper;
import com.chainsys.postofficemanagement.mapper.RecurringMapper;
import com.chainsys.postofficemanagement.mapper.RegisteredPostMapper;
import com.chainsys.postofficemanagement.mapper.SeniorCitizenMapper;
import com.chainsys.postofficemanagement.mapper.SpeedMapper;
import com.chainsys.postofficemanagement.mapper.TimeMapper;
import com.chainsys.postofficemanagement.model.RecurringDepositModel;
import com.chainsys.postofficemanagement.model.RegisteredPostModel;
import com.chainsys.postofficemanagement.model.SeniorCitizenModel;
import com.chainsys.postofficemanagement.model.SpeedPostModel;
import com.chainsys.postofficemanagement.model.TimeDepositModel;
import com.chainsys.postofficemanagement.model.User;
import com.chainsys.postofficemanagement.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminDao implements AdminInterface {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	Logger logger = LoggerFactory.getLogger(AdminDao.class);

	@Override
	public boolean adminLogin(User register, HttpSession session, Model model) {
		String adminId = register.getMailId();
		String adminPass = register.getPassword();
		String status;
		String mailId = "tamil123@gmail.com";
		String pass = "Tamil@12345";
           
		String query = "select mail_id,password from customer where mail_id=?";
		User userList = jdbcTemplate.queryForObject(query, new AdminLoginMapper(), adminId);
			if (userList != null) {
				if (adminId.equals(mailId)) {
					if (adminPass.equals(pass)) {
						status = "Success";
						model.addAttribute("LoginSuccess", status);
						return true;
					}
				} else {
					logger.info("Invalid Password");
					status = "Invalid Credentials";
					model.addAttribute("InvalidLoginStatus", status);
					return false;
				}
			}
			status = "InvalidCredentials";
			model.addAttribute("InvalidLoginStatus", status);
		
		return false;
	}

	@Override
	public Integer totalRecurringDepositCount() {
		String sql = "select count (*) from recurring_deposit";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Integer totalTimeDepositCount() {
		String sql = "select count (*) from time_deposit";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Integer totalSeniorCitizenDepositCount() {
		String sql = "select count (*) from senior_citizen_deposit";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Integer totalRegisteredPostCount() {
		String sql = "select count (*) from registered_post";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public Integer totalSpeedPostCount() {
		String sql = "select count (*) from speed_post";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public void listRegisterPostUser(Model model) throws JsonProcessingException {
		String sql = "select sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_charge from registered_post order by tracking_no DESC";
		List<RegisteredPostModel> registeredPostList = jdbcTemplate.query(sql, new RegisteredPostMapper());
		List<Map<String, Object>> registeredUserList = new ArrayList<>();
		for (RegisteredPostModel registeredPost : registeredPostList) {
			Map<String, Object> registeredPostMap = new HashMap<>();
			registeredPostMap.put("sender_name", registeredPost.getSendUserName());
			registeredPostMap.put("sender_mobile_no", registeredPost.getSendUserMobileNo());
			registeredPostMap.put("sender_address", registeredPost.getSendUserAddress());
			registeredPostMap.put("parcel_weight", registeredPost.getParcelWeight());
			registeredPostMap.put("receiver_name", registeredPost.getReceiveUserName());
			registeredPostMap.put("receiver_mobile_no", registeredPost.getReceiveUserMobileNo());
			registeredPostMap.put("receiver_address", registeredPost.getReceiveUserAddress());
			registeredPostMap.put("parcelDate", registeredPost.getBookingDate());
			registeredPostMap.put("trackNo", registeredPost.getTrackingNo());
			registeredPostMap.put("parcelStatus", registeredPost.getTrackingStatus());
			registeredPostMap.put("chargeBalance", registeredPost.getParcelCharge());
			registeredUserList.add(registeredPostMap);
		}
		ObjectMapper registeredPostMapper = new ObjectMapper();
		String registeredPostAction = registeredPostMapper.writeValueAsString(registeredUserList);
		model.addAttribute("registeredPostUserList", registeredPostAction);
	}

	@Override
	public void listspeedPostUser(Model model) throws JsonProcessingException {
		String sql = "select sender_name,sender_mobile_no,sender_address,distance,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_charge  from speed_post order by tracking_no DESC";
		List<SpeedPostModel> speedPostList = jdbcTemplate.query(sql, new SpeedMapper());
		List<Map<String, Object>> speedPostUserList = new ArrayList<>();
		for (SpeedPostModel speedPost : speedPostList) {
			Map<String, Object> speedPostMap = new HashMap<>();
			speedPostMap.put("senderName", speedPost.getSenderName());
			speedPostMap.put("senderMobileNo", speedPost.getSenderMobileNo());
			speedPostMap.put("senderUserAddress", speedPost.getSenderAddress());
			speedPostMap.put("kms", speedPost.getKms());
			speedPostMap.put("receiveUserName", speedPost.getReceiverName());
			speedPostMap.put("receiveUserMobileNo", speedPost.getReceiverMobileNo());
			speedPostMap.put("receiverUserAddress", speedPost.getReceiverAddress());
			speedPostMap.put("parcelDate", speedPost.getBookingDate());
			speedPostMap.put("trackNo", speedPost.getTrackingNo());
			speedPostMap.put("parcel_status", speedPost.getStatus());
			speedPostMap.put("parcelCharge", speedPost.getCharge());
			speedPostUserList.add(speedPostMap);
		}
		ObjectMapper speedPostMapper = new ObjectMapper();
		String speedPostAction = speedPostMapper.writeValueAsString(speedPostUserList);
		model.addAttribute("speedPostUserList", speedPostAction);
	}

	@Override
	public List<RecurringDepositModel> listRecurringDepositUser(Model model) throws JsonProcessingException {
		
		String sql = "select user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount from recurring_deposit order by account_no DESC";
		List<RecurringDepositModel> recuringDepositUserList = jdbcTemplate.query(sql, new RecurringMapper());
		List<Map<String, Object>> recurringDepositList = new ArrayList<>();
		for (RecurringDepositModel recurringDepositModel : recuringDepositUserList) {
			Map<String, Object> recurringDepositMap = new HashMap<>();
			recurringDepositMap.put("customerName", recurringDepositModel.getDeposituserName());
			recurringDepositMap.put("contactNo", recurringDepositModel.getDepositUserMobileNo());
			recurringDepositMap.put("accountNumber", recurringDepositModel.getUserAccountNumber());
			recurringDepositMap.put("principleAmount", recurringDepositModel.getDepositAmount());
			recurringDepositMap.put("noOfMonths", recurringDepositModel.getNoOfMonths());
			recurringDepositMap.put("depositDate", recurringDepositModel.getDepositDate());
			recurringDepositMap.put("depositReturnDate", recurringDepositModel.getDepositReturnDate());
			recurringDepositMap.put("InterestAmount", recurringDepositModel.getInterest());
			recurringDepositMap.put("maturityAmount", recurringDepositModel.getMaturityAMount());
			recurringDepositMap.put("amountTotal", recurringDepositModel.getTotalAmount());
			recurringDepositList.add(recurringDepositMap);
		}
		ObjectMapper recurringDepositMapper = new ObjectMapper();
		String recurringDepositAction = recurringDepositMapper.writeValueAsString(recurringDepositList);
		model.addAttribute("recurringDepositList", recurringDepositAction);
		return recuringDepositUserList;
	}

	@Override
	public List<TimeDepositModel> listTimeDepositUser(Model model) throws JsonProcessingException {
		String sql = "select user_name,mobile_no,account_no,principle_amount,periods,deposit_date,return_date,interest,maturity_amount,total_amount from time_deposit order by account_no DESC";
		List<TimeDepositModel> timeDepositUserList = jdbcTemplate.query(sql, new TimeMapper());
		List<Map<String, Object>> timeDepositList = new ArrayList<>();
		for (TimeDepositModel timeDepositModel : timeDepositUserList) {
			Map<String, Object> timeDepositMap = new HashMap<>();
			timeDepositMap.put("depositUserName", timeDepositModel.getName());
			timeDepositMap.put("phoneNo", timeDepositModel.getPhoneNo());
			timeDepositMap.put("acctNumber", timeDepositModel.getAccountNo());
			timeDepositMap.put("initialAmount", timeDepositModel.getAmount());
			timeDepositMap.put("periods", timeDepositModel.getPeriods());
			timeDepositMap.put("paymentDate", timeDepositModel.getDepositDate());
			timeDepositMap.put("return_date", timeDepositModel.getCompletedate());
			timeDepositMap.put("simple_interest", timeDepositModel.getSimpleInterest());
			timeDepositMap.put("amountMaturity", timeDepositModel.getMaturity());
			timeDepositMap.put("totalPayment", timeDepositModel.getTotal());
			timeDepositList.add(timeDepositMap);

		}
		ObjectMapper timeDepositMapper = new ObjectMapper();
		String timeDepositAction = timeDepositMapper.writeValueAsString(timeDepositList);
		model.addAttribute("timeDepositUsersList", timeDepositAction);
		return timeDepositUserList;
	}

	@Override
	public List<SeniorCitizenModel> listSeniorCitizenDepositUser(Model model) throws JsonProcessingException {
		String sql = "select  user_name,mobile_no,account_no,principle_amount,age,deposit_date,return_date,interest,maturity_amount,total_amount from senior_citizen_deposit order by account_no DESC";
		List<SeniorCitizenModel> seniorCitizenUserList = jdbcTemplate.query(sql, new SeniorCitizenMapper());
		List<Map<String, Object>> seniorDepositList = new ArrayList<>();
		for (SeniorCitizenModel seniorCitizenModel : seniorCitizenUserList) {
			Map<String, Object> seniorCitizenMap = new HashMap<>();
			seniorCitizenMap.put("accountHolderName", seniorCitizenModel.getCustomerName());
			seniorCitizenMap.put("mobNumber", seniorCitizenModel.getCustomermobileNo());
			seniorCitizenMap.put("accountNum", seniorCitizenModel.getCustomeraccountNo());
			seniorCitizenMap.put("money", seniorCitizenModel.getDepositAmount());
			seniorCitizenMap.put("age", seniorCitizenModel.getAge());
			seniorCitizenMap.put("amountPaymentDate", seniorCitizenModel.getAmountDepositDate());
			seniorCitizenMap.put("returnDate", seniorCitizenModel.getReturnDate());
			seniorCitizenMap.put("interestAmount", seniorCitizenModel.getSimpleInterest());
			seniorCitizenMap.put("maturity_amount", seniorCitizenModel.getPaymentMaturity());
			seniorCitizenMap.put("total_amount", seniorCitizenModel.getAmountTotal());
			seniorDepositList.add(seniorCitizenMap);
		}
		ObjectMapper seniorCitizenMapper = new ObjectMapper();
		String seniorCitizenAction = seniorCitizenMapper.writeValueAsString(seniorDepositList);
		model.addAttribute("SeniorUsersList", seniorCitizenAction);
		return seniorCitizenUserList;
	}

	@Override
	public void registeredPostDeliveredMethod(RegisteredPostModel registeredPostModel) {
		Integer trackingNo = registeredPostModel.getTrackingNo();
		String save = "update registered_post set status ='Delivered' where tracking_no=?";
		Object[] params = { trackingNo };
		jdbcTemplate.update(save, params);
	}

	@Override
	public void registeredPostProcessingMethod(RegisteredPostModel registeredPostModel) {
		Integer trackNo = registeredPostModel.getTrackingNo();
		String save = "update registered_post set status ='Processing' where tracking_no=?";
		Object[] params = { trackNo };
		jdbcTemplate.update(save, params);
	}

	@Override
	public void speedPostDeliveredMethod(SpeedPostModel speedPostModel) {
		Integer trackingNo = speedPostModel.getTrackingNo();
		String save = "update speed_post set status ='Delivered' where tracking_no=?";
		Object[] params = { trackingNo };
		System.out.println(trackingNo);
		jdbcTemplate.update(save, params);
	}

	@Override
	public void speedPostProcessingMethod(SpeedPostModel speedPostModel) {
		Integer trackNo = speedPostModel.getTrackingNo();
		String save = "update speed_post set status ='Processing' where tracking_no=?";
		Object[] params = { trackNo };
		System.out.println(trackNo);
		jdbcTemplate.update(save, params);
	}
}
