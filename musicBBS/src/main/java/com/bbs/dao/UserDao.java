package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bbs.pojo.User;


public interface UserDao {
	
	//��½
	public User findUserInfoByCond(@Param("userID") String userID, @Param("password") String password);
	//�ж��û��Ƿ����
	public User findUser(String userID);	
	//ע���û�
	public void addUser(User user);	
	//��ѯ�û��б�
	public List<User> getUserList();
	//����ͷ��ͼƬ
    public void uploadUserPhoto(@Param("userID")String userID,@Param("photo")String photo);
    //�޸��û��ǳ�
    public void updateUserName(@Param("userID")String userID,@Param("photo")String userName);
    //�޸��û�����
    public void updateUserPassword(@Param("userID")String userID,@Param("password")String password);
	//��ѯ�󶨵��ֻ����Ƿ����
    public User findUserByPhone(String phone);

}
