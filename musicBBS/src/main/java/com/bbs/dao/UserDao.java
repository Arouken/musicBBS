package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bbs.pojo.User;


public interface UserDao {
	
	
	public User findUserInfoByCond(@Param("userName") String userName, @Param("password") String password);
	public void addUser(User user);
	//public User getUserList(User user);
	public List<User> getUserList();

}
