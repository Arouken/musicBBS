package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.CategoryDao;
import com.bbs.pojo.Category;
import com.bbs.pojo.MainPost;
import com.bbs.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public PageInfo<Category> categoryList(Integer page, Integer size) {
		// TODO Auto-generated method stub
		//1����̬��ҳ
		PageHelper.startPage(page,size);
		 //2�����ϲ�ѯ
		List<Category> categoryList = categoryDao.selectCategoryList();
		//3������PageInfo:�������ݽ����+��ҳ��Ϣ
		return new PageInfo<Category>(categoryList);
		
		
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.addCategory(category);
	}
	
   
  
    
}
