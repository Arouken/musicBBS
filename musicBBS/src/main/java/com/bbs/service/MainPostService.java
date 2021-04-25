package com.bbs.service;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;
import com.github.pagehelper.PageInfo;

public interface MainPostService {
	
	//后台查询主贴列表
	public List<MainPost> getMainPostPage(Integer page, Integer limit);	
		
	//登陆时初始化10条帖子
	PageInfo<MainPost> userPostInit(Integer page, Integer size);
	
	//用户主页展示帖子
	PageInfo<MainPost> pageHelperList(Integer page, Integer size);
    //发布主贴
	public void addMainPost(MainPost mainpost);
	

}
