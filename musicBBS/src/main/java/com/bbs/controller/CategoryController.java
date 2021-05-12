package com.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bbs.pojo.Category;
import com.bbs.pojo.Music;
import com.bbs.pojo.User;
import com.bbs.service.CategoryService;
import com.bbs.utils.UploadTool;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//查询分区列表
	@RequestMapping("/getCategoryList")
	public String getCategoryList(Model model,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size) {
		
		PageInfo<Category> categoryList = categoryService.categoryList(page, size);
	    //将数据存入到Model中
	    model.addAttribute("categoryList",categoryList);
		
		return "/bbs_front/user_post_category";
	}
	
	//增加分区
	@RequestMapping("addCategory")
	public String addCategory(HttpSession session,HttpServletRequest request,
			@RequestParam("categoryName") String categoryName,
			@RequestParam("categoryTxt") String categoryTxt
			) {
		
		Category category = new Category();
		//获取分区名
		category.setCategoryName(categoryName);		
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		category.setUserID(userID);		
		//获取发布时间
		Date categoryCreatDay = new Date();
		category.setCategoryCreatDay(categoryCreatDay);
		//获取分区图片
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("categoryImg");
		String uploadPhoto = UploadTool.addCategoryImg(file);
		category.setCategoryImg(uploadPhoto);
		//获取分区简介
		category.setCategoryTxt(categoryTxt);
		
		categoryService.addCategory(category);
		
		return "/bbs_front/user_newCategory";
	}
	
	//
	
	
	//修改分区
	
	
	
	//删除分区
	
	
	//分区详情

}
