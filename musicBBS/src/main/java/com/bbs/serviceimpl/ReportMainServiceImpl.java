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

	//Ìí¼Ó¾Ù±¨
	@Override
	public void addReportMain(ReportMain reportMain) {
		// TODO Auto-generated method stub
		reportMainDao.addReportMain(reportMain);
	}
	
	

}
