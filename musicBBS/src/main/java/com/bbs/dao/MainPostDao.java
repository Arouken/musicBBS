package com.bbs.dao;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;

public interface MainPostDao {

	//��̨��ѯ�����б�
	public List<MainPost> getMainPostList();
	//��������
	public void addMainPost(MainPost mainpost);	
	//��ѯ����������Ϣ
	public MainPost getOneMainPost(int mainPostID);
	
	
}
