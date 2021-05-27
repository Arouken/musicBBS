package com.bbs.pojo;

import java.util.Date;

public class Category {
	
	private int categoryID;
	private int categoryIsLocked;
	private String categoryName;
	private String userID;
	private String categoryTxt;
	private Date categoryCreatDay;
	private String categoryImg;
	
	
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getCategoryTxt() {
		return categoryTxt;
	}
	public void setCategoryTxt(String categoryTxt) {
		this.categoryTxt = categoryTxt;
	}
	public Date getCategoryCreatDay() {
		return categoryCreatDay;
	}
	public void setCategoryCreatDay(Date categoryCreatDay) {
		this.categoryCreatDay = categoryCreatDay;
	}
	public String getCategoryImg() {
		return categoryImg;
	}
	public void setCategoryImg(String categoryImg) {
		this.categoryImg = categoryImg;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryIsLocked() {
		return categoryIsLocked;
	}
	public void setCategoryIsLocked(int categoryIsLocked) {
		this.categoryIsLocked = categoryIsLocked;
	}

}
