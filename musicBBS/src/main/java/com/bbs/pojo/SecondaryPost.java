package com.bbs.pojo;

import java.util.Date;

public class SecondaryPost {
	
	private int secondaryPostID;
	private int mainPostID;
	private String userID;
	private String secondaryPostContent;
	private Date secondaryPostTime;
	private int secondaryPostGoodCount;
	private int secondaryPostIsLocked;
	private String replyUserID;//ªÿ∏¥∂‘œÛID
	private User user;
	
	
	public int getSecondaryPostID() {
		return secondaryPostID;
	}
	public void setSecondaryPostID(int secondaryPostID) {
		this.secondaryPostID = secondaryPostID;
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
	
	public String getSecondaryPostContent() {
		return secondaryPostContent;
	}
	public void setSecondaryPostContent(String secondaryPostContent) {
		this.secondaryPostContent = secondaryPostContent;
	}
	public Date getSecondaryPostTime() {
		return secondaryPostTime;
	}
	public void setSecondaryPostTime(Date secondaryPostTime) {
		this.secondaryPostTime = secondaryPostTime;
	}
	
	public int getSecondaryPostGoodCount() {
		return secondaryPostGoodCount;
	}
	public void setSecondaryPostGoodCount(int secondaryPostGoodCount) {
		this.secondaryPostGoodCount = secondaryPostGoodCount;
	}
	
	public int getSecondaryPostIsLocked() {
		return secondaryPostIsLocked;
	}
	public void setSecondaryPostIsLocked(int secondaryPostIsLocked) {
		this.secondaryPostIsLocked = secondaryPostIsLocked;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getReplyUserID() {
		return replyUserID;
	}
	public void setReplyUserID(String replyUserID) {
		this.replyUserID = replyUserID;
	}
	

}
