package com.softtek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softtek.entity.UserInfo;
import com.softtek.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;

	@GetMapping("/register")
	public String showuserRegistrationPage(@ModelAttribute("userInfo") UserInfo details) {
		return "user_registration";
	}

	@PostMapping("/register")
	public String userRegistration(@ModelAttribute("userInfo") UserInfo details, Map<String, Object> map) {
		String message = service.register(details);
		map.put("message", message);

		return "success";
	}

	@GetMapping("/showLogin")
	public String showLoginpage() {
		return "custom_login";
	}
}
