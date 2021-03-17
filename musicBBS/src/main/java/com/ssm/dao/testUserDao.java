package com.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssm.pojo.testUser;

public interface testUserDao {
	
	@Select("select * from testuser where userName = #{userName} and password = #{password}")
	public testUser findUserInfoByCond(@Param("userName") String userName, @Param("password") String password);
	
	//hellooooooo
	

}
