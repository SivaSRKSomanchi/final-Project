package com.bellinfo.onlinepersonalbanking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.validation.Valid;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bellinfo.onlinepersonalbanking.model.TransactionsModelClass;
import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;
import com.bellinfo.onlinepersonalbanking.serivce.UserService;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Call;
import com.twilio.sdk.resource.instance.Message;

@Controller
@RequestMapping("/saveUser")
public class UserController {
	@Autowired
	private UserService userService;
	private String user;
	private String pass;
	
	 // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC73a23433564946d8215f8bd7d44d234a";
    public static final String AUTH_TOKEN = "e3b176a6c89a38fce153c2d7abab4187";
    public static final String TWILIO_NUMBER = "+16179256126";
    
    public void sendSMS(String phoneNumber, String messag) {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
     System.out.println("sivaram inside sendSMS");
            // Build a filter for the MessageList
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Body", messag));
            params.add(new BasicNameValuePair("To", phoneNumber)); //Add real number here
            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
     
            MessageFactory messageFactory = client.getAccount().getMessageFactory();
            Message message = messageFactory.create(params);
            System.out.println(message.getSid());
        } 
        catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }
    }
    
    public void makeCall(String phoneNumber) {
        try {
            TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("Url", "https://brodan.biz/call.xml"));
            params.add(new BasicNameValuePair("To", phoneNumber)); //Add real number here
            params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
                 
            CallFactory callFactory = client.getAccount().getCallFactory();
            Call call = callFactory.create(params);
        } 
        catch (TwilioRestException e) {
            System.out.println(e.getErrorMessage());
        }
    }
	


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String userRegistration(Model model) {
		UserRegistrationModelClass userRegis = new UserRegistrationModelClass();
		model.addAttribute("userRegis", userRegis);
		return "userRegistrationPage";
	}

	@RequestMapping(value = "/savedata", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("userRegis") UserRegistrationModelClass userRegis,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "userRegistrationPage";
		} else {
			userService.saveUserDetails(userRegis);
			return "redirect:/saveUser/login";
		}
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginsuccess", method = RequestMethod.POST)
	public String getUsernamePassword(HttpServletRequest request, Model model) {
		System.out.println("In Controller class...Check Login");
		String uuser = request.getParameter("username");
		String ppass = request.getParameter("password");
		boolean userExistsOrNot = userService.checkLogin(uuser, ppass);
		if (userExistsOrNot == true) {
			request.getSession().setAttribute("username", uuser);
			request.getSession().setAttribute("password", ppass);
			return "afterloginHomePage";
		} else {
			return "login";
		}

	}

	@GetMapping("/showFormUpdate")
	public String showFormForData(@RequestParam("customerId") int id, Model model) {
		// get the customer from service layer
		UserRegistrationModelClass userRegistrationModelClass = userService.getCustomer(id);
		// set the userRegistrationModelClass as a model attribute to pre-populate the
		// form..
		model.addAttribute("userRegis", userRegistrationModelClass);
		// send over to our update form
		return "saveUpdates";
	}
	@RequestMapping("/otp")
	public String otpOrCall() {
		return "otpOrCall";
	}

	@RequestMapping("/otp1")
	public String otp(Model model, HttpServletRequest req) {
		String thru = req.getParameter("mode");
		if(thru.equalsIgnoreCase("text")) 
		{
	    String otpNumHaveToSend = userService.otp(4);
		String message = "Your OTP number is: "+otpNumHaveToSend+" - Please Enter this number in your window.";
		req.getSession().setAttribute("OTPNum", otpNumHaveToSend);
		UserRegistrationModelClass loggedUser = currentUser(req);
		String phoneN = loggedUser.getPhoneNumber();
		sendSMS(phoneN, message);
		System.out.println("inside controller ssivaram = "+thru);
		model.addAttribute("loggedUserPhoneNumber",phoneN);
		model.addAttribute("thru",thru);
		return "otp";
		} else 
		{
			UserRegistrationModelClass loggedUser = currentUser(req);
			String phoneN = loggedUser.getPhoneNumber();
			makeCall(phoneN);
			model.addAttribute("loggedUserPhoneNumber",phoneN);
			model.addAttribute("thru",thru);
			return "call";
		}
	}

	@RequestMapping("/otp2")
	public String otp2(HttpServletRequest req, Model model) {
		String otp = req.getParameter("otp");
		String num = (String)req.getSession().getAttribute("OTPNum");
		boolean result = userService.verify(otp,num);
		if (result == true) {
			// retrieve list of customers from db
			List<UserRegistrationModelClass> userList = userService.getAllCustomers();
			// set the userList as a model attribute to populate the list in our jsp page
			model.addAttribute("userList", userList);
			// send over to display the list
			return "transferFundsPage";
		} else {
			return "otp2";
		}
	}
	@RequestMapping("/otp3")
	public String fromCallJspPageToTransfers() {
		return "transferFundsPage";
	}

	@RequestMapping("/paymentForm")
	public String paymentForm(HttpServletRequest req, @ModelAttribute("userList") UserRegistrationModelClass userList,
			Model model) {
		UserRegistrationModelClass loggedUser = currentUser(req);
		int value = (Integer.parseInt(req.getParameter("amount")));
		int radioStatus = Integer.parseInt(req.getParameter("radioButton"));
		System.out.println("Insise PAYMENT FORM METHOD: " + "AMOUNT=" + value + " RADIO STATUS=" + radioStatus);
		if (loggedUser.getSalary() > value) {
			List<UserRegistrationModelClass> userUpdatedList = userService.recipientCustomer(value, radioStatus,
					loggedUser);
			model.addAttribute("userUpdatedList", userUpdatedList);
			return "transferFundsPage3";
		} else {
			model.addAttribute("message",
					"Sorry You Don't have enough funds to transfer. Please view your balance in account summary an try within the limit! THNAK YOU!");
			return "transferFundsPage2";
		}
	}

	@RequestMapping("/transactions")
	public String transactionsPage(HttpServletRequest req, Model model) {
		user = (String) req.getSession().getAttribute("username");
		List<TransactionsModelClass> transUserList = userService.getUsersInvolved(user);
		model.addAttribute("transUserList", transUserList);
		return "transactions";
	}

	@RequestMapping("/accountSummary")
	public String accountSummaryPage(HttpServletRequest req, Model model) {
		UserRegistrationModelClass userList = currentUser(req);
		System.out.println("userlist: " + userList.getAccountNumber());
		model.addAttribute("userList", userList);
		return "accountSummary";
	}

	// Current User or Logged User Details
	public UserRegistrationModelClass currentUser(HttpServletRequest req) {
		user = (String) req.getSession().getAttribute("username");
		pass = (String) req.getSession().getAttribute("password");
		UserRegistrationModelClass userList = userService.getUserDetails(user, pass);
		return userList;
	}

	@RequestMapping("/update")
	public String updatePage(Model model) {
		UserRegistrationModelClass userList = userService.getUserDetails(user, pass);
		model.addAttribute("userList", userList);
		return "updatePage";
	}

	@RequestMapping("/thanksForVisit")
	public String thanksForVisit(HttpServletRequest request) {
		request.getSession().setAttribute("null", user);
		request.getSession().setAttribute("null", pass);
		return "thanksForVisit";
	}

	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}

	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}

}
