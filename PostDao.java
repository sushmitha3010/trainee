package com.chainsys.postofficemanagement.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.chainsys.postofficemanagement.mapper.AccountNoMapper;
import com.chainsys.postofficemanagement.mapper.CheckExistingMailIdMapper;
import com.chainsys.postofficemanagement.mapper.CheckExistingMobileNoMapper;
import com.chainsys.postofficemanagement.mapper.DateViewMapper;
import com.chainsys.postofficemanagement.mapper.ProfileMapper;
import com.chainsys.postofficemanagement.mapper.RecurringMapper;
import com.chainsys.postofficemanagement.mapper.RegisterDateViewMapper;
import com.chainsys.postofficemanagement.mapper.RegisterViewMapper;
import com.chainsys.postofficemanagement.mapper.RegisteredPostMapper;
import com.chainsys.postofficemanagement.mapper.SeniorCitizenMapper;
import com.chainsys.postofficemanagement.mapper.SeniorDateViewMapper;
import com.chainsys.postofficemanagement.mapper.SpeedDateViewMapper;
import com.chainsys.postofficemanagement.mapper.SpeedMapper;
import com.chainsys.postofficemanagement.mapper.TimeDateViewMapper;
import com.chainsys.postofficemanagement.mapper.TimeMapper;
import com.chainsys.postofficemanagement.mapper.UserLoginMapper;
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
import com.chainsys.postofficemanagement.util.ConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostDao implements PostInterface {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	Logger logger = LoggerFactory.getLogger(PostDao.class);

	private static final String USERNAME = "UserName";
	private static final String ACCOUNTNO = "AccountNo";
	private static final String MOBILENO = "mobileNo";

	public void saveRegisterDetails(User register, HttpSession session) {
		logger.info("Insert Register");
		String userName = register.getUserName();
		String password = register.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);

		String save = "insert into customer(user_name,password,mobile_no,mail_id,account_no,address)values(?,?,?,?,?,?)";
		Object[] params = { register.getUserName(), encodedPassword, register.getMobileNo(), register.getMailId(),
				register.getAccountNo(), register.getAddress() };
		Integer row = jdbcTemplate.update(save, params);
		if (row == 1) {
			session.setAttribute(USERNAME, register.getUserName());
			session.setAttribute(ACCOUNTNO, register.getAccountNo());
			session.setAttribute(MOBILENO, register.getMobileNo());
			String query = "select user_name,account_no from customer where user_name=?";
			User userList = jdbcTemplate.queryForObject(query, new AccountNoMapper(), userName);

			Long accNo = userList.getAccountNo();
			session.setAttribute(ACCOUNTNO, accNo);

		} else
			logger.error("not inserted");
	}

	public void listRegisterPostUserProfile(Model model, HttpSession session) throws JsonProcessingException {
		String userName = session.getAttribute(USERNAME).toString();
		String sql = "select sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_charge from registered_post where sender_name=?";
		List<RegisteredPostModel> registeredPostPassBookList = jdbcTemplate.query(sql, new RegisteredPostMapper(),
				userName);
		List<Map<String, Object>> registeredPostUserList = new ArrayList<>();
		for (RegisteredPostModel registeredPostPassBook : registeredPostPassBookList) {
			Map<String, Object> registeredPostPassBookMap = new HashMap<>();
			registeredPostPassBookMap.put("sender_name", registeredPostPassBook.getSendUserName());
			registeredPostPassBookMap.put("sender_mobile_no", registeredPostPassBook.getSendUserMobileNo());
			registeredPostPassBookMap.put("sender_address", registeredPostPassBook.getSendUserAddress());
			registeredPostPassBookMap.put("parcel_weight", registeredPostPassBook.getParcelWeight());
			registeredPostPassBookMap.put("receiver_name", registeredPostPassBook.getReceiveUserName());
			registeredPostPassBookMap.put("receiver_mobile_no", registeredPostPassBook.getReceiveUserMobileNo());
			registeredPostPassBookMap.put("receiver_address", registeredPostPassBook.getReceiveUserAddress());
			registeredPostPassBookMap.put("booking_date", registeredPostPassBook.getBookingDate());
			registeredPostPassBookMap.put("tracking_no", registeredPostPassBook.getTrackingNo());
			registeredPostPassBookMap.put("parcelStatus", registeredPostPassBook.getTrackingStatus());
			registeredPostPassBookMap.put("parcelCharge", registeredPostPassBook.getParcelCharge());
			registeredPostUserList.add(registeredPostPassBookMap);
		}
		ObjectMapper registeredPostPassBookMapper = new ObjectMapper();
		String registeredPostPassBookAction = registeredPostPassBookMapper.writeValueAsString(registeredPostUserList);
		model.addAttribute("registeredPostUserList", registeredPostPassBookAction);
	}

	public void listspeedPostUserProfile(Model model, HttpSession session) throws JsonProcessingException {
		String userName = session.getAttribute(USERNAME).toString();
		String sql = "select sender_name,sender_mobile_no,sender_address,distance,receiver_name,receiver_mobile_no,receiver_address,booking_date,tracking_no,status,parcel_Charge  from speed_post where sender_name=?";
		List<SpeedPostModel> speedPostPassBookList = jdbcTemplate.query(sql, new SpeedMapper(), userName);
		List<Map<String, Object>> speedPostPassBookUserList = new ArrayList<>();
		for (SpeedPostModel speedPostPassBook : speedPostPassBookList) {
			Map<String, Object> speedPostPassBookMap = new HashMap<>();
			speedPostPassBookMap.put("senderName", speedPostPassBook.getSenderName());
			speedPostPassBookMap.put("senderMobileNo", speedPostPassBook.getSenderMobileNo());
			speedPostPassBookMap.put("senderUserAddress", speedPostPassBook.getSenderAddress());
			speedPostPassBookMap.put("kms", speedPostPassBook.getKms());
			speedPostPassBookMap.put("receiveUserName", speedPostPassBook.getReceiverName());
			speedPostPassBookMap.put("receiveUserMobileNo", speedPostPassBook.getReceiverMobileNo());
			speedPostPassBookMap.put("receiverUserAddress", speedPostPassBook.getReceiverAddress());
			speedPostPassBookMap.put("bookDate", speedPostPassBook.getBookingDate());
			speedPostPassBookMap.put("trackingCode", speedPostPassBook.getTrackingNo());
			speedPostPassBookMap.put("parcel_status", speedPostPassBook.getStatus());
			speedPostPassBookMap.put("charge", speedPostPassBook.getCharge());
			speedPostPassBookUserList.add(speedPostPassBookMap);
		}
		ObjectMapper speedPostPassBookMapper = new ObjectMapper();
		String speedPostPassBookAction = speedPostPassBookMapper.writeValueAsString(speedPostPassBookUserList);
		model.addAttribute("speedPostUserList", speedPostPassBookAction);
	}

	public List<RecurringDepositModel> listRecurringDepositPassbook(Model model, HttpSession session)
			throws JsonProcessingException {
		String accountNumber = session.getAttribute(ACCOUNTNO).toString();
		String sql = "select user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount from recurring_deposit where account_no=? ";
		List<RecurringDepositModel> recurringDepositPassBookUserList = jdbcTemplate.query(sql, new RecurringMapper(),
				accountNumber);
		List<Map<String, Object>> recurringDepositPassBookList = new ArrayList<>();
		for (RecurringDepositModel recurringDepositPassBookModel : recurringDepositPassBookUserList) {
			Map<String, Object> recurringDepositPassBookMap = new HashMap<>();
			recurringDepositPassBookMap.put("customerName", recurringDepositPassBookModel.getDeposituserName());
			recurringDepositPassBookMap.put("contactNo", recurringDepositPassBookModel.getDepositUserMobileNo());
			recurringDepositPassBookMap.put("accountNumber", recurringDepositPassBookModel.getUserAccountNumber());
			recurringDepositPassBookMap.put("principleAmount", recurringDepositPassBookModel.getDepositAmount());
			recurringDepositPassBookMap.put("noOfMonths", recurringDepositPassBookModel.getNoOfMonths());
			recurringDepositPassBookMap.put("depositDate", recurringDepositPassBookModel.getDepositDate());
			recurringDepositPassBookMap.put("amountReturnDate", recurringDepositPassBookModel.getDepositReturnDate());

			recurringDepositPassBookMap.put("Interest", recurringDepositPassBookModel.getInterest());
			recurringDepositPassBookMap.put("maturityAmount", recurringDepositPassBookModel.getMaturityAMount());
			recurringDepositPassBookMap.put("totalAmount", recurringDepositPassBookModel.getTotalAmount());
			recurringDepositPassBookList.add(recurringDepositPassBookMap);
		}
		ObjectMapper recurringDepositPassBookMapper = new ObjectMapper();
		String recurringDepositPassBookAction = recurringDepositPassBookMapper
				.writeValueAsString(recurringDepositPassBookList);
		List<Map<String, Object>> recurringDepositPassBook = recurringDepositPassBookList.stream().toList();
		model.addAttribute("recurringDepositList", recurringDepositPassBookAction);
		return recurringDepositPassBookUserList;
	}

	public List<TimeDepositModel> listTimeDepositPassbook(Model model, HttpSession session)
			throws JsonProcessingException {
		String accountNumber = session.getAttribute(ACCOUNTNO).toString();
		String sql = "select user_name,mobile_no,account_no,principle_amount,periods,deposit_date,return_date,interest,maturity_amount,total_amount from time_deposit where account_no=?";
		List<TimeDepositModel> timeDepositPassBookUserList = jdbcTemplate.query(sql, new TimeMapper(), accountNumber);
		List<Map<String, Object>> timeDepositPassBookList = new ArrayList<>();
		for (TimeDepositModel timeDepositPassBookModel : timeDepositPassBookUserList) {
			Map<String, Object> timeDepositPassBookMap = new HashMap<>();
			timeDepositPassBookMap.put("depositUserName", timeDepositPassBookModel.getName());
			timeDepositPassBookMap.put("mobNo", timeDepositPassBookModel.getPhoneNo());
			timeDepositPassBookMap.put("acctNumber", timeDepositPassBookModel.getAccountNo());
			timeDepositPassBookMap.put("initialAmount", timeDepositPassBookModel.getAmount());
			timeDepositPassBookMap.put("periods", timeDepositPassBookModel.getPeriods());
			timeDepositPassBookMap.put("paymentDate", timeDepositPassBookModel.getDepositDate());
			timeDepositPassBookMap.put("depsoitReturnDate", timeDepositPassBookModel.getCompletedate());
			timeDepositPassBookMap.put("simple_interest", timeDepositPassBookModel.getSimpleInterest());
			timeDepositPassBookMap.put("paymentMaturity", timeDepositPassBookModel.getMaturity());
			timeDepositPassBookMap.put("totalPayment", timeDepositPassBookModel.getTotal());
			timeDepositPassBookList.add(timeDepositPassBookMap);
		}
		ObjectMapper timeDepositPassBookMapper = new ObjectMapper();
		String timeDepositAction = timeDepositPassBookMapper.writeValueAsString(timeDepositPassBookList);
		model.addAttribute("timeDepositUsersList", timeDepositAction);
		return timeDepositPassBookUserList;
	}

	public List<SeniorCitizenModel> listSeniorCitizenDepositPassbook(Model model, HttpSession session)
			throws JsonProcessingException {
		String accountNumber = session.getAttribute(ACCOUNTNO).toString();
		String sql = "select  user_name,mobile_no,account_no,principle_amount,age,deposit_date,return_date,interest,maturity_amount,total_amount from senior_citizen_deposit where account_no=?";
		List<SeniorCitizenModel> seniorCitizenPassBookList = jdbcTemplate.query(sql, new SeniorCitizenMapper(),
				accountNumber);
		List<Map<String, Object>> seniorDepositPassBookList = new ArrayList<>();
		for (SeniorCitizenModel seniorCitizenPassBookModel : seniorCitizenPassBookList) {
			Map<String, Object> seniorCitizenPassBookMap = new HashMap<>();
			seniorCitizenPassBookMap.put("accountHolderName", seniorCitizenPassBookModel.getCustomerName());
			seniorCitizenPassBookMap.put("mobNumber", seniorCitizenPassBookModel.getCustomermobileNo());
			seniorCitizenPassBookMap.put("accountNum", seniorCitizenPassBookModel.getCustomeraccountNo());
			seniorCitizenPassBookMap.put("money", seniorCitizenPassBookModel.getDepositAmount());
			seniorCitizenPassBookMap.put("age", seniorCitizenPassBookModel.getAge());
			seniorCitizenPassBookMap.put("amountPaymentDate", seniorCitizenPassBookModel.getAmountDepositDate());
			seniorCitizenPassBookMap.put("amountReDate", seniorCitizenPassBookModel.getReturnDate());
			seniorCitizenPassBookMap.put("interestAmount", seniorCitizenPassBookModel.getSimpleInterest());
			seniorCitizenPassBookMap.put("maturity_amount", seniorCitizenPassBookModel.getPaymentMaturity());
			seniorCitizenPassBookMap.put("total_amount", seniorCitizenPassBookModel.getAmountTotal());
			seniorDepositPassBookList.add(seniorCitizenPassBookMap);
		}
		ObjectMapper seniorCitizenPassBookMapper = new ObjectMapper();
		String seniorCitizenPassBookAction = seniorCitizenPassBookMapper.writeValueAsString(seniorDepositPassBookList);
		model.addAttribute("SeniorUsersList", seniorCitizenPassBookAction);
		return seniorCitizenPassBookList;
	}

	public boolean userLogin(User register, HttpSession session) {

		String userName = register.getUserName();
		String password = register.getPassword();
		Long accNo = register.getAccountNo();
		logger.info("To Login User");
		String query = "select user_name,password,mobile_no,account_no from customer where user_name=?";
		User userList = jdbcTemplate.queryForObject(query, new UserLoginMapper(), userName);
		session.setAttribute(USERNAME, userName);

		String password1 = userList.getPassword();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean match = encoder.matches(password, password1);
		if (match) {
			
			
			String sql="select user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount from recurring_deposit where account_no=? ";
			List<RecurringDepositModel> recurringSlip = jdbcTemplate.query(sql, new RecurringMapper(),accNo);
			List<Map<String,Object>> recurringSlipGet = new ArrayList<>();
			for (RecurringDepositModel paySlip : recurringSlip) {
				Map<String, Object> paymentSlipMap = new HashMap<>();
				
				paymentSlipMap.put(USERNAME, paySlip.getDeposituserName());
				String userName1=paySlip.getDeposituserName();
				session.setAttribute("UserName", userName1);
				
				paymentSlipMap.put(MOBILENO, paySlip.getDepositUserMobileNo());
				Long mobileNo=paySlip.getDepositUserMobileNo();
				session.setAttribute("MobileNo", mobileNo);
				
				paymentSlipMap.put("accountNumber", paySlip.getUserAccountNumber());
				Long acoountNum=paySlip.getUserAccountNumber();
				session.setAttribute("accountNo", acoountNum);
				
				paymentSlipMap.put("paidAmount", paySlip.getDepositAmount());
				Integer amount=paySlip.getDepositAmount();
				session.setAttribute("paidAmount", amount);
				
				paymentSlipMap.put("noOfMonths", paySlip.getNoOfMonths());
				Integer months=paySlip.getNoOfMonths();
				session.setAttribute("months", months);
				
				paymentSlipMap.put("depositDate", paySlip.getDepositDate());
				Date depositDate=paySlip.getDepositDate();
				session.setAttribute("date", depositDate);
				
				paymentSlipMap.put("returnDate", paySlip.getDepositReturnDate());
				Date returnDate=paySlip.getDepositReturnDate();
				session.setAttribute("reDate", returnDate);
				
				paymentSlipMap.put("interest", paySlip.getInterest());
				float interest=paySlip.getInterest();
				session.setAttribute("interest", interest);
				
				paymentSlipMap.put("maturityAmount", paySlip.getMaturityAMount());
				float maturityAmount=paySlip.getMaturityAMount();
				session.setAttribute("maturity", maturityAmount);
				
				paymentSlipMap.put("totalAmount", paySlip.getTotalAmount());
				float totalAmount=paySlip.getTotalAmount();
				session.setAttribute("total", totalAmount);
				
				recurringSlipGet.add(paymentSlipMap);
				
				
			}
			
			logger.info("Login Successully");
			Long accountNo = userList.getAccountNo();
			Long mobileNo = userList.getMobileNo();
			session.setAttribute(ACCOUNTNO, accountNo);
			session.setAttribute(MOBILENO, mobileNo);
			return true;
		}
		return false;
	}

	public void recurringDepositCount(HttpSession session, Model model) {
		Long acctNo = (Long) session.getAttribute(ACCOUNTNO);
		String sql = "  select count (*) from recurring_deposit where account_no=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, acctNo);
		model.addAttribute("count", count);
		session.setAttribute("Count", count);
	}

	public void saveRecurringDepositDetails(RecurringDepositModel recurringDeposit, HttpSession session) {
		String save = "insert into recurring_deposit(user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount)values(?,?,?,?,?,localtimestamp,add_months(sysdate,?),?,?,?)";
		Object[] params = { recurringDeposit.getDeposituserName(), recurringDeposit.getDepositUserMobileNo(),
				recurringDeposit.getUserAccountNumber(), recurringDeposit.getDepositAmount(),
				recurringDeposit.getNoOfMonths(), recurringDeposit.getNoOfMonths(), recurringDeposit.getInterest(),
				recurringDeposit.getMaturityAMount(), recurringDeposit.getTotalAmount() };
		jdbcTemplate.update(save, params);

		session.setAttribute(USERNAME, recurringDeposit.getDeposituserName());
		session.setAttribute("accountNo", recurringDeposit.getUserAccountNumber());
		session.setAttribute("paidAmount", recurringDeposit.getDepositAmount());
		session.setAttribute(MOBILENO, recurringDeposit.getDepositUserMobileNo());
		session.setAttribute("months", recurringDeposit.getNoOfMonths());
		session.setAttribute("interest", recurringDeposit.getInterest());
		session.setAttribute("maturity", recurringDeposit.getMaturityAMount());
		session.setAttribute("total", recurringDeposit.getTotalAmount());
           
		String sql1 = "select deposit_date,return_date from recurring_deposit where account_no=?";

		List<RecurringDepositModel> registerView = jdbcTemplate.query(sql1, new DateViewMapper(),
				recurringDeposit.getUserAccountNumber());
		for (RecurringDepositModel register : registerView) {
			session.setAttribute("date", register.getDepositDate());
			session.setAttribute("reDate", register.getDepositReturnDate());
		}
	}

	public void saveTimeDepositDetails(TimeDepositModel timeDeposit, HttpSession session) {
		logger.info("Insert Time Deposit Details");
		String save = "insert into time_deposit(user_name,mobile_no,account_no,principle_amount,periods,deposit_date,return_date,interest,maturity_amount,total_amount)values(?,?,?,?,?,localtimestamp,add_months(sysdate,?),?,?,?)";
		Integer period = timeDeposit.getPeriods() * 12;
		Object[] params = { timeDeposit.getName(), timeDeposit.getPhoneNo(), timeDeposit.getAccountNo(),
				timeDeposit.getAmount(), timeDeposit.getPeriods(), period, timeDeposit.getSimpleInterest(),
				timeDeposit.getMaturity(), timeDeposit.getTotal() };
		jdbcTemplate.update(save, params);

		session.setAttribute(USERNAME, timeDeposit.getName());
		session.setAttribute(MOBILENO, timeDeposit.getPhoneNo());
		session.setAttribute("accountNo", timeDeposit.getAccountNo());
		session.setAttribute("depositAmount", timeDeposit.getAmount());
		session.setAttribute("period", timeDeposit.getPeriods());
		session.setAttribute("interest", timeDeposit.getSimpleInterest());
		session.setAttribute("maturity", timeDeposit.getMaturity());
		session.setAttribute("total", timeDeposit.getTotal());

		String sql = "select deposit_date,return_date from time_deposit where account_no=?";

		List<TimeDepositModel> registerView = jdbcTemplate.query(sql, new TimeDateViewMapper(),
				timeDeposit.getAccountNo());
		for (TimeDepositModel time : registerView) {
			session.setAttribute("date", time.getDepositDate());
			session.setAttribute("returnDate", time.getCompletedate());
		}
	}

	public void saveSeniorCitizenDetail(SeniorCitizenModel seniorCitizen, HttpSession session) {
		logger.info("Insert Senior Citizen Details");
		String save = "insert into senior_citizen_deposit(user_name,mobile_no,account_no,principle_amount,age,deposit_date,return_date,interest,maturity_amount,total_amount)values(?,?,?,?,?,localTimeStamp,add_months(sysdate,60),?,?,?)";
		Object[] params = { seniorCitizen.getCustomerName(), seniorCitizen.getCustomermobileNo(),
				seniorCitizen.getCustomeraccountNo(), seniorCitizen.getDepositAmount(), seniorCitizen.getAge(),
				seniorCitizen.getSimpleInterest(), seniorCitizen.getPaymentMaturity(), seniorCitizen.getAmountTotal() };
		jdbcTemplate.update(save, params);
		session.setAttribute(USERNAME, seniorCitizen.getCustomerName());
		session.setAttribute("mobNo", seniorCitizen.getCustomermobileNo());
		session.setAttribute("acctNo", seniorCitizen.getCustomeraccountNo());
		session.setAttribute("PaymentAmount", seniorCitizen.getDepositAmount());
		session.setAttribute("age", seniorCitizen.getAge());
		session.setAttribute("simepleInterest", seniorCitizen.getSimpleInterest());
		session.setAttribute("totalMaturity", seniorCitizen.getPaymentMaturity());
		session.setAttribute("totalAmount", seniorCitizen.getAmountTotal());

		String sql = "select deposit_date,return_date from senior_citizen_deposit where account_no=?";

		List<SeniorCitizenModel> registerView = jdbcTemplate.query(sql, new SeniorDateViewMapper(),
				seniorCitizen.getCustomeraccountNo());
		for (SeniorCitizenModel senior : registerView) {
			session.setAttribute("startdate", senior.getAmountDepositDate());
			session.setAttribute("completeDate", senior.getReturnDate());
		}
	}

	public void saveRegisterPostDetail(RegisteredPostModel registerPost, HttpSession session) {
		logger.info("Insert Registered Post Details");
		String save = "insert into registered_post(sender_name,sender_mobile_no,sender_address,parcel_weight,receiver_name,receiver_mobile_no,receiver_address,booking_date,status,parcel_charge)values(?,?,?,?,?,?,?,localtimestamp,'sending',?)";

		Object[] params = { registerPost.getSendUserName(), registerPost.getSendUserMobileNo(),
				registerPost.getSendUserAddress(), registerPost.getParcelWeight(), registerPost.getReceiveUserName(),
				registerPost.getReceiveUserMobileNo(), registerPost.getReceiveUserAddress(),
				registerPost.getParcelCharge() };
		jdbcTemplate.update(save, params);
		session.setAttribute("userName", registerPost.getSendUserName());
		session.setAttribute("senderMobile", registerPost.getSendUserMobileNo());
		session.setAttribute("senderAddress", registerPost.getSendUserAddress());
		session.setAttribute("parcelWeight", registerPost.getParcelWeight());
		session.setAttribute("receiverName", registerPost.getReceiveUserName());
		session.setAttribute("receiverMobileNo", registerPost.getReceiveUserMobileNo());
		session.setAttribute("receiverAddress", registerPost.getReceiveUserAddress());
		session.setAttribute("parcelAmount", registerPost.getParcelCharge());

		String sql = "select tracking_no,booking_date from registered_post  where sender_name=?";

		List<RegisteredPostModel> registerView = jdbcTemplate.query(sql, new RegisterDateViewMapper(),
				registerPost.getSendUserName());
		for (RegisteredPostModel senior : registerView) {
			session.setAttribute("bookingDate", senior.getBookingDate());
			session.setAttribute("trackingNo", senior.getTrackingNo());
		}
	}

	public List<RegisteredPostModel> registeredPostTracking(RegisteredPostModel registeredPostModel, Model model) {
		Integer trackingNo = registeredPostModel.getTrackingNo();
		String sql = "select status from registered_post where tracking_no=?";
		List<RegisteredPostModel> registerView = jdbcTemplate.query(sql, new RegisterViewMapper(), trackingNo);
		List<Map<String, Object>> viewList = new ArrayList<>();
		for (RegisteredPostModel registeredPostList : registerView) {
			Map<String, Object> registeredPostMap = new HashMap<>();
			registeredPostMap.put("status", registeredPostList.getTrackingStatus());
			viewList.add(registeredPostMap);
		}
		model.addAttribute("registeredPostView", viewList);
		return registerView;
	}

	public String speedPostTracking(SpeedPostModel speedPost) {
		Integer trackingNo = speedPost.getTrackingNo();
		String sql = "select status from speed_post where tracking_no=?";
		String queryForObject = null;
		try {
			queryForObject = jdbcTemplate.queryForObject(sql, String.class, trackingNo);
			logger.info(queryForObject);
		} catch (EmptyResultDataAccessException e) {
			logger.info("view");
		}
		return queryForObject;
	}

	public void saveSpeedPostDetail(SpeedPostModel speedPost, HttpSession session) {
		logger.info("Insert Speed Post Details");
		String save = "insert into speed_post(sender_name,sender_mobile_no,sender_address,distance,receiver_name,receiver_mobile_no,receiver_address,booking_date,status,parcel_charge)values(?,?,?,?,?,?,?,localtimestamp,'sending',?)";
		Object[] params = { speedPost.getSenderName(), speedPost.getSenderMobileNo(), speedPost.getSenderAddress(),
				speedPost.getKms(), speedPost.getReceiverName(), speedPost.getReceiverMobileNo(),
				speedPost.getReceiverAddress(), speedPost.getCharge() };
		jdbcTemplate.update(save, params);

		session.setAttribute(USERNAME, speedPost.getSenderName());
		session.setAttribute("charge", speedPost.getCharge());
		session.setAttribute("senderMobileNumber", speedPost.getSenderMobileNo());
		session.setAttribute("senderAddress", speedPost.getSenderAddress());
		session.setAttribute("kms", speedPost.getKms());
		session.setAttribute("receiverName", speedPost.getReceiverName());
		session.setAttribute("receiverMobileNo", speedPost.getReceiverMobileNo());
		session.setAttribute("receiverAddress", speedPost.getReceiverAddress());
		session.setAttribute("ChargeAmount", speedPost.getCharge());

		String sql = "select tracking_no,booking_date from speed_post  where sender_name=?";

		List<SpeedPostModel> registerView = jdbcTemplate.query(sql, new SpeedDateViewMapper(),
				speedPost.getSenderName());
		for (SpeedPostModel senior : registerView) {
			session.setAttribute("bookingDate", senior.getBookingDate());
			session.setAttribute("trackingNo", senior.getTrackingNo());
		}
	}

	@Override
	public void recurringDepositPayment(RecurringPayment recurringPayment, HttpSession session) {
		logger.info("recurring Payment");
		String save = "insert into recurring_payment(user_name,amount,payment_date)values(?,?,localtimestamp)";
		recurringPayment.getDepositUserName();
		recurringPayment.getRecurPrincipleAmount();
		Object[] params = { recurringPayment.getDepositUserName(), recurringPayment.getRecurPrincipleAmount() };
		jdbcTemplate.update(save, params);

		session.setAttribute("paidAmount", recurringPayment.getRecurPrincipleAmount());
	}

	public void timeDepositPayment(TimeDepositPayment timeDepositPayment) {
		String save = "insert into time_deposit_payment(user_name,amount,payment_date)values(?,?,localtimestamp)";
		Object[] params = { timeDepositPayment.getUserName(), timeDepositPayment.getAmount() };
		jdbcTemplate.update(save, params);
	}

	public void seniorCitizenDepositPayment(SeniorCitizenPayment seniorPayment) {
		String save = "insert into senior_deposit_payment(user_name,amount,payment_date)values(?,?,localtimestamp)";
		Object[] params = { seniorPayment.getCustomerName(), seniorPayment.getDepositAmount1() };

		jdbcTemplate.update(save, params);
	}

	public void registerPostPayment(RegisteredPostPaymentModel registeredPostPaymentModel, HttpSession session) {
		String save = "insert into registered_post_payment(sender_name,amount,status,paid_date)values(?,?,'Sending',localtimestamp)";
		String name = registeredPostPaymentModel.getRegisteredPostUserName();
		float amount = registeredPostPaymentModel.getRegisteredPostParcelCharge();
		session.setAttribute("ChargeAmount", registeredPostPaymentModel.getRegisteredPostParcelCharge());
		Object[] params = { name, amount };
		jdbcTemplate.update(save, params);
	}

	public void speedPostPayment(SpeedPostPaymentModel speedPostPaymentModel) {
		String save = "insert into Speed_post_Payment(sender_name,amount,status,paid_date)values(?,?,'sending',localtimestamp)";
		Object[] params = { speedPostPaymentModel.getPostSenderName(), speedPostPaymentModel.getCharge() };
		jdbcTemplate.update(save, params);
	}

	public void passwordUpdate(User register) {
		String sql = "update customer set password=? where user_name=?";
		Object[] params = { register.getPassword(), register.getUserName() };
		jdbcTemplate.update(sql, params);
	}

	public void registerUserProfile(User register, HttpSession session) {
		String userName = session.getAttribute(USERNAME).toString();
		String sql = "update customer set password=?,mobile_no=?,account_no=?,mail_id=?,address=? where user_name=?";
		Object[] params = { register.getPassword(), register.getMobileNo(), register.getAccountNo(),
				register.getMailId(), register.getAddress(), userName };
		jdbcTemplate.update(sql, params);
	}

	public void getProfileDetails(HttpSession session) {
		Long acctountNumber = (Long) session.getAttribute(ACCOUNTNO);
		String sql = "select user_name,password,mobile_no,account_no,mail_id,address from customer";
		List<User> userProfile = jdbcTemplate.query(sql, new ProfileMapper());
		List<User> userProfile1 = userProfile.stream()
				.filter(profiles -> profiles.getAccountNo().equals(acctountNumber)).toList();
		for (User profile : userProfile1) {

			String userName = profile.getUserName();
			session.setAttribute(USERNAME, userName);

			String password = profile.getPassword();
			session.setAttribute("Password", password);

			Long mobileNo = profile.getMobileNo();
			session.setAttribute("MobileNo", mobileNo);

			Long accountNo = profile.getAccountNo();
			session.setAttribute(ACCOUNTNO, accountNo);

			String mailId = profile.getMailId();
			session.setAttribute("Email", mailId);

			String address = profile.getAddress();
			session.setAttribute("Address", address);
		}
	}

	public Boolean existingMailIdCheck(String mailId, Model model) {
		String query = "Select mail_id from customer where mail_id =?";
		List<User> emailIdList = jdbcTemplate.query(query, new CheckExistingMailIdMapper(), mailId);
		for (User checkMailId : emailIdList) {
			String mail = checkMailId.getMailId();
			if (mail.equals(mailId)) {
				String existingMail = "Existing Mail Id!!! Please Enter New Mail Id";
				model.addAttribute("errorMessage1", existingMail);
				model.addAttribute("MailId", mail);
				return false;
			}
		}
		return true;
	}

	public Boolean existingMobileNoCheck(Long mobileNo, Model model) {
		String mobileNumber = Long.toString(mobileNo);
		String query = "Select mobile_no from customer where mobile_no =?";
		List<User> userMobileNoList = jdbcTemplate.query(query, new CheckExistingMobileNoMapper(), mobileNumber);
		for (User checkMobileNo : userMobileNoList) {
			String mobileNo1 = checkMobileNo.getMobileNo().toString();
			if (mobileNo1.equals(mobileNumber)) {
				String existingAMobileNo = "Excisting Mobile Number!!! Please Enter New Mobile Number";
				model.addAttribute("errorMessage1", existingAMobileNo);
				model.addAttribute("MobileNo", mobileNo);
				return false;
			}
		}
		return true;
	}
	
	public List<RecurringDepositModel> getRecurringPayment(HttpSession session){
		Long accNo = (Long) session.getAttribute(ACCOUNTNO);
	String sql="select user_name,mobile_no,account_no,principle_amount,no_of_months,deposit_date,return_date,interest,maturity_amount,total_amount from recurring_deposit where account_no=? ";
	List<RecurringDepositModel> recurringSlip = jdbcTemplate.query(sql, new RecurringMapper(),accNo);
	List<Map<String,Object>> recurringSlipGet = new ArrayList<>();
	for (RecurringDepositModel paySlip : recurringSlip) {
		Map<String, Object> paymentSlipMap = new HashMap<>();
		
		paymentSlipMap.put(USERNAME, paySlip.getDeposituserName());
		String userName1=paySlip.getDeposituserName();
		session.setAttribute("UserName", userName1);
		
		paymentSlipMap.put(MOBILENO, paySlip.getDepositUserMobileNo());
		Long mobileNo=paySlip.getDepositUserMobileNo();
		session.setAttribute("MobileNo", mobileNo);
		
		paymentSlipMap.put("accountNumber", paySlip.getUserAccountNumber());
		Long acoountNum=paySlip.getUserAccountNumber();
		session.setAttribute("accountNo", acoountNum);
		
		paymentSlipMap.put("paidAmount", paySlip.getDepositAmount());
		Integer amount=paySlip.getDepositAmount();
		session.setAttribute("paidAmount", amount);
		
		paymentSlipMap.put("noOfMonths", paySlip.getNoOfMonths());
		Integer months=paySlip.getNoOfMonths();
		session.setAttribute("months", months);
		
		paymentSlipMap.put("depositDate", paySlip.getDepositDate());
		Date depositDate=paySlip.getDepositDate();
		session.setAttribute("date", depositDate);
		
		paymentSlipMap.put("returnDate", paySlip.getDepositReturnDate());
		Date returnDate=paySlip.getDepositReturnDate();
		session.setAttribute("reDate", returnDate);
		
		paymentSlipMap.put("interest", paySlip.getInterest());
		float interest=paySlip.getInterest();
		session.setAttribute("interest", interest);
		
		paymentSlipMap.put("maturityAmount", paySlip.getMaturityAMount());
		float maturityAmount=paySlip.getMaturityAMount();
		session.setAttribute("maturity", maturityAmount);
		
		paymentSlipMap.put("totalAmount", paySlip.getTotalAmount());
		float totalAmount=paySlip.getTotalAmount();
		session.setAttribute("total", totalAmount);
		
		recurringSlipGet.add(paymentSlipMap);
		
		
	}
	return recurringSlip;
	}
	
}
