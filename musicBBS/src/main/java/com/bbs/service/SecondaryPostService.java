package com.bbs.service;


import com.bbs.pojo.SecondaryPost;
import com.github.pagehelper.PageInfo;

public interface SecondaryPostService {
	
	//��������ID��ȡ���л�����Ϣ
	public PageInfo<SecondaryPost> getSecondaryPostList(Integer page, Integer size,int mainPostID);
	//����
	public void addSecondaryPost(SecondaryPost secondaryPost);

}
