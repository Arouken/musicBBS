package com.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
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
	
	//��Ӿٱ�
	@RequestMapping("/addReport")
	public String addReport(HttpSession session,
			@RequestParam("reportTxt")String reportReason) {
		
		ReportMain reportMain = new ReportMain();
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		reportMain.setUserID(userID);
		//��ȡ�ٱ����Ӷ���
		MainPost mainPost = (MainPost) session.getAttribute("mainpost");
		int mainPostID = mainPost.getMainPostID();
		reportMain.setMainPostID(mainPostID);
		//��ȡ����ʱ��
		Date createDate = new Date();
		Timestamp reportMainTime = new Timestamp(createDate.getTime()); 
		reportMain.setReportMainTime(reportMainTime);
		//��ȡ�ٱ�ԭ��
		reportMain.setReportReason(reportReason);
		//�ٱ���һ
		mainPostService.addReportCount(mainPostID);
		//ִ����ӷ���
		reportMainService.addReportMain(reportMain);
		return "/bbs_front/user_report_main";
			
	}
	
	//�����������
	@RequestMapping("/lockMainPost")
	@ResponseBody
	public String lockMainPost(int mainPostID,int mainPostIsLocked) {				
		JSONObject jsonObject = new JSONObject();
		int lock;
		jsonObject.put("msg", "1");	
		try {
			
			if(mainPostIsLocked==0) {
				lock = 1;
				jsonObject.put("result", "1");
			}else {
				lock = 0;
				jsonObject.put("result", "2");
			}					
			reportMainService.lockMainPost(mainPostID, lock);
			System.out.println("�������ID:"+mainPostID+"���״̬"+lock);
			
		} catch (Exception e) {
			jsonObject.put("result", "0");
			e.printStackTrace();
		}
		return jsonObject.toString();		
	}
	
	
	
	
	//��ѯ�Ƿ��Ѿ��ٱ�
	@RequestMapping("/selectIsReport")
	public String selectIsReport() {
				
		return null;	
	}

}
