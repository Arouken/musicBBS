package com.bbs.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbs.pojo.MainPost;
import com.bbs.pojo.User;
import com.bbs.service.MainPostService;
import com.bbs.utils.UploadTool;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/MainPost")
public class MainPostController {
	
	@Autowired
	private MainPostService mainPostService;
	
	//后台主贴显示
	@ResponseBody //自动返回json格式的数据
	@RequestMapping("/getMainPostList")
	public Map<String, Object> getMainPostList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		//page、limit参数都是layui的table组件默认自动传递的，我们只需接收即可
		Map<String, Object> map = new HashMap<String, Object>();
		List<MainPost> list = mainPostService.getMainPostPage(page, limit);//执行分页查询的方法
		PageInfo<MainPost> mainPostPageInfo = new PageInfo<MainPost>(list);
		map.put("code", 0);
		map.put("msg", "操作成功");
		map.put("count", mainPostPageInfo.getTotal());
		map.put("data", mainPostPageInfo.getList());//layui的table会自动获取并显示该数据集
		return map;
	}	
	
	//前台主贴显示
	@RequestMapping("/getMainPostListUser")
	public String getMainPostListUser(Model model,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size){
		//集合查询
	    PageInfo<MainPost> pageInfo = mainPostService.pageHelperList(page,size);
	    //将数据存入到Model中
	    model.addAttribute("pageInfo",pageInfo);
	    return "/bbs_front/user_index";
	}
	
	//发布帖子
	@RequestMapping("/writeMainPost")
	public String writeMainPost(@RequestParam("mainPostTitle") String mainPostTitle,
			@RequestParam("mainPostContent") String mainPostContent,
			HttpServletRequest request,HttpSession session) throws IOException,ServletException{				
		MainPost mainpost=new MainPost();
		//获取帖子名字，内容
		mainpost.setMainPostTitle(mainPostTitle);
		mainpost.setMainPostContent(mainPostContent);
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		mainpost.setUserID(userID);		
		//获取发布时间
		Date createDate = new Date();
		Timestamp timestamp = new Timestamp(createDate.getTime()); 
		mainpost.setMainPostTime(timestamp);
		//获取帖子图片
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("mainPostImg");
		String picname = file.getOriginalFilename();
		if(picname == "") {
			//无图帖子
			mainpost.setMainPostImg(null);
		}else {
			//改名的图的名字
			String uploadPhoto = UploadTool.uploadImg(file);
			mainpost.setMainPostImg(uploadPhoto);	
		}		
		//执行添加
		mainPostService.addMainPost(mainpost);
		return "redirect:/MainPost/getMainPostListUser";
		
	}
	
	//查询单个帖子信息
	@RequestMapping("/getMainPostContent")
	public String getMainPostContent(HttpSession session,RedirectAttributes attributes,int mainPostID){
		
		MainPost mainpost = mainPostService.getOneMainPost(mainPostID);		
		session.setAttribute("mainpost", mainpost);
	    attributes.addAttribute("mainPostID", mainPostID); 
	    return "redirect:/SecondaryPost/getSecondaryPostList";
	}
	

	
	
	

}
