package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.pojo.testUser;
import com.ssm.service.testUserService;


@Controller
@RequestMapping("/testUser")
public class testUserController {
	
	@Autowired
	private testUserService testUserService;
	@RequestMapping("/login")
	public String login(testUser ui) {
		testUser tempUi = testUserService.login(ui.getUserName(), ui.getPassword());
		if (tempUi != null && tempUi.getUserName() != null) {
			return "index";
		} else {
			return "redirect:/login.jsp";
		}
	}
	
}
