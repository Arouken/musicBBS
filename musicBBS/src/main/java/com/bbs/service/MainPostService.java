package com.bbs.service;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;
import com.github.pagehelper.PageInfo;

public interface MainPostService {
	
	//后台查询主贴列表
	public List<MainPost> getMainPostPage(Integer page, Integer limit);	
	//用户主页展示帖子1
	public List<MainPost> getMainPostListUser(Map<String,Integer> map);
	//用户主页展示帖子2
	public PageInfo<MainPost> pageHelperList(Integer page,Integer size);

}
