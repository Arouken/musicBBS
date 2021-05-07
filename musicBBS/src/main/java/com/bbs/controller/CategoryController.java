package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.pojo.Category;
import com.bbs.pojo.Music;
import com.bbs.service.CategoryService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/getCategoryList")
	public String getCategoryList(Model model,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size) {
		
		PageInfo<Category> categoryList = categoryService.categoryList(page, size);
	    //将数据存入到Model中
	    model.addAttribute("categoryList",categoryList);
		
		return "/bbs_front/user_post_category";
	}

}
