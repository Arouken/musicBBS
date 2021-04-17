package com.bbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bbs.pojo.User;


public interface UserService {
	
	//��½
    public User login(String userName, String password);
    //ע��
    public void regist(User user);
    //��ȡ�û��б�
    public List<User> getUserPage(Integer page, Integer limit);
    //��½�Ƚ�ͼ����֤��
	public int checkImgCode(String code, HttpSession session);

}
