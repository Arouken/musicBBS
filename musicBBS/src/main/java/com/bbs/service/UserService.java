package com.bbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.bbs.pojo.User;


public interface UserService {
	
	//登陆
    public User login(String userID, String password);
    //检测ID，不能重复
    public User idIsExist(String userID);
    //注册
    public void regist(User user);
    //获取用户列表
    public List<User> getUserPage(Integer page, Integer limit);
    //登陆比较图形验证码
	public int checkImgCode(String code, HttpSession session);
	//插入图片
	public void uploadUserPhoto(String userID,String photo);
	//更新密码
	public void updateUserPassword(String userID,String password);	
	//检查旧密码
    public User checkOldPassword(String userID, String password);

}
