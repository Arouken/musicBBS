package com.ssm.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.testUserDao;
import com.ssm.pojo.testUser;
import com.ssm.service.testUserService;

@Service("userInfoService")
public class testUserServiceImpl implements testUserService{
	
	@Autowired
	private testUserDao testUserDao;

	@Override
	public testUser login(String userName, String password) {		
		return testUserDao.findUserInfoByCond(userName, password);
	}

}
