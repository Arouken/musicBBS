package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.Category;

public interface CategoryDao {
	
	//查询分区表
	public List<Category> selectCategoryList();

	//添加分区
	public void addCategory(Category category);
}
