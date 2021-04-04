package com.bbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bbs.pojo.User;


public interface UserService {
	
    public User login(String userName, String password);
    public void regist(User user);
    public List<User> getUserPage(Integer page, Integer limit);
	public int checkImgCode(String code, HttpSession session);

}
