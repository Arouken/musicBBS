package com.bbs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.pojo.LikeMainPost;
import com.bbs.pojo.MainPost;
import com.bbs.pojo.User;
import com.bbs.service.LikeMainPostService;
import com.bbs.service.MainPostService;

@Controller
@RequestMapping("/LikeMainPost")
public class LikeMainPostController {
	
	@Autowired
	private LikeMainPostService likePostService;
	private MainPostService mainPostService;
	//点赞
	@RequestMapping("/likePost")
	public String likePost(HttpSession session){
		LikeMainPost likeMainPost = new LikeMainPost();		
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		likeMainPost.setUserID(userID);		
		//获取主贴ID
		MainPost mainpost= (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainpost.getMainPostID();	
		likeMainPost.setMainPostID(mainPostID);
		//执行查询方法
		if(likePostService.selectLike(userID, mainPostID)==null) {
			//执行点赞方法
			mainPostService.addLikeCount(mainPostID);
			likePostService.likePost(likeMainPost);	
		}else{
			mainPostService.deleteLikeCount(mainPostID);
			likePostService.dislike(userID, mainPostID);
		}
		
		
		//把mainPostID值传给查询controller
		
		//执行查询回帖
		return "redirect:/SecondaryPost/getSecondaryPostList";			
	}

}
