package com.bbs.pojo;

import java.util.Date;

public class ReportMain {
	
	private int reportID;
	private int mainPostID;
	private String userID;
	private String reportReason;
	private int reportIsDeal;
	private Date reportMainTime;
	
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public int getMainPostID() {
		return mainPostID;
	}
	public void setMainPostID(int mainPostID) {
		this.mainPostID = mainPostID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReportReason() {
		return reportReason;
	}
	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
	public int getReportIsDeal() {
		return reportIsDeal;
	}
	public void setReportIsDeal(int reportIsDeal) {
		this.reportIsDeal = reportIsDeal;
	}
	public Date getReportMainTime() {
		return reportMainTime;
	}
	public void setReportMainTime(Date reportMainTime) {
		this.reportMainTime = reportMainTime;
	}
	
	
}
