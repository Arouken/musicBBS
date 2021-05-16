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
	private String mainPostImg;
	private String categoryName;
	private int mainPostReplyCount;
	private int mainReportCount;
	private int mainPostIsLocked;
	
	
	public int getMainPostReplyCount() {
		return mainPostReplyCount;
	}
	public void setMainPostReplyCount(int mainPostReplyCount) {
		this.mainPostReplyCount = mainPostReplyCount;
	}
	public int getMainReportCount() {
		return mainReportCount;
	}
	public void setMainReportCount(int mainReportCount) {
		this.mainReportCount = mainReportCount;
	}
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getMainPostIsLocked() {
		return mainPostIsLocked;
	}
	public void setMainPostIsLocked(int mainPostIsLocked) {
		this.mainPostIsLocked = mainPostIsLocked;
	}
	

}
