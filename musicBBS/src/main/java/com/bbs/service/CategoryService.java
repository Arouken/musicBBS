package com.bbs.service;

import com.bbs.pojo.Category;
import com.github.pagehelper.PageInfo;

public interface CategoryService {
	//��ѯ������
	PageInfo<Category> categoryList(Integer page, Integer size);

}
