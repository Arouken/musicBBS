package com.bbs.dao;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;

public interface MainPostDao {

	//后台查询主贴列表
	public List<MainPost> getMainPostList();
	//用户主页展示帖子
	public List<MainPost> getMainPostListUser(Map<String,Integer> map);
	
}
