package com.bbs.service;

import com.bbs.pojo.User;


public interface UserService {
	
    public User login(String userName, String password);
    public void regist(User user);

}
