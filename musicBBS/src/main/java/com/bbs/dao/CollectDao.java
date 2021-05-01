package com.bbs.dao;

import com.bbs.pojo.Collect;

public interface CollectDao {
	
	//收藏
	public void collectPost(Collect collect);
	//取消收藏
	public void disCollectPost(Collect collect);
	//查询是否收藏
	public Collect selectCollectPost(Collect collect);

}
