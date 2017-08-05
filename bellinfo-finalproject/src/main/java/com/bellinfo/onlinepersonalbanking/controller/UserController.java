package com.bellinfo.onlinepersonalbanking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.validation.Valid;

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

import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;
import com.bellinfo.onlinepersonalbanking.serivce.UserService;

@Controller
@RequestMapping("/saveUser")
public class UserController {
	@Autowired
	private UserService userService;
	private String user;
	private String pass;

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

	@RequestMapping("/paymentsTransfersPage")
	public String paymentsTransfersPage(Model model) {
		// retrieve list of customers from db
		List<UserRegistrationModelClass> userList = userService.getAllCustomers();
		// set the userList as a model attribute to populate the list in our jsp page
		model.addAttribute("userList", userList);
		// send over to display the list
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
			List<UserRegistrationModelClass> userUpdatedList = userService.recipientCustomer(value, radioStatus, loggedUser);
			model.addAttribute("userUpdatedList", userUpdatedList);
			return "transferFundsPage3";
		} else {
			model.addAttribute("message",
					"Sorry You Don't have enough funds to transfer. Please view your balance in account summary an try within the limit! THNAK YOU!");
			return "transferFundsPage2";
		}
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
	public String thanksForVisit() {
		return "thanksForVisit";
	}

	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}

	@RequestMapping("/transactions")
	public String transactionsPage() {
		return "transactions";
	}

	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}
}
