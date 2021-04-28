package com.bbs.service;


import com.bbs.pojo.SecondaryPost;
import com.github.pagehelper.PageInfo;

public interface SecondaryPostService {
	
	//根据主贴ID获取所有回帖信息
	public PageInfo<SecondaryPost> getSecondaryPostList(Integer page, Integer size,int mainPostID);
	//回帖
	public void addSecondaryPost(SecondaryPost secondaryPost);

}
