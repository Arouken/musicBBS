package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.SecondaryPost;

public interface SecondaryPostDao {
	
	//��������ID��ȡ���л�����Ϣ
	public List<SecondaryPost> getSecondaryPostList(int mainPostID);
	//����
	public void addSecondaryPost(SecondaryPost secondaryPost);	
}
