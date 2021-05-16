package com.bbs.service;

import com.bbs.pojo.ReportMain;

public interface ReportMainService {
	
	//添加举报
	public void addReportMain(ReportMain reportMain);
	//封禁解封帖子
	public void lockMainPost(int mainPostID, int mainPostIsLocked);


}
