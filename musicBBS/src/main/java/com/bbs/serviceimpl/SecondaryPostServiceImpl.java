package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.SecondaryPostDao;
import com.bbs.pojo.SecondaryPost;
import com.bbs.service.SecondaryPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service("SecondaryPostService")
public class SecondaryPostServiceImpl implements SecondaryPostService {
	
	@Autowired
	private SecondaryPostDao secondaryPostDao;


	//根据主贴ID获取所有回帖信息
	//查询单个帖子的回帖
	@Override
	public PageInfo<SecondaryPost> getSecondaryPostList(Integer page, Integer size,int mainPostID) {
		// TODO Auto-generated method stub
		//1）静态分页
	    PageHelper.startPage(page,size);
	    //2）集合查询
	    List<SecondaryPost> secondaryPostList = secondaryPostDao.getSecondaryPostList(mainPostID);
	    //3）返回PageInfo:包含数据结果集+分页信息
	    return new PageInfo<SecondaryPost>(secondaryPostList);
		
	}


	//回复帖子
	@Override
	public void addSecondaryPost(SecondaryPost secondaryPost) {
		// TODO Auto-generated method stub
		secondaryPostDao.addSecondaryPost(secondaryPost);
	}
	
	

}
