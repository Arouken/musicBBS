package com.bbs.dao;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.Category;
import com.bbs.pojo.MainPost;

public interface MainPostDao {

	//后台查询主贴列表
	public List<MainPost> getMainPostList();
	//后台查询举报帖子列表，按举报量排序
	public List<MainPost> getReportMainList();		
	//发布主贴
	public void addMainPost(MainPost mainpost);	
	//查询单个主贴信息
	public MainPost getOneMainPost(int mainPostID);
	//点赞数加一
	public void addLikeCount(int mainPostID);
	//点赞减一
	public void deleteLikeCount(int mainPostID);
	//收藏加一
	public void addCollectCount(int mainPostID);
	//收藏减一
	public void deleteCollectCount(int mainPostID);
	
	//举报加一
	public void addReportCount(int mainPostID);
	//举报减一
	public void deleteReportCount(int mainPostID);
		
	//回复加一
	public void addReplyCount(int mainPostID);
	//回复减一
	public void deleteReplyCount(int mainPostID);
	
	//查询专区帖子
	public List<MainPost> getCategoryPostList(String categoryName);
	
}
