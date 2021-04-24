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



//支持上传的注解:servlet3.0版本提供的

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//用户登陆
	@RequestMapping("/login")
	public String login(User ui,HttpSession session,Model model) {
		User tempUi = userService.login(ui.getUserID(), ui.getPassword());	
		if (tempUi != null && tempUi.getUserID() != null) {
			//保存登陆对象
			session.setAttribute("userSession", tempUi);
			if(tempUi.getCompetence()==1) {				
				System.out.println("管理员登陆成功");
				System.out.println(tempUi.getCompetence());
				return "/bbs_back/admin_index";				
			}
			else {
				System.out.println("用户登陆成功");
				return "redirect:/MainPost/getMainPostListUser";
			}			
		} 
		else {
			System.out.println("登陆失败");
			return "redirect:/user_login.jsp";
		}
	}
	
	//判断用户是否存在，用于检测注册时ID是否重复
	@RequestMapping("/idIsExist")
	public void idIsExist(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{		
		String userid = request.getParameter("userID");	
		User tempUi = userService.idIsExist(userid);	
		if (tempUi == null) {
			//不存在
			response.getWriter().write("ok");
		}else {
			//存在
			response.getWriter().write("no");
		}
	}
	
	//用户注册
	@RequestMapping("/regist")
	public String regist(User user,Model model){
		Date createDate = new Date();
		user.setCreateDate(createDate);
		System.out.println("用户注册："+user.getUserID()+"  "+user.getPassword());				
		userService.regist(user);		
		//注册成功后跳转success.jsp页面
		return "redirect:/user_login.jsp";
	}
	
	//后台用户列表，使用pagerHelper实现分页
	@ResponseBody //自动返回json格式的数据
	@RequestMapping("/getUserList")
	public Map<String, Object> getPage(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		//page、limit参数都是layui的table组件默认自动传递的，我们只需接收即可
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = userService.getUserPage(page, limit);//执行分页查询的方法
		PageInfo<User> userPageInfo = new PageInfo<User>(list);
		//System.out.println("list的内容为：" + list.get(2));
		System.out.println("pageInfo的内容为：" + userPageInfo.getTotal());
		map.put("code", 0);
		map.put("msg", "操作成功");
		map.put("count", userPageInfo.getTotal());
		map.put("data", userPageInfo.getList());//layui的table会自动获取并显示该数据集
		return map;
	}
	
	// 校验输入的图形验证码是否正确
	@RequestMapping("/checkImgCode")
	public void checkImgCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("controller开始比较");
		//获取请求中的图形验证码
		String code = request.getParameter("code");
		//创建session对象
		HttpSession session = request.getSession();
		//调用service的验证方法
		int num= userService.checkImgCode(code,session);
		if (num>0) {
			//验证码正确
			response.getWriter().write("ok");
		}else {
			//验证码错误
			response.getWriter().write("no");
		}
	}
	
	//退出清除session
	@RequestMapping("/quite")
	public String quite(HttpSession session) {
		
		session.removeAttribute("userSession");	
		System.out.println("清除session！");			
	    return "redirect:/user_login.jsp";
	}
	
	//用户头像上传
	@RequestMapping("/uploadPhoto")
	public String uploadPhoto(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException, ServletException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("photo");
		//原图名字
		String fileName = file.getOriginalFilename();
		//改名的图的名字
		String uploadPhoto = UploadTool.uploadImg(file);
		//获取当前登陆对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		userService.uploadUserPhoto(userID, uploadPhoto);
		System.out.println(userID);
		System.out.println(fileName);
		System.out.println(uploadPhoto);
		return "redirect:/bbs_front/user_info_img.jsp";			
	}
	
	//用户更新密码
	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam("newPassword") String password,HttpSession session){				
		//获取当前登陆对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		System.out.println("新的密码："+password);
		userService.updateUserPassword(userID, password);
		return "redirect:/user_login.jsp";			
	}
	
	
}
