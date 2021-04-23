package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bbs.pojo.User;


public interface UserDao {
	
	//登陆
	public User findUserInfoByCond(@Param("userID") String userID, @Param("password") String password);
	//添加用户
	public void addUser(User user);
	//public User getUserList(User user);
	//查询用户列表
	public List<User> getUserList();
	//插入图片
    public void uploadUserPhoto(@Param("userID")String userID,@Param("photo")String photo);

}
