package com.bellinfo.onlinepersonalbanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bellinfo.onlinepersonalbanking.model.UserRegistrationModelClass;

@Controller
public class LandingPageController {
	
	@RequestMapping("/")
	public String landingPage(Model model) {
		UserRegistrationModelClass user = new UserRegistrationModelClass();
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping("/index")
	public String landingPage1(Model model) {
		UserRegistrationModelClass user = new UserRegistrationModelClass();
		model.addAttribute("user", user);
		return "login";
	}
}
