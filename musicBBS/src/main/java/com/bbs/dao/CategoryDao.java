package com.bbs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bbs.pojo.Category;

public interface CategoryDao {
	
	//��ѯ������
	public List<Category> selectCategoryList();
	//������ѯ
	public List<Category> findCategoryBySelect(@Param("categoryKey")String categoryKey, 
			@Param("categoryValue")String categoryValue);

	//��ӷ���
	public void addCategory(Category category);

	//����Աɾ������
	public void deleteCategory(String categoryID);
	
	//���������
	public void lockCategory(int categoryID, int lock);
	

}
