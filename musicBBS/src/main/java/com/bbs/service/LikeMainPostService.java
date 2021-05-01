package com.bbs.service;

import com.bbs.pojo.LikeMainPost;

public interface LikeMainPostService {
	
	public void likePost(LikeMainPost likeMainPost);
	
	public void dislike(LikeMainPost likeMainPost);
	
	public LikeMainPost selectLike(LikeMainPost likeMainPost);

}
