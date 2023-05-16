package com.chainsys.postofficemanagement.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.chainsys.postofficemanagement.service.PostService;
import com.chainsys.postofficemanagement.validation.DepositValidation;
import com.chainsys.postofficemanagement.validation.ParcelValidation;
import com.chainsys.postofficemanagement.validation.RegisterValidation;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class PostController1 {

	PostDao registerDao = new PostDao();
	PostService postService = new PostService();

	Integer obj = null;

	Logger logger = LoggerFactory.getLogger(PostController1.class);

	private static final String DASHBOARD = "Dashboard.html";
	private static final String USERLOGIN = "User.html";
	private static final String ERRORPOPUP = "ErrorPopup.html";
	private static final String POPUPMESSAGE = "errorMessage1";
	private static final String ERRORMESSAGE = "errorMessage";
	private static final String POPUP = "ErrorMessage";

	@GetMapping("/")
	public String dash() {
		logger.info("Through Controller");
		return DASHBOARD;
	}

	@GetMapping("/userRegister")
	public String userRegister(@ModelAttribute("register") User register, HttpSession session) {
		return "Register.html";
	}

	@GetMapping("/register")
	public String register(@ModelAttribute("register") User register, HttpSession session, Model model) {
		logger.info("Saving Register Details");
		RegisterValidation registerValidation = new RegisterValidation();
		for (int i = 1; i <= 17; i++) {
			session.removeAttribute(POPUPMESSAGE + i);
		}
		if (Boolean.FALSE.equals(registerValidation.userNameValidation(register.getUserName(), model))
				|| Boolean.FALSE.equals(registerValidation.passwordValidation(register.getPassword(), model))
				|| Boolean.FALSE.equals(registerValidation.mobileNoValidation(register.getMobileNo(), model))
				|| Boolean.FALSE.equals(registerValidation.emailValidation(register.getMailId(), model))
				|| Boolean.FALSE.equals(registerValidation.addressValidation(register.getAddress(), model))
				|| Boolean.FALSE.equals(registerDao.existingMailIdCheck(register.getMailId(), model))
				|| Boolean.FALSE.equals(registerDao.existingMobileNoCheck(register.getMobileNo(), model))) {
			for (int j = 1; j <= 17; j++) {
				if (model.getAttribute(ERRORMESSAGE + j) != null) {
					String errorMessage = (String) model.getAttribute(ERRORMESSAGE + j);
					model.addAttribute(POPUP, errorMessage);
				}
			}
			return ERRORPOPUP;
		}
		postService.userRegister(register, session);
		return "RegisterSuccessfull.html";
	}

	@RequestMapping("/loginUser")
	public String loginUser(@ModelAttribute("login") User register, HttpSession session) {
		return USERLOGIN;
	}

	@GetMapping("/loginpostUser")
	public String loginpostUser(@ModelAttribute("login") User register, HttpSession session, Model model) {
		if (Boolean.TRUE.equals(postService.login1(register, session))) {
			return "LoginSuccessfull.html";
		} else if (Boolean.FALSE.equals(postService.login1(register, session))) {
			return USERLOGIN;
		}
		return USERLOGIN;
	}

	@GetMapping("/userDashBoard")
	public String userDashBorad() {
		return "UserDashboard.html";
	}

	@GetMapping("/depositDashBoard")
	public String depositDashBorad() {
		return "DepositDashBoard.html";
	}

	@GetMapping("/parcelDashBoard")
	public String parcelDashBorad() {
		return "ParcelDashBoard.html";
	}

	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "AboutUs.html";
	}

	@GetMapping("/contact")
	public String contactUs() {
		return "ContactUs.html";
	}

	@GetMapping("/contactUs")
	public String contactUsPage() {
		return DASHBOARD;
	}

	@GetMapping("/recurring")
	public String recurringDeposit(@ModelAttribute("recurring") RecurringDepositModel recurringDepositModel,
			HttpSession session, Model model) {
		logger.info("Saving Recurring Deposit Details");
		postService.recurringCount(session, model);
		model.getAttribute("count");
		return "RecurringDeposit.html";
	}

	@GetMapping("/recurringDeposit")
	public String recurringDepositInsert(@ModelAttribute("recurring") RecurringDepositModel recurringDeposit,
			HttpSession session, Model model) {
		DepositValidation depositValidation = new DepositValidation();
		for (int i = 1; i <= 17; i++) {
			session.removeAttribute(POPUPMESSAGE + i);
		}
		if (Boolean.FALSE.equals(depositValidation.amountValidation(recurringDeposit.getDepositAmount(), model))
				|| Boolean.FALSE.equals(depositValidation.monthValidation(recurringDeposit.getNoOfMonths(), model))) {
			for (int j = 1; j <= 17; j++) {
				if (model.getAttribute(ERRORMESSAGE + j) != null) {
					String errorMessage = (String) model.getAttribute(ERRORMESSAGE + j);
					model.addAttribute(POPUP, errorMessage);
				}
			}
			return ERRORPOPUP;
		}
		postService.recurringDepositDetails(recurringDeposit, session);
		return "RecurringPayment.html";
	}

	@GetMapping("/timeDepositModel")
	public String timeDepositModel(@ModelAttribute("timeDeposit") TimeDepositModel timeDepositModel,
			HttpSession session, Model model) {
		return "TimeDeposit.html";
	}

	@GetMapping("/timeDeposit")
	public String timeDeposit(@ModelAttribute("timeDeposit") TimeDepositModel timeDeposit, HttpSession session,
			Model model) {
		logger.info("Saving Time Deposit Records");
		DepositValidation depositValidation = new DepositValidation();
		for (int i = 1; i <= 17; i++) {
			session.removeAttribute(POPUPMESSAGE + i);
		}
		if (Boolean.FALSE.equals(depositValidation.amountValidation(timeDeposit.getAmount(), model))
				|| Boolean.FALSE.equals(depositValidation.monthValidation(timeDeposit.getPeriods(), model))) {
			for (int j = 1; j <= 17; j++) {
				if (model.getAttribute(ERRORMESSAGE + j) != null) {
					String errorMessage = (String) model.getAttribute(ERRORMESSAGE + j);
					model.addAttribute(POPUP, errorMessage);
				}
			}
			return ERRORPOPUP;
		}
		postService.timeDepositDetails(timeDeposit, session);
		return "TimeDepositPayment.html";
	}

	@GetMapping("/seniorCitizenModel")
	public String seniorCitizenDepositModel(@ModelAttribute("seniorCitizen") SeniorCitizenModel seniorCitizenModel,
			HttpSession session, Model model) {
		return "SeniorCitizen.html";
	}

	@GetMapping("/seniorCitizen")
	public String seniorCitizenDeposit(@ModelAttribute("seniorCitizen") SeniorCitizenModel seniorCitizen,
			HttpSession session, Model model) {
		logger.info("Saving Senior Records");
		DepositValidation depositValidation = new DepositValidation();
		for (int i = 1; i <= 17; i++) {
			session.removeAttribute(POPUPMESSAGE + i);
		}
		if (Boolean.FALSE.equals(depositValidation.amountValidation(seniorCitizen.getDepositAmount(), model))
				|| Boolean.FALSE.equals(depositValidation.ageValidation(seniorCitizen.getAge(), model))) {
			for (int j = 1; j <= 17; j++) {
				if (model.getAttribute(ERRORMESSAGE + j) != null) {
					String errorMessage = (String) model.getAttribute(ERRORMESSAGE + j);
					model.addAttribute(POPUP, errorMessage);
				}
			}
			return ERRORPOPUP;
		}
		postService.seniorDepositDetails(seniorCitizen, session);
		return "SeniorPayment.html";
	}

	@GetMapping("/registeredPostModel")
	public String registerPostModel(@ModelAttribute("registeredPost") RegisteredPostModel registeredPostModel,
			HttpSession session) {
		return "RegisteredPost.html";
	}

	@GetMapping("/registeredPost")
	public String registerPost(@ModelAttribute("registeredPost") RegisteredPostModel registerPost, HttpSession session,
			Model model) {
		logger.info("Saving Registered Post Records");
		ParcelValidation parcelValid = new ParcelValidation();
		for (int i = 1; i <= 17; i++) {
			session.removeAttribute(POPUPMESSAGE + i);
		}
		if (Boolean.FALSE.equals(parcelValid.senderAddressValidation(registerPost.getSendUserAddress(), model))
				|| Boolean.FALSE.equals(parcelValid.parcelWeightValidation(registerPost.getParcelWeight(), model))
				|| Boolean.FALSE.equals(parcelValid.receiverNameValidation(registerPost.getReceiveUserName(), model))
				|| Boolean.FALSE
						.equals(parcelValid.receiverMobileNoValidation(registerPost.getReceiveUserMobileNo(), model))
				|| Boolean.FALSE
						.equals(parcelValid.senderAddressValidation(registerPost.getReceiveUserAddress(), model))) {
			for (int j = 1; j <= 17; j++) {
				if (model.getAttribute(ERRORMESSAGE + j) != null) {
					String errorMessage = (String) model.getAttribute(ERRORMESSAGE + j);
					model.addAttribute(POPUP, errorMessage);
				}
			}
			return ERRORPOPUP;
		}
		postService.registeredPostDetails(registerPost, session);
		return "RegisteredPostPayment.html";
	}

	@PostMapping("/view")
	public String statusView(@ModelAttribute("registeredView") RegisteredPostModel registeredPostModel, Model model,
			HttpSession session) throws JsonProcessingException {
		logger.info("Getting Status");
		postService.registeredPostStatusView(registeredPostModel, model, session);
		return DASHBOARD;
	}

	@PostMapping("/speedView")
	public String speedStatusView(@ModelAttribute("registeredView") SpeedPostModel speedPostModel, Model model,
			HttpSession session) throws JsonProcessingException {
		logger.info("Getting Status");
		postService.speedPostStatusView(speedPostModel, model, session);
		return DASHBOARD;
	}

	@GetMapping("/speedPostModel")
	public String speedPostModel(@ModelAttribute("speedPost") SpeedPostModel speedPostModel, HttpSession session) {
		return "SpeedPost.html";
	}

	@GetMapping("/speedPost")
	public String speedPost(@ModelAttribute("speedPost") SpeedPostModel speedPost, HttpSession session, Model model) {
		logger.info("Saving Speed Post Records");
		ParcelValidation parcelValid = new ParcelValidation();
		for (int i = 1; i <= 17; i++) {
			session.removeAttribute(POPUPMESSAGE + i);
		}
		if (Boolean.FALSE.equals(parcelValid.senderAddressValidation(speedPost.getSenderAddress(), model))
				|| Boolean.FALSE.equals(parcelValid.parcelWeightValidation(speedPost.getKms(), model))
				|| Boolean.FALSE.equals(parcelValid.receiverNameValidation(speedPost.getReceiverName(), model))
				|| Boolean.FALSE.equals(parcelValid.receiverMobileNoValidation(speedPost.getReceiverMobileNo(), model))
				|| Boolean.FALSE.equals(parcelValid.senderAddressValidation(speedPost.getReceiverAddress(), model))) {
			for (int j = 1; j <= 17; j++) {
				if (model.getAttribute(ERRORMESSAGE + j) != null) {
					String errorMessage = (String) model.getAttribute(ERRORMESSAGE + j);
					model.addAttribute(POPUP, errorMessage);
				}
			}
			return ERRORPOPUP;
		}
		postService.speedPostDetails(speedPost, session);
		return "SpeedPostPayment.html";
	}

	@GetMapping("/recurringPayment")
	public String recurringPayment(@ModelAttribute("recurringPayment") RecurringPayment recurringPayment,
			HttpSession session) {
		return "RecurringPayment.html";
	}

	@GetMapping("/recurringPaymentMethod")
	public String recurringPaymentMethod(@ModelAttribute("recurringPayment") RecurringPayment recurringPayment,
			HttpSession session) {
		RecurringPayment recrringDepositpayment = new RecurringPayment();
		recrringDepositpayment.setDepositUserName(recurringPayment.getDepositUserName());
		recrringDepositpayment.setRecurPrincipleAmount(recurringPayment.getRecurPrincipleAmount());
		postService.recurringPaymentDetails(recrringDepositpayment, session);
		return "PaymentSuccessful.html";
	}

	@GetMapping("/timePaymentModel")
	public String timePaymentModel(@ModelAttribute("timePayment") TimeDepositPayment timeDepositPayment) {
		return "TimeDepositpayment.html";
	}

	@GetMapping("/timePayment")
	public String timePayment(@ModelAttribute("timePayment") TimeDepositPayment timePayment) {
		postService.timePaymentDetails(timePayment);
		return "TimePaymentSuccess.html";
	}

	@GetMapping("/seniorPaymentModel")
	public String seniorPaymentModel(@ModelAttribute("seniorPayment") SeniorCitizenPayment seniorCitizenPayment) {
		return "SeniorPayment.html";
	}

	@GetMapping("/seniorPayment")
	public String seniorPayment(@ModelAttribute("seniorPayment") SeniorCitizenPayment seniorPayment,
			HttpSession session) {

		SeniorCitizenPayment senior = new SeniorCitizenPayment();

		senior.setCustomerName(seniorPayment.getCustomerName());
		senior.setDepositAmount1(seniorPayment.getDepositAmount1());
		senior.setPaidDate(seniorPayment.getPaidDate());
		postService.seniorPaymentDetails(seniorPayment);
		return "SeniorPaymentSuccess.html";
	}

	@RequestMapping("/registeredPaymentModel")
	public String registeredPaymentModel(
			@ModelAttribute("registeredPayment") RegisteredPostPaymentModel registeredPostPaymentModel) {
		return "RegisteredpostPayment.html";
	}

	@GetMapping("/registeredPayment")
	public String registeredPayment(
			@ModelAttribute("registeredPayment") RegisteredPostPaymentModel registeredPostPaymentModel,
			HttpSession session) {
		RegisteredPostPaymentModel rs = new RegisteredPostPaymentModel();
		rs.setRegisteredPostUserName(registeredPostPaymentModel.getRegisteredPostUserName());
		rs.setRegisteredPostParcelCharge(registeredPostPaymentModel.getRegisteredPostParcelCharge());
		postService.registeredPostPaymentDetails(rs, session);
		return "paymentSuccessfull1.html";
	}

	@GetMapping("/speedPaymentModel")
	public String speedPaymentModel(@ModelAttribute("speedpayment") SpeedPostPaymentModel speedPostPaymentModel) {
		return "SpeedPostpayment.html";
	}

	@GetMapping("/speedPayment")
	public String speedPayment(@ModelAttribute("speedpayment") SpeedPostPaymentModel speedPostPaymentModel) {
		postService.speedPostPaymentdetails(speedPostPaymentModel);
		return "SpeedPaymentSuccess";
	}

	@GetMapping("/forgetModel")
	public String forgetPasswordModel(@ModelAttribute("forget") User register) {
		return "ForgetPassword.html";
	}

	@GetMapping("/forget")
	public String forgetPassword(@ModelAttribute("forget") User register) {
		postService.forgetPassword(register);
		return USERLOGIN;
	}

	@GetMapping("/passBook")
	public String getUserPassbook(@ModelAttribute("recurring") RecurringDepositModel recurringDepositModel,
			HttpSession session, Model model) throws JsonProcessingException {
		String userName = recurringDepositModel.getDeposituserName();
		recurringDepositModel.setDeposituserName(userName);
		postService.recurringPassBook(session, model);
		postService.timePassBook(session, model);
		postService.seniorPassBook(session, model);
		return "Passbook.html";
	}

	@GetMapping("/parcelPassBook")
	public String getUserParcelPassbook(@ModelAttribute("parcel") RegisteredPostModel registeredPostModel,
			HttpSession session, Model model) throws JsonProcessingException {
		String userName = registeredPostModel.getSendUserName();
		registeredPostModel.setSendUserName(userName);
		postService.registeredPostPassBook(session, model);
		postService.speedPostPassBook(session, model);
		return "RegisteredPassbook.html";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/registerProfileModel")
	public String registerProfileMethod(@ModelAttribute("regProfile") User register, HttpSession session) {
		postService.profileGetMethod(session);
		return "RegisterProfile.html";
	}

	@GetMapping("/registerProfile")
	public String registerProfile(@ModelAttribute("regProfile") User register, HttpSession session) {
		postService.profileUpdateMethod(register, session);
		return "UserDashboard.html";
	}

	@GetMapping("/recurringSlip")
	public String recurringDepositPaymentSlip(@ModelAttribute("recurSlip") RecurringDepositModel recurringDepositModel,
			HttpSession session) {
		postService.recurringSlip(session);
		return "RecurringSlip.html";
	}

	@GetMapping("/timeSlip")
	public String timeDepositPaymentSlip(@ModelAttribute("timeSlip") TimeDepositModel timeDepositModel,
			HttpSession session) {
		return "TimePaymentSlip.html";
	}

	@GetMapping("/seniorSlip")
	public String seniorCitizenDepositPaymentSlip(@ModelAttribute("seniorSlip") SeniorCitizenModel seniorCitizenModel,
			HttpSession session) {
		return "SeniorPaymentSlip.html";
	}

	@GetMapping("/registerSlip")
	public String registeredPostPaymentSlip(@ModelAttribute("registerSlip") RegisteredPostModel registeredPostModel,
			HttpSession session) {
		return "registerPaymentSlip.html";
	}

	@GetMapping("/speedSlip")
	public String speedPostPaymentSlip(@ModelAttribute("speedSlip") SpeedPostModel speedPostModel,
			HttpSession session) {
		return "SpeedPaymentSlip.html";
	}
}