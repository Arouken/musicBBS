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
	//����
	@RequestMapping("/likePost")
	public String likePost(HttpSession session){
		LikeMainPost likeMainPost = new LikeMainPost();		
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		likeMainPost.setUserID(userID);		
		//��ȡ����ID
		MainPost mainpost= (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainpost.getMainPostID();	
		likeMainPost.setMainPostID(mainPostID);
		//ִ�в�ѯ����
		if(likePostService.selectLike(userID, mainPostID)==null) {
			//ִ�е��޷���
			mainPostService.addLikeCount(mainPostID);
			likePostService.likePost(likeMainPost);	
		}else{
			mainPostService.deleteLikeCount(mainPostID);
			likePostService.dislike(userID, mainPostID);
		}
		
		
		//��mainPostIDֵ������ѯcontroller
		
		//ִ�в�ѯ����
		return "redirect:/SecondaryPost/getSecondaryPostList";			
	}

}
