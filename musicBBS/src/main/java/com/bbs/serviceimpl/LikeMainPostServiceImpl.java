package com.bbs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.LikeMainPostDao;
import com.bbs.pojo.LikeMainPost;
import com.bbs.service.LikeMainPostService;

@Service("LikeMainPostService")
public class LikeMainPostServiceImpl implements LikeMainPostService {

	@Autowired
	private LikeMainPostDao likeMainPostDao;
	//点赞
	@Override
	public void likePost(LikeMainPost likeMainPost) {
		// TODO Auto-generated method stub
		likeMainPostDao.likePost(likeMainPost);

	}

	//取消点赞
	@Override
	public void dislike(String userID, int mainPostID) {
		// TODO Auto-generated method stub

	}

	//查询已赞
	@Override
	public LikeMainPost selectLike(String userID, int mainPostID) {
		// TODO Auto-generated method stub
		return null;
	}

}
