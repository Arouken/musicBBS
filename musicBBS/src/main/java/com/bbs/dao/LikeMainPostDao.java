package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.LikeMainPost;

public interface LikeMainPostDao {
	//����
	public void likePost(LikeMainPost likeMainPost);
	//����
	public void dislike(LikeMainPost likeMainPost);
	//��ѯ�Ƿ���
	public LikeMainPost selectLike(LikeMainPost likeMainPost);

}
