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
	
	//@ResponseBodyע����ܷ���JSON��������
	
	//����
	@RequestMapping("/likePost")
	public void likePost(HttpSession session,HttpServletResponse response,
			int mainPostID) throws IOException{
		LikeMainPost likeMainPost = new LikeMainPost();	
		
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		//��ȡ��½����ID
		likeMainPost.setUserID(userID);		
		//��ȡ��������ID
		likeMainPost.setMainPostID(mainPostID);
	
		if(likePostService.selectLike(likeMainPost)==null) {
			//ִ�е��޷���
			System.out.println("ִ����");
			mainPostService.addLikeCount(mainPostID);
			likePostService.likePost(likeMainPost);
			response.getWriter().write("ok");
		}else{
			System.out.println("ִ�в���");
			mainPostService.deleteLikeCount(mainPostID);
			likePostService.dislike(likeMainPost);
			response.getWriter().write("no");
		}	
				
	}
	
	//��ѯ�Ƿ����޳�ʼ������
	@RequestMapping("/likeInt")
	public void likeInt(HttpSession session,int mainPostID,
			HttpServletResponse response) throws IOException {		
		LikeMainPost likeMainPost = new LikeMainPost();
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		//��ȡ��½����ID
		likeMainPost.setUserID(userID);		
		//��ȡ��������ID
		likeMainPost.setMainPostID(mainPostID);
		if(likePostService.selectLike(likeMainPost)==null) {			
			response.getWriter().write("ok");
		}else{
			response.getWriter().write("no");
		}			
	}
	

}
