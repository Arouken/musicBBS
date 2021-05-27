package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Category;
import com.github.pagehelper.PageInfo;

public interface CategoryService {
	//查询分区表
	PageInfo<Category> categoryList(Integer page, Integer size);

	//添加分区
	public void addCategory(Category category);

	//后台查询分区
	List<Category> getCategoryPage(Integer page, Integer limit);

	//管理员删除分区
	void deleteCategory(String categoryID);

	//条件查询
	List<Category> findCategoryBySelect(String categoryKey, String value, Integer page, Integer limit);
	//封禁分区
	void lockCategory(int categoryID, int lock);
}
