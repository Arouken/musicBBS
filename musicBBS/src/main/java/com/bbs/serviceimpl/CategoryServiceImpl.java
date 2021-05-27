package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.CategoryDao;
import com.bbs.pojo.Category;
import com.bbs.pojo.MainPost;
import com.bbs.pojo.Music;
import com.bbs.pojo.User;
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

	//后台查询分区
	@Override
	public List<Category> getCategoryPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//page为申请查询的页码，limit为一页显示多少条数据
		List<Category> category = categoryDao.selectCategoryList();//PageHelper.startPage()后面必须紧接查询数据的方法
		return category;		
	}

	@Override
	public void deleteCategory(String categoryID) {
		// TODO Auto-generated method stub
		categoryDao.deleteCategory(categoryID);
	}

	//条件查询
	@Override
	public List<Category> findCategoryBySelect(String categoryKey, String categoryValue, Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//page为申请查询的页码，limit为一页显示多少条数据
		List<Category> category = categoryDao.findCategoryBySelect(categoryKey, categoryValue);//PageHelper.startPage()后面必须紧接查询数据的方法
		return category;	
	}

	//封禁分区
	@Override
	public void lockCategory(int categoryID, int lock) {
		// TODO Auto-generated method stub
		categoryDao.lockCategory(categoryID,lock);
	}
	
   
  
    
}
