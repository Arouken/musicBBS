package com.bbs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bbs.pojo.MainPost;
import com.bbs.pojo.User;
import com.bbs.service.MainPostService;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import com.bbs.utils.UploadTool;



//֧���ϴ���ע��:servlet3.0�汾�ṩ��

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//�û���½
	@RequestMapping("/login")
	public String login(User ui,HttpSession session,Model model) {
		User tempUi = userService.login(ui.getUserID(), ui.getPassword());	
		if (tempUi != null && tempUi.getUserID() != null) {
			//�����½����
			session.setAttribute("userSession", tempUi);
			if(tempUi.getCompetence()==1) {				
				System.out.println("����Ա��½�ɹ�");
				System.out.println(tempUi.getCompetence());
				return "/bbs_back/admin_index";				
			}
			else {
				System.out.println("�û���½�ɹ�");
				return "redirect:/MainPost/getMainPostListUser";
			}			
		} 
		else {
			System.out.println("��½ʧ��");
			return "redirect:/user_login.jsp";
		}
	}
	
	//�û�ʹ���ֻ��ŵ�½
	@RequestMapping("/phoneLogin")
	public String phoneLogin(HttpSession session) {
		
		User user = (User) session.getAttribute("loginSession");
		session.setAttribute("userSession", user);
		session.removeAttribute("loginSession");
		if (user != null && user.getUserID() != null) {
			//�����½����
			session.setAttribute("userSession", user);
			if(user.getCompetence()==1) {				
				System.out.println("����Ա��½�ɹ�");
				System.out.println(user.getCompetence());
				return "/bbs_back/admin_index";				
			}
			else {
				System.out.println("�û���½�ɹ�");
				return "redirect:/MainPost/getMainPostListUser";
			}			
		} 
		else {
			System.out.println("��½ʧ��");
			return "redirect:/user_login.jsp";
		}
	
	}
	
	//�û���ȡ��֤��
	@RequestMapping("/getPhoneCode")
	public void getPhoneCode(HttpServletResponse response,HttpSession session,
			@RequestParam("phone")String phone) throws IOException {
		
		String oldCode = userService.sendPhoneCode(phone);
		session.setAttribute("oldCode", oldCode);
		response.getWriter().write("��֤���ѷ���");
		
	}
	
	//����ֻ���֤���Ƿ���ȷ
	@RequestMapping("/checkPhoneCode")
	public void checkPhoneCode(String phone,HttpServletResponse response,
			String phoneCode,HttpSession session) throws IOException {
		String oldCode = (String) session.getAttribute("oldCode");
		String newCode = phone+"#"+phoneCode;
		if (oldCode.equals(newCode)) {
			//��֤����ȷ
			response.getWriter().write("ok");
		}else {
			//����
			response.getWriter().write("no");
		}
	}
	
	
	
	//��֤�û��ֻ����Ƿ��
	@RequestMapping("/phoneIsExit")
	public void phoneIsExit(HttpSession session,HttpServletResponse response,
			@RequestParam("phone")String phone) throws IOException {
		
		User user = userService.checkPhoneIsExit(phone);
		
		if (user == null) {
			//������
			response.getWriter().write("no");
		}else {
			//����
			session.setAttribute("loginSession", user);
			response.getWriter().write("ok");
		}
		
	}
	
	//�ж��û��Ƿ���ڣ����ڼ��ע��ʱID�Ƿ��ظ�
	@RequestMapping("/idIsExist")
	public void idIsExist(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{		
		String userid = request.getParameter("userID");	
		User tempUi = userService.idIsExist(userid);	
		if (tempUi == null) {
			//������
			response.getWriter().write("ok");
		}else {
			//����
			response.getWriter().write("no");
		}
	}
	
	//�û�ע��
	@RequestMapping("/regist")
	public String regist(User user,Model model){
		Date createDate = new Date();
		user.setCreateDate(createDate);
		System.out.println("�û�ע�᣺"+user.getUserID()+"  "+user.getPassword());				
		userService.regist(user);		
		//ע��ɹ�����תsuccess.jspҳ��
		return "redirect:/user_login.jsp";
	}
	
	//��̨�û��б�ʹ��pagerHelperʵ�ַ�ҳ
	@ResponseBody //�Զ�����json��ʽ������
	@RequestMapping("/getUserList")
	public Map<String, Object> getPage(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		//page��limit��������layui��table���Ĭ���Զ����ݵģ�����ֻ����ռ���
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = userService.getUserPage(page, limit);//ִ�з�ҳ��ѯ�ķ���
		PageInfo<User> userPageInfo = new PageInfo<User>(list);
		//System.out.println("list������Ϊ��" + list.get(2));
		System.out.println("pageInfo������Ϊ��" + userPageInfo.getTotal());
		map.put("code", 0);
		map.put("msg", "�����ɹ�");
		map.put("count", userPageInfo.getTotal());
		map.put("data", userPageInfo.getList());//layui��table���Զ���ȡ����ʾ�����ݼ�
		return map;
	}
	
	// У�������ͼ����֤���Ƿ���ȷ
	@RequestMapping("/checkImgCode")
	public void checkImgCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("controller��ʼ�Ƚ�");
		//��ȡ�����е�ͼ����֤��
		String code = request.getParameter("code");
		//����session����
		HttpSession session = request.getSession();
		//����service����֤����
		int num= userService.checkImgCode(code,session);
		if (num>0) {
			//��֤����ȷ
			response.getWriter().write("ok");
		}else {
			//��֤�����
			response.getWriter().write("no");
		}
	}
	
	//�˳����session
	@RequestMapping("/quite")
	public String quite(HttpSession session) {
		
		session.removeAttribute("userSession");	
		System.out.println("���session��");			
	    return "redirect:/user_login.jsp";
	}
	
	//�û�ͷ���ϴ�
	@RequestMapping("/uploadPhoto")
	public String uploadPhoto(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException, ServletException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("photo");
		//ԭͼ����
		String fileName = file.getOriginalFilename();
		//������ͼ������
		String uploadPhoto = UploadTool.uploadImg(file);
		//��ȡ��ǰ��½����id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		userService.uploadUserPhoto(userID, uploadPhoto);
		System.out.println(userID);
		System.out.println(fileName);
		System.out.println(uploadPhoto);
		return "redirect:/bbs_front/user_info_img.jsp";			
	}
	
	//�û���������
	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam("newPassword") String password,HttpSession session){				
		//��ȡ��ǰ��½����id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		System.out.println("�µ����룺"+password);
		userService.updateUserPassword(userID, password);
		return "redirect:/user_login.jsp";			
	}
	
	//����û�������
	@RequestMapping("/checkOldPassword")
	public void checkOldPassword(@RequestParam("oldPassword") String oldPassword,
			HttpServletResponse response,HttpSession session)throws Exception{				
		//��ȡ��ǰ��½����id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		System.out.println("�ɵ����룺"+oldPassword);
		User userPass = userService.checkOldPassword(userID, oldPassword);	    
	    if (userPass != null && userPass.getUserID() != null) {
	    	response.getWriter().write("ok");			
		} 
		else {
			response.getWriter().write("no");			
		}			
	}
	
	//�ж��û��Ƿ��¼
	@RequestMapping("/checkIsLogin")
	public void checkIsLogin(HttpServletResponse response,
			HttpSession session)throws Exception{				
	    if ( session.getAttribute("userSession")!= null) {
	    	response.getWriter().write("ok");			
		} 
		else {
			response.getWriter().write("no");			
		}			
	}
	
}
