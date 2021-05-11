package com.bbs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
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
	@Autowired
	private MainPostService mainPostService;
	
	//@ResponseBody注解就能返回JSON的数据了
	
	//点赞
	@RequestMapping("/likePost")
	public void likePost(HttpSession session,HttpServletResponse response,
			int mainPostID) throws IOException{
		LikeMainPost likeMainPost = new LikeMainPost();	
		
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		//获取登陆对象ID
		likeMainPost.setUserID(userID);		
		//获取点赞帖子ID
		likeMainPost.setMainPostID(mainPostID);
	
		if(likePostService.selectLike(likeMainPost)==null) {
			//执行点赞方法
			System.out.println("执行赞");
			mainPostService.addLikeCount(mainPostID);
			likePostService.likePost(likeMainPost);
			response.getWriter().write("ok");
		}else{
			System.out.println("执行不赞");
			mainPostService.deleteLikeCount(mainPostID);
			likePostService.dislike(likeMainPost);
			response.getWriter().write("no");
		}	
				
	}
	
	//查询是否点过赞初始化数据
	@RequestMapping("/likeInt")
	public void likeInt(HttpSession session,int mainPostID,
			HttpServletResponse response) throws IOException {		
		LikeMainPost likeMainPost = new LikeMainPost();
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		//获取登陆对象ID
		likeMainPost.setUserID(userID);		
		//获取点赞帖子ID
		likeMainPost.setMainPostID(mainPostID);
		if(likePostService.selectLike(likeMainPost)==null) {			
			response.getWriter().write("ok");
		}else{
			response.getWriter().write("no");
		}			
	}
	

}
