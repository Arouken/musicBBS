package com.bbs.service;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;
import com.github.pagehelper.PageInfo;

public interface MainPostService {
	
	//��̨��ѯ�����б�
	public List<MainPost> getMainPostPage(Integer page, Integer limit);		
	//�û���ҳչʾ����
	PageInfo<MainPost> pageHelperList(Integer page, Integer size);
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
	//��ѯר������
	public PageInfo<MainPost> getCategoryPostList(Integer page, Integer size,String categoryName);
	//��̨��ѯ�ٱ������б����ٱ�������
	public List<MainPost> getReportMainList(Integer page, Integer limit);		
	
	//�ٱ���һ
	public void addReportCount(int mainPostID);
	//�ٱ���һ
	public void deleteReportCount(int mainPostID);
		
	//�ظ���һ
	public void addReplyCount(int mainPostID);
	//�ظ���һ
	public void deleteReplyCount(int mainPostID);
}
