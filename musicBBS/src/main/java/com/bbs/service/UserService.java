package com.bbs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.bbs.pojo.User;


public interface UserService {
	
	//��½
    public User login(String userID, String password);
    //���ID�������ظ�
    public User idIsExist(String userID);
    //ע��
    public void regist(User user);
    //��ȡ�û��б�
    public List<User> getUserPage(Integer page, Integer limit);
    //��½�Ƚ�ͼ����֤��
	public int checkImgCode(String code, HttpSession session);
	//����ͼƬ
	public void uploadUserPhoto(String userID,String photo);
	//��������
	public void updateUserPassword(String userID,String password);	
	//��������
    public User checkOldPassword(String userID, String password);

}
