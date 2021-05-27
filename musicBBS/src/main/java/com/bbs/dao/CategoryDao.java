package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bbs.pojo.Category;

public interface CategoryDao {
	
	//查询分区表
	public List<Category> selectCategoryList();
	//条件查询
	public List<Category> findCategoryBySelect(@Param("categoryKey")String categoryKey, 
			@Param("categoryValue")String categoryValue);

	//添加分区
	public void addCategory(Category category);

	//管理员删除分区
	public void deleteCategory(String categoryID);
	
	//封禁解封分区
	public void lockCategory(int categoryID, int lock);
	

}
