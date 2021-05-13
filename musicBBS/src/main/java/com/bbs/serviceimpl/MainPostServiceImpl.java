package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.MainPostDao;
import com.bbs.pojo.MainPost;
import com.bbs.service.MainPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("MainPostService")
public class MainPostServiceImpl implements MainPostService {
	
	//后台展示帖子
	//根据类型进行，不需要set方法，这个autowrite注解已经封装了
	@Autowired
	private MainPostDao mainPostDao;

	@Override
	public List<MainPost> getMainPostPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//page为申请查询的页码，limit为一页显示多少条数据
		List<MainPost> mainPostList = mainPostDao.getMainPostList();//PageHelper.startPage()后面必须紧接查询数据的方法
		return mainPostList;		
	}

    //前台展示帖子
	@Override
	public PageInfo<MainPost> pageHelperList(Integer page, Integer size) {
		//1）静态分页
	    PageHelper.startPage(page,size);
	    //2）集合查询
	    List<MainPost> mainPostList = mainPostDao.getMainPostList();
	    //3）返回PageInfo:包含数据结果集+分页信息
	    return new PageInfo<MainPost>(mainPostList);
	}
	

	//发布主贴
	@Override
	public void addMainPost(MainPost mainpost) {
		mainPostDao.addMainPost(mainpost);
	}

	//查询单个帖子信息
	@Override
	public MainPost getOneMainPost(int mainPostID) {
		MainPost mainpost = mainPostDao.getOneMainPost(mainPostID);
		return mainpost;
	}

	//点赞加一
	@Override
	public void addLikeCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addLikeCount(mainPostID);
	}

	//赞数减一
	@Override
	public void deleteLikeCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteLikeCount(mainPostID);
	}
	
	//收藏加一
	@Override
	public void addCollectCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addCollectCount(mainPostID);
	}

	//收藏减一
	@Override
	public void deleteCollectCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteCollectCount(mainPostID);
	}

	//查询专区帖子
	@Override
	public PageInfo<MainPost> getCategoryPostList(Integer page, Integer size, String categoryName) {
		// TODO Auto-generated method stub
		//1）静态分页
	    PageHelper.startPage(page,size);
	    //2）集合查询
	    List<MainPost> mainPostList = mainPostDao.getCategoryPostList(categoryName);
	    //3）返回PageInfo:包含数据结果集+分页信息
	    return new PageInfo<MainPost>(mainPostList);
		
	}

	//举报量+1
	@Override
	public void addReportCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addReportCount(mainPostID);
	}
	//举报量-1
	@Override
	public void deleteReportCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteReportCount(mainPostID);
	}
	//回复量
	@Override
	public void addReplyCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addReplyCount(mainPostID);
	}
	//回复量
	@Override
	public void deleteReplyCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteReplyCount(mainPostID);
	} 
	
	
	

}
