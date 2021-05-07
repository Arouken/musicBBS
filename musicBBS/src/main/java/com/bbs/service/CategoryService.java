package com.bbs.service;

import com.bbs.pojo.Category;
import com.github.pagehelper.PageInfo;

public interface CategoryService {
	//查询分区表
	PageInfo<Category> categoryList(Integer page, Integer size);

}
