package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bbs.pojo.User;


public interface UserDao {
	
	//��½
	public User findUserInfoByCond(@Param("userName") String userName, @Param("password") String password);
	//����û�
	public void addUser(User user);
	//public User getUserList(User user);
	//��ѯ�û��б�
	public List<User> getUserList();

}
