package com.bbs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.ReportMainDao;
import com.bbs.service.ReportMainService;

@Service("ReportMainService")
public class ReportMainServiceImpl implements ReportMainService {
	
	@Autowired
	private ReportMainDao reportMainDao;
	
	

}
