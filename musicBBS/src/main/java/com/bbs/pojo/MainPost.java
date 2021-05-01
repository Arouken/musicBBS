package com.bbs.pojo;

import java.util.Date;

public class MainPost {
	private int mainPostID;
	private String userID;
	private User user;
	private LikeMainPost likeMainPost;
	private String mainPostTitle;
	private Date mainPostTime;
	private String mainPostContent;
	private int mainPostCollectCount;
	private int mainPostLikeCount;
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
	public int getMainPostIsLOcked() {
		return mainPostIsLOcked;
	}
	public void setMainPostIsLOcked(int mainPostIsLOcked) {
		this.mainPostIsLOcked = mainPostIsLOcked;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LikeMainPost getLikeMainPost() {
		return likeMainPost;
	}
	public void setLikeMainPost(LikeMainPost likeMainPost) {
		this.likeMainPost = likeMainPost;
	}
	public int getMainPostLikeCount() {
		return mainPostLikeCount;
	}
	public void setMainPostLikeCount(int mainPostLikeCount) {
		this.mainPostLikeCount = mainPostLikeCount;
	}
	public int getMainPostCollectCount() {
		return mainPostCollectCount;
	}
	public void setMainPostCollectCount(int mainPostCollectCount) {
		this.mainPostCollectCount = mainPostCollectCount;
	}
	

}
