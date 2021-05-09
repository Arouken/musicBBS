package com.bbs.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.UserDao;
import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.bbs.utils.SendSms;
import com.github.pagehelper.PageHelper;


@Service("UserService")
public class UserServiceImpl implements UserService {

	//不需要set方法，这个autowrite注解已经封装了
	//根据类型进行
	@Autowired
	private UserDao userDao;

	//登陆
	@Override
	public User login(String userID, String password) {		
		return userDao.findUserInfoByCond(userID, password);
	}
	
	//用户注册时检测ID是否重复
	@Override
	public User idIsExist(String userID) {
			
		return userDao.findUser(userID);
	}

	//注册
	@Override
	public void regist(User user) {		
		userDao.addUser(user);
	}

	//用户分页
	@Override
	public List<User> getUserPage(Integer page, Integer limit) {
		//使用PageHelper.startPage静态方法调用
		//startPage后面的第一个对数据库操作的方法，将自动进行分页，sql语句无需添加limit关键字
		PageHelper.startPage(page, limit);//page为申请查询的页码，limit为一页显示多少条数据
		List<User> user = userDao.getUserList();//PageHelper.startPage()后面必须紧接查询数据的方法
		return user;		
	}

	
	//验证码比较
	@Override
	public int checkImgCode(String code, HttpSession session) {
		System.out.println("开始比较");
		// 获取系统生成的验证码
		String verifyCode=(String) session.getAttribute("verifyCode");
		System.out.println("生成的："+verifyCode);
		System.out.println("输入的："+code);
		//比较系统生成的验证码和表单输入的验证码是否一致(忽略大小区别)
		if (verifyCode.equalsIgnoreCase(code)) {
		//验证码正确
			System.out.println("验证码正确");
			return 1;
		}
		//验证码错误
		System.out.println("验证码错误");
		return 0;
	}
	
    //用户修改头像
	@Override
	public void uploadUserPhoto(String userID, String photo) {
		
		userDao.uploadUserPhoto(userID,photo);		
	}
    //用户修改密码
	@Override
	public void updateUserPassword(String userID, String password) {
		// TODO Auto-generated method stub	
		userDao.updateUserPassword(userID, password);
	}

	//检查旧密码
	@Override
	public User checkOldPassword(String userID, String password) {
		// TODO Auto-generated method stub
		return userDao.findUserInfoByCond(userID, password);		
	}

	//向用户发送验证码
	@Override
	public String sendPhoneCode(String phone) {
		// TODO Auto-generated method stub
		int code = SendSms.sendCode(phone);
		if(code>0) {
			String oldCode=phone+"#"+code;
			return oldCode;
		}else {
			return null;
		}
		
	}

	//检测手机号是否绑定
	@Override
	public User checkPhoneIsExit(String phone) {
		
		
		return userDao.findUserByPhone(phone);
		// TODO Auto-generated method stub
		
	}	

}
