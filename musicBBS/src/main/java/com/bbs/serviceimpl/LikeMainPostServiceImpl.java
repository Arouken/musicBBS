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
	//����
	@Override
	public void likePost(LikeMainPost likeMainPost) {
		// TODO Auto-generated method stub
		likeMainPostDao.likePost(likeMainPost);

	}

	//ȡ������
	@Override
	public void dislike(String userID, int mainPostID) {
		// TODO Auto-generated method stub

	}

	//��ѯ����
	@Override
	public LikeMainPost selectLike(String userID, int mainPostID) {
		// TODO Auto-generated method stub
		return null;
	}

}
