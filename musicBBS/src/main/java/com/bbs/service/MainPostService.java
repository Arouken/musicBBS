package com.bbs.service;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;
import com.github.pagehelper.PageInfo;

public interface MainPostService {
	
	//后台查询主贴列表
	public List<MainPost> getMainPostPage(Integer page, Integer limit);		
	//用户主页展示帖子
	PageInfo<MainPost> pageHelperList(Integer page, Integer size);
    //发布主贴
	public void addMainPost(MainPost mainpost);
	//查询单个帖子信息
	public MainPost getOneMainPost(int mainPostID);
	//点赞数加一
	public void addLikeCount(int mainPostID);
	//点赞减一
	public void deleteLikeCount(int mainPostID);
	//收藏加一
	public void addCollectCount(int mainPostID);
	//收藏减一
	public void deleteCollectCount(int mainPostID);

}
