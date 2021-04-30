package com.bbs.service;

import com.bbs.pojo.LikeMainPost;

public interface LikeMainPostService {
	
	public void likePost(LikeMainPost likeMainPost);
	
	public void dislike(String userID,int mainPostID);
	
	public LikeMainPost selectLike(String userID,int mainPostID);

}
