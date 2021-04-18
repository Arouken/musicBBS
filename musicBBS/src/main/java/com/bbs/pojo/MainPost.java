package com.bbs.pojo;

import java.util.Date;

public class MainPost {
	private int mainPostID;
	private int userID;
	private String mainPostTitle;
	private Date mainPostTime;
	private String mainPostContent;
	private int mainPostGoodCount;
	private int mainPostBadCount;
	private int mainPostIsLOcked;
	private String mainPostImg;
	
	public String getMainPostImg() {
		return mainPostImg;
	}
	public void setMainPostImg(String mainPostImg) {
		this.mainPostImg = mainPostImg;
	}
	public int getMainPostID() {
		return mainPostID;
	}
	public void setMainPostID(int mainPostID) {
		this.mainPostID = mainPostID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getMainPostTitle() {
		return mainPostTitle;
	}
	public void setMainPostTitle(String mainPostTitle) {
		this.mainPostTitle = mainPostTitle;
	}
	public Date getMainPostTime() {
		return mainPostTime;
	}
	public void setMainPostTime(Date mainPostTime) {
		this.mainPostTime = mainPostTime;
	}
	public String getMainPostContent() {
		return mainPostContent;
	}
	public void setMainPostContent(String mainPostContent) {
		this.mainPostContent = mainPostContent;
	}
	public int getMainPostGoodCount() {
		return mainPostGoodCount;
	}
	public void setMainPostGoodCount(int mainPostGoodCount) {
		this.mainPostGoodCount = mainPostGoodCount;
	}
	public int getMainPostBadCount() {
		return mainPostBadCount;
	}
	public void setMainPostBadCount(int mainPostBadCount) {
		this.mainPostBadCount = mainPostBadCount;
	}
	public int getMainPostIsLOcked() {
		return mainPostIsLOcked;
	}
	public void setMainPostIsLOcked(int mainPostIsLOcked) {
		this.mainPostIsLOcked = mainPostIsLOcked;
	}

}
