package com.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbs.pojo.MainPost;
import com.bbs.pojo.SecondaryPost;
import com.bbs.pojo.User;
import com.bbs.service.MainPostService;
import com.bbs.service.SecondaryPostService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/SecondaryPost")
public class SecondaryPostController {
	
	@Autowired
	private SecondaryPostService secondaryPostService;
	
	
	//根据主贴表ID查询回帖表
	@RequestMapping("/getSecondaryPostList")	
	public String getSecondaryPostList(Model model,int mainPostID,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size){
		//集合查询
	    PageInfo<SecondaryPost> secondaryPostList = secondaryPostService.getSecondaryPostList(page, size, mainPostID);
	    //将数据存入到Model中
	    model.addAttribute("secondaryPostList",secondaryPostList);	    
	    System.out.println("回复帖子controller");
	    System.out.println("集合值"+secondaryPostList);
	    System.out.println("集合值条数大小：" + secondaryPostList.getTotal());
	    return "/bbs_front/mainPostContent";
	}
	
	@RequestMapping("/writeSecondaryPost")
	public String writeSecondaryPost(HttpSession session,RedirectAttributes attributes,
			@RequestParam("secondaryPostContent") String secondaryPostContent){
		SecondaryPost secondaryPost = new SecondaryPost();
		secondaryPost.setSecondaryPostContent(secondaryPostContent);
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		secondaryPost.setUserID(userID);
		//获取主贴ID
		MainPost mainpost= (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainpost.getMainPostID();
		secondaryPost.setMainPostID(mainPostID);
		//获取发布时间
		Date createDate = new Date();
		Timestamp timestamp = new Timestamp(createDate.getTime()); //2013-01-14 22:45:36.484 
		secondaryPost.setSecondaryPostTime(timestamp);
		//执行回帖方法
		secondaryPostService.addSecondaryPost(secondaryPost);
		//把mainPostID值传给查询controller
		attributes.addAttribute("mainPostID", mainPostID);
		//执行查询回帖
		return "redirect:/SecondaryPost/getSecondaryPostList";			
	}
}
