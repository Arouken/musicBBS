package com.bbs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.UserDao;
import com.bbs.pojo.User;
import com.bbs.service.UserService;


@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(String userName, String password) {		
		return userDao.findUserInfoByCond(userName, password);
	}

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

}
