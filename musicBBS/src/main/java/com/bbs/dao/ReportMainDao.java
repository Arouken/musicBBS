package com.bbs.dao;

import org.apache.ibatis.annotations.Param;

import com.bbs.pojo.ReportMain;

public interface ReportMainDao {
	//��Ӿٱ�
	public void addReportMain(ReportMain reportMain);

	//����������
	public void lockMainPost(@Param("mainPostID")int mainPostID,@Param("mainPostIsLocked")int mainPostIsLocked);
	

}
