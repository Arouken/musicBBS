package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Category;
import com.github.pagehelper.PageInfo;

public interface CategoryService {
	//��ѯ������
	PageInfo<Category> categoryList(Integer page, Integer size);

	//��ӷ���
	public void addCategory(Category category);

	//��̨��ѯ����
	List<Category> getCategoryPage(Integer page, Integer limit);

	//����Աɾ������
	void deleteCategory(String categoryID);

	//������ѯ
	List<Category> findCategoryBySelect(String categoryKey, String value, Integer page, Integer limit);
	//�������
	void lockCategory(int categoryID, int lock);
}
