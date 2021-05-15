package com.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.pojo.MainPost;
import com.bbs.pojo.ReportMain;
import com.bbs.pojo.User;
import com.bbs.service.MainPostService;
import com.bbs.service.ReportMainService;

@Controller
@RequestMapping("/ReportMain")
public class ReportMainController {
	
	@Autowired
	private ReportMainService reportMainService;
	@Autowired
	private MainPostService mainPostService;
	
	//添加举报
	@RequestMapping("/addReport")
	public String addReport(HttpSession session,
			@RequestParam("reportTxt")String reportReason) {
		
		ReportMain reportMain = new ReportMain();
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		reportMain.setUserID(userID);
		//获取举报帖子对象
		MainPost mainPost = (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainPost.getMainPostID();
		reportMain.setMainPostID(mainPostID);
		//获取发布时间
		Date createDate = new Date();
		Timestamp reportMainTime = new Timestamp(createDate.getTime()); 
		reportMain.setReportMainTime(reportMainTime);
		//获取举报原因
		reportMain.setReportReason(reportReason);
		//举报加一
		mainPostService.addReportCount(mainPostID);
		//执行添加方法
		reportMainService.addReportMain(reportMain);
		return "/bbs_front/user_report_main";
			
	}
	
	//后台显示举报帖子表
	
	
	
	//查询是否已经举报
	@RequestMapping("/selectIsReport")
	public String selectIsReport() {
				
		return null;	
	}

}
