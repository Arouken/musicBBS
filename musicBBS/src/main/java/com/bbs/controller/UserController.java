package com.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.pojo.User;
import com.bbs.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(User ui) {
		User tempUi = userService.login(ui.getUserName(), ui.getPassword());
		if (tempUi != null && tempUi.getUserName() != null) {
			return "index";
		} else {
			return "redirect:/login.jsp";
		}
	}
	
	@RequestMapping("/regist")
	public String regist(User user,Model model){
		
		System.out.println("用户注册："+user.getUserName()+user.getPassword());				
		userService.regist(user);		
		model.addAttribute("msg", "注册成功");
		//注册成功后跳转success.jsp页面
		return "redirect:/login.jsp";
	}
}
