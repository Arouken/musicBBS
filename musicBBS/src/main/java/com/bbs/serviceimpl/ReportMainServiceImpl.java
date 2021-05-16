package com.bbs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.ReportMainDao;
import com.bbs.pojo.ReportMain;
import com.bbs.service.ReportMainService;

@Service("ReportMainService")
public class ReportMainServiceImpl implements ReportMainService {
	
	@Autowired
	private ReportMainDao reportMainDao;

	//添加举报
	@Override
	public void addReportMain(ReportMain reportMain) {
		// TODO Auto-generated method stub
		reportMainDao.addReportMain(reportMain);
	}

	//封禁解封帖子
	@Override
	public void lockMainPost(int mainPostID, int mainPostIsLocked) {
		
		reportMainDao.lockMainPost(mainPostID,mainPostIsLocked);
	}
	
	

}
