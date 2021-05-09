package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bbs.pojo.User;


public interface UserDao {
	
	//登陆
	public User findUserInfoByCond(@Param("userID") String userID, @Param("password") String password);
	//判断用户是否存在
	public User findUser(String userID);	
	//注册用户
	public void addUser(User user);	
	//查询用户列表
	public List<User> getUserList();
	//插入头像图片
    public void uploadUserPhoto(@Param("userID")String userID,@Param("photo")String photo);
    //修改用户昵称
    public void updateUserName(@Param("userID")String userID,@Param("photo")String userName);
    //修改用户密码
    public void updateUserPassword(@Param("userID")String userID,@Param("password")String password);
	//查询绑定的手机号是否存在
    public User findUserByPhone(String phone);

}
