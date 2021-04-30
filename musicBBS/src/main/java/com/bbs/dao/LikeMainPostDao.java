package com.bbs.dao;

import com.bbs.pojo.LikeMainPost;

public interface LikeMainPostDao {
	//点赞
	public void likePost(LikeMainPost likeMainPost);
	//不赞
	public void dislike(String userID,int mainPostID);
	//查询是否赞
	public LikeMainPost selectLike(String userID,int mainPostID);

}
