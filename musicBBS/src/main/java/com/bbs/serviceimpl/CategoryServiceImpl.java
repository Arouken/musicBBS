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

	//��̨��ѯ����
	@Override
	public List<Category> getCategoryPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//pageΪ�����ѯ��ҳ�룬limitΪһҳ��ʾ����������
		List<Category> category = categoryDao.selectCategoryList();//PageHelper.startPage()���������Ӳ�ѯ���ݵķ���
		return category;		
	}

	@Override
	public void deleteCategory(String categoryID) {
		// TODO Auto-generated method stub
		categoryDao.deleteCategory(categoryID);
	}

	//������ѯ
	@Override
	public List<Category> findCategoryBySelect(String categoryKey, String categoryValue, Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//pageΪ�����ѯ��ҳ�룬limitΪһҳ��ʾ����������
		List<Category> category = categoryDao.findCategoryBySelect(categoryKey, categoryValue);//PageHelper.startPage()���������Ӳ�ѯ���ݵķ���
		return category;	
	}

	//�������
	@Override
	public void lockCategory(int categoryID, int lock) {
		// TODO Auto-generated method stub
		categoryDao.lockCategory(categoryID,lock);
	}
	
   
  
    
}
