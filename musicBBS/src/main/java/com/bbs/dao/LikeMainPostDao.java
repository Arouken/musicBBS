package com.bbs.dao;

import com.bbs.pojo.LikeMainPost;

public interface LikeMainPostDao {
	//����
	public void likePost(LikeMainPost likeMainPost);
	//����
	public void dislike(String userID,int mainPostID);
	//��ѯ�Ƿ���
	public LikeMainPost selectLike(String userID,int mainPostID);

}
