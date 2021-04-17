package com.bbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bbs.pojo.User;


public interface UserService {
	
	//登陆
    public User login(String userName, String password);
    //注册
    public void regist(User user);
    //获取用户列表
    public List<User> getUserPage(Integer page, Integer limit);
    //登陆比较图形验证码
	public int checkImgCode(String code, HttpSession session);

}
