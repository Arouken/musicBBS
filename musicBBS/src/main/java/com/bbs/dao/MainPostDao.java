package com.bbs.dao;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;

public interface MainPostDao {

	//后台查询主贴列表
	public List<MainPost> getMainPostList();
	//发布主贴
	public void addMainPost(MainPost mainpost);	
	//查询单个主贴信息
	public MainPost getOneMainPost(int mainPostID);
	//点赞数加一
	public void addLikeCount(int mainPostID);
	//点赞减一
	public void deleteLikeCount(int mainPostID);
	
}
