package com.bbs.dao;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.Category;
import com.bbs.pojo.MainPost;

public interface MainPostDao {

	//��̨��ѯ�����б�
	public List<MainPost> getMainPostList();
	//��̨��ѯ�ٱ������б����ٱ�������
	public List<MainPost> getReportMainList();		
	//��������
	public void addMainPost(MainPost mainpost);	
	//��ѯ����������Ϣ
	public MainPost getOneMainPost(int mainPostID);
	//��������һ
	public void addLikeCount(int mainPostID);
	//���޼�һ
	public void deleteLikeCount(int mainPostID);
	//�ղؼ�һ
	public void addCollectCount(int mainPostID);
	//�ղؼ�һ
	public void deleteCollectCount(int mainPostID);
	
	//�ٱ���һ
	public void addReportCount(int mainPostID);
	//�ٱ���һ
	public void deleteReportCount(int mainPostID);
		
	//�ظ���һ
	public void addReplyCount(int mainPostID);
	//�ظ���һ
	public void deleteReplyCount(int mainPostID);
	
	//��ѯר������
	public List<MainPost> getCategoryPostList(String categoryName);
	
}
