package com.bbs.dao;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;

public interface MainPostDao {

	//��̨��ѯ�����б�
	public List<MainPost> getMainPostList();
	//�û���ҳչʾ����
	public List<MainPost> getMainPostListUser(Map<String,Integer> map);
	
}
