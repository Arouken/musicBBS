package com.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
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
	
	//��ѯ�����б�
	@RequestMapping("/getCategoryList")
	public String getCategoryList(Model model,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size) {
		
		PageInfo<Category> categoryList = categoryService.categoryList(page, size);
	    //�����ݴ��뵽Model��
	    model.addAttribute("categoryList",categoryList);
		
		return "/bbs_front/user_post_category";
	}
	
	//���ӷ���
	@RequestMapping("addCategory")
	public String addCategory(HttpSession session,HttpServletRequest request,
			@RequestParam("categoryName") String categoryName,
			@RequestParam("categoryTxt") String categoryTxt
			) {
		
		Category category = new Category();
		//��ȡ������
		category.setCategoryName(categoryName);		
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		category.setUserID(userID);		
		//��ȡ����ʱ��
		Date categoryCreatDay = new Date();
		category.setCategoryCreatDay(categoryCreatDay);
		//��ȡ����ͼƬ
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("categoryImg");
		String uploadPhoto = UploadTool.addCategoryImg(file);
		category.setCategoryImg(uploadPhoto);
		//��ȡ�������
		category.setCategoryTxt(categoryTxt);
		
		categoryService.addCategory(category);
		
		return "/bbs_front/user_newCategory";
	}
	
	@ResponseBody // �Զ�����json��ʽ������
	@RequestMapping("/getBackCategoryList")
	public Map<String, Object> getPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		// page��limit��������layui��table���Ĭ���Զ����ݵģ�����ֻ����ռ���
		Map<String, Object> map = new HashMap<String, Object>();
		List<Category> list = categoryService.getCategoryPage(page, limit);// ִ�з�ҳ��ѯ�ķ���
		PageInfo<Category> categoryPageInfo = new PageInfo<Category>(list);
		map.put("code", 0);
		map.put("msg", "�����ɹ�");
		map.put("count", categoryPageInfo.getTotal());
		map.put("data", categoryPageInfo.getList());// layui��table���Զ���ȡ����ʾ�����ݼ�
		return map;
	}
	
	//������ѯ����
	@RequestMapping("/findCategoryBySelect")
	@ResponseBody
	public Map<String, Object> findCategoryBySelect(
			@RequestParam("categoryKey") String categoryKey, 
			@RequestParam("categoryValue") String value,
			@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit) {
		if (categoryKey.equals("0")) {categoryKey = "categoryID";}
		if (categoryKey.equals("1")) {categoryKey = "categoryName";}
		if (categoryKey.equals("2")) {categoryKey = "categoryTxt";}
		List<Category> category = categoryService.findCategoryBySelect(categoryKey, value, page, limit);
		Map<String, Object> map = new HashMap<String, Object>();
		PageInfo<Category> categoryByselect = new PageInfo<Category>(category);
		map.put("code", 0);
		map.put("msg", "�����ɹ�");
		map.put("count", categoryByselect.getTotal());
		map.put("data", categoryByselect.getList());
		return map;
	}
	
	
	
	//����Ա�h������
	@RequestMapping("/deleteCategory")
	@ResponseBody
	public String deleteCategory(@RequestParam("categoryID") String categoryID) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "1");
		try {
			categoryService.deleteCategory(categoryID);
			jsonObject.put("result", "1");
		} catch (Exception e) {
			jsonObject.put("result", "0");
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject.toString();	
	}
	
	//�������
	@RequestMapping("/lockCategory")
	@ResponseBody
	public String lockCategory(int categoryID,int categoryIsLocked) {				
		JSONObject jsonObject = new JSONObject();
		int lock;
		jsonObject.put("msg", "1");	
		try {
			
			if(categoryIsLocked==0) {
				lock = 1;
				jsonObject.put("result", "1");
			}else {
				lock = 0;
				jsonObject.put("result", "2");
			}					
			categoryService.lockCategory(categoryID, lock);
			System.out.println("�������ID:"+categoryService+"���״̬"+lock);
			
		} catch (Exception e) {
			jsonObject.put("result", "0");
			e.printStackTrace();
		}
		return jsonObject.toString();		
	}

}
