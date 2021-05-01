package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.LikeMainPost;

public interface LikeMainPostDao {
	//点赞
	public void likePost(LikeMainPost likeMainPost);
	//不赞
	public void dislike(LikeMainPost likeMainPost);
	//查询是否赞
	public LikeMainPost selectLike(LikeMainPost likeMainPost);

}
