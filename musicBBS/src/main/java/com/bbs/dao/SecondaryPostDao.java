package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.SecondaryPost;

public interface SecondaryPostDao {
	
	//根据主贴ID获取所有回帖信息
	public List<SecondaryPost> getSecondaryPostList(int mainPostID);
	//回帖
	public void addSecondaryPost(SecondaryPost secondaryPost);	
}
