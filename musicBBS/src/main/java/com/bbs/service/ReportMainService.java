package com.bbs.service;

import com.bbs.pojo.ReportMain;

public interface ReportMainService {
	
	//��Ӿٱ�
	public void addReportMain(ReportMain reportMain);
	//����������
	public void lockMainPost(int mainPostID, int mainPostIsLocked);


}
