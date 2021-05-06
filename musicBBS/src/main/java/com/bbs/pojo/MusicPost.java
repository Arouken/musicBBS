package com.bbs.pojo;

import java.util.Date;

public class MusicPost {
	
	private int musicPostID;
	private int musicID;
	private String userID;
	private String replyUserID;
	private String musicPostContent;
	private Date musicPostTime;
	private User user;
	
	
	
	
	public int getMusicPostID() {
		return musicPostID;
	}
	public void setMusicPostID(int musicPostID) {
		this.musicPostID = musicPostID;
	}
	public int getMusicID() {
		return musicID;
	}
	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getReplyUserID() {
		return replyUserID;
	}
	public void setReplyUserID(String replyUserID) {
		this.replyUserID = replyUserID;
	}
	public String getMusicPostContent() {
		return musicPostContent;
	}
	public void setMusicPostContent(String musicPostContent) {
		this.musicPostContent = musicPostContent;
	}
	public Date getMusicPostTime() {
		return musicPostTime;
	}
	public void setMusicPostTime(Date musicPostTime) {
		this.musicPostTime = musicPostTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
