package com.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//�û���½
	@RequestMapping("/login")
	public String login(User ui) {
		User tempUi = userService.login(ui.getUserName(), ui.getPassword());
	
		if (tempUi != null && tempUi.getUserName() != null) {
			if(tempUi.getCompetence()==1) {
				System.out.println("����Ա��½�ɹ�");
				System.out.println(tempUi.getCompetence());
				return "/bbs_back/admin_index";				
			}
			else {
				System.out.println("�û���½�ɹ�");
				System.out.println(tempUi.getCompetence());
				return "/bbs_front/user_index";		
			}			
		} 
		else {
			System.out.println("��½ʧ��");
			return "redirect:/user_login.jsp";
		}
	}
	
	
	@RequestMapping("/userlist")
	public String userlist() {
		return "redirect:/testtable.jsp";
	}
	
	//�û�ע��
	@RequestMapping("/regist")
	public String regist(User user,Model model){
		
		System.out.println("�û�ע�᣺"+user.getUserName()+"  "+user.getPassword());				
		userService.regist(user);		
		//ע��ɹ�����תsuccess.jspҳ��
		return "redirect:/user_login.jsp";
	}
	
	//ʹ��pagerHelperʵ�ַ�ҳ
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
	
	/**
	 * У�������ͼ����֤���Ƿ���ȷ
	 */
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
	
}
