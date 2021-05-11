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
	
	//��̨������ʾ
	@ResponseBody //�Զ�����json��ʽ������
	@RequestMapping("/getMainPostList")
	public Map<String, Object> getMainPostList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		//page��limit��������layui��table���Ĭ���Զ����ݵģ�����ֻ����ռ���
		Map<String, Object> map = new HashMap<String, Object>();
		List<MainPost> list = mainPostService.getMainPostPage(page, limit);//ִ�з�ҳ��ѯ�ķ���
		PageInfo<MainPost> mainPostPageInfo = new PageInfo<MainPost>(list);
		map.put("code", 0);
		map.put("msg", "�����ɹ�");
		map.put("count", mainPostPageInfo.getTotal());
		map.put("data", mainPostPageInfo.getList());//layui��table���Զ���ȡ����ʾ�����ݼ�
		return map;
	}	
	
	//ǰ̨������ʾ
	@RequestMapping("/getMainPostListUser")
	public String getMainPostListUser(Model model,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size){
		//���ϲ�ѯ
	    PageInfo<MainPost> pageInfo = mainPostService.pageHelperList(page,size);
	    //�����ݴ��뵽Model��
	    model.addAttribute("pageInfo",pageInfo);
	    return "/bbs_front/user_index";
	}
	
	//��������
	@RequestMapping("/writeMainPost")
	public String writeMainPost(@RequestParam("mainPostTitle") String mainPostTitle,
			@RequestParam("mainPostContent") String mainPostContent,
			HttpServletRequest request,HttpSession session) throws IOException,ServletException{				
		MainPost mainpost=new MainPost();
		//��ȡ�������֣�����
		mainpost.setMainPostTitle(mainPostTitle);
		mainpost.setMainPostContent(mainPostContent);
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		mainpost.setUserID(userID);		
		//��ȡ����ʱ��
		Date createDate = new Date();
		Timestamp timestamp = new Timestamp(createDate.getTime()); 
		mainpost.setMainPostTime(timestamp);
		//��ȡ����ͼƬ
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("mainPostImg");
		String picname = file.getOriginalFilename();
		if(picname == "") {
			//��ͼ����
			mainpost.setMainPostImg(null);
		}else {
			//������ͼ������
			String uploadPhoto = UploadTool.uploadImg(file);
			mainpost.setMainPostImg(uploadPhoto);	
		}		
		//ִ�����
		mainPostService.addMainPost(mainpost);
		return "redirect:/MainPost/getMainPostListUser";
		
	}
	
	//��ѯ����������Ϣ
	@RequestMapping("/getMainPostContent")
	public String getMainPostContent(HttpSession session,RedirectAttributes attributes,int mainPostID){
		
		MainPost mainpost = mainPostService.getOneMainPost(mainPostID);		
		session.setAttribute("mainpost", mainpost);
	    attributes.addAttribute("mainPostID", mainPostID); 
	    return "redirect:/SecondaryPost/getSecondaryPostList";
	}
	

	
	
	

}
