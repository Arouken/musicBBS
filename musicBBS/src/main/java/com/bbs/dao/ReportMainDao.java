package com.bbs.dao;

import org.apache.ibatis.annotations.Param;

import com.bbs.pojo.ReportMain;

public interface ReportMainDao {
	//添加举报
	public void addReportMain(ReportMain reportMain);

	//封禁解封帖子
	public void lockMainPost(@Param("mainPostID")int mainPostID,@Param("mainPostIsLocked")int mainPostIsLocked);
	

}
