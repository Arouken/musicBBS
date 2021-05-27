package com.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private UserService userService;

	//条件查询
	@RequestMapping("/findUserBySelect")
	@ResponseBody
	public Map<String, Object> findUserBySelect(
			@RequestParam("userKey") String userKey, 
			@RequestParam("userValue") String value,
			@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit) {
		System.out.println(userKey + " " + value + " " + page + " " + limit);
		if (userKey.equals("0")) {userKey = "userID";}
		if (userKey.equals("1")) {userKey = "userName";}
		if (userKey.equals("2")) {userKey = "phoneNum";}
		List<User> user = userService.findUserBySelect(userKey, value, page, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		PageInfo<User> userByselect = new PageInfo<User>(user);
		map.put("code", 0);
		map.put("msg", "操作成功");
		map.put("count", userByselect.getTotal());
		map.put("data", userByselect.getList());
		return map;
	}
	//删除用户
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(@RequestParam("userID") String userID) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "1");
		try {
			userService.deleteUser(userID);
			jsonObject.put("result", "1");
		} catch (Exception e) {
			jsonObject.put("result", "0");
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject.toString();	
	}
	
	//修改用户
	@RequestMapping("/updateUserById")
	@ResponseBody
	public String updateUserById(@RequestParam("oid") String oid, @RequestParam("userID") String userID,
			@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("phoneNum") String phoneNum, @RequestParam("gender") int gender,
			@RequestParam("competence") int competence) {
		System.out.println(oid + userID + userName + password + phoneNum + gender+competence);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "1");
		try {
			userService.updateUserById(oid,userID, userName, password, phoneNum, gender,competence);
		} catch (Exception e) {
			jsonObject.put("result", "0");
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject.toString();
	}
	
	
	@RequestMapping("/toUserList")
	public String toUserList() {
		return "/bbs_back/user_list";
	}
	//跳转到修改用户数据界面
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser() {
		return "/bbs_back/admin_updateUser";
	}

}
