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
	
	
	//����������ID��ѯ������
	@RequestMapping("/getSecondaryPostList")	
	public String getSecondaryPostList(Model model,int mainPostID,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size){
		//���ϲ�ѯ
	    PageInfo<SecondaryPost> secondaryPostList = secondaryPostService.getSecondaryPostList(page, size, mainPostID);
	    //�����ݴ��뵽Model��
	    model.addAttribute("secondaryPostList",secondaryPostList);	    
	    return "/bbs_front/mainPostContent";
	}
	
	//�ظ�����
	@RequestMapping("/writeSecondaryPost")
	public String writeSecondaryPost(HttpSession session,RedirectAttributes attributes,
			@RequestParam("secondaryPostContent") String secondaryPostContent){
		SecondaryPost secondaryPost = new SecondaryPost();
		secondaryPost.setSecondaryPostContent(secondaryPostContent);
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		secondaryPost.setUserID(userID);	
		//��ȡ����ID
		MainPost mainpost= (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainpost.getMainPostID();	
		secondaryPost.setMainPostID(mainPostID);
		//�ظ����������û�ID
		String replyUserID = mainpost.getUserID();
		secondaryPost.setReplyUserID(replyUserID);
		//��ȡ����ʱ��
		Date createDate = new Date();
		Timestamp timestamp = new Timestamp(createDate.getTime()); 
		secondaryPost.setSecondaryPostTime(timestamp);
		//ִ�л�������
		secondaryPostService.addSecondaryPost(secondaryPost);
		//��mainPostIDֵ������ѯcontroller
		attributes.addAttribute("mainPostID", mainPostID);
		//ִ�в�ѯ����
		return "redirect:/SecondaryPost/getSecondaryPostList";			
	}
	
	//�ظ���������Ļظ�
	@RequestMapping("/writeToSecondaryPost")
	public String writeToSecondaryPost(
			HttpSession session,RedirectAttributes attributes,
			@RequestParam("secondaryPostContent") String secondaryPostContent,
			String replyUserID){
		SecondaryPost secondaryPost = new SecondaryPost();
		secondaryPost.setSecondaryPostContent(secondaryPostContent);
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		secondaryPost.setUserID(userID);
		//��ȡ�ظ�����ID
		secondaryPost.setReplyUserID(replyUserID);
		//��ȡ����ID
		MainPost mainpost= (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainpost.getMainPostID();
		secondaryPost.setMainPostID(mainPostID);
		//��ȡ����ʱ��
		Date createDate = new Date();
		Timestamp timestamp = new Timestamp(createDate.getTime());
		secondaryPost.setSecondaryPostTime(timestamp);
		//ִ�л�������
		secondaryPostService.addSecondaryPost(secondaryPost);
		//��mainPostIDֵ������ѯcontroller
		attributes.addAttribute("mainPostID", mainPostID);
		//ִ�в�ѯ����
		return "redirect:/SecondaryPost/getSecondaryPostList";			
	}
}
