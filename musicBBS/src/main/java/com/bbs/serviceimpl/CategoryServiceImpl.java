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
		//1）静态分页
		PageHelper.startPage(page,size);
		 //2）集合查询
		List<Category> categoryList = categoryDao.selectCategoryList();
		//3）返回PageInfo:包含数据结果集+分页信息
		return new PageInfo<Category>(categoryList);
		
		
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDao.addCategory(category);
	}
	
   
  
    
}
