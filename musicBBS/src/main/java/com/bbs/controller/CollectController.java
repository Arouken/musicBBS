package com.bbs.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.pojo.Collect;
import com.bbs.pojo.User;
import com.bbs.service.CollectService;
import com.bbs.service.MainPostService;

@Controller
@RequestMapping("/Collect")
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	@Autowired
	private MainPostService mainPostService;

	
	@RequestMapping("/collectPost")
	public void collectPost(HttpSession session,HttpServletResponse response,
			int mainPostID) throws IOException {
		Collect collect=new Collect();
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		collect.setUserID(userID);
		//获取收藏帖子ID
		collect.setMainPostID(mainPostID);
		
		if(collectService.selectCollectPost(collect)==null) {
			mainPostService.addCollectCount(mainPostID);
			collectService.collectPost(collect);
			response.getWriter().write("ok");
		}else {
			mainPostService.deleteCollectCount(mainPostID);
			collectService.disCollectPost(collect);
			response.getWriter().write("no");
		}
	}
}
