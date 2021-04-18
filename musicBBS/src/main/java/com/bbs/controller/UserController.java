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
	
	//用户登陆
	@RequestMapping("/login")
	public String login(User ui) {
		User tempUi = userService.login(ui.getUserName(), ui.getPassword());
	
		if (tempUi != null && tempUi.getUserName() != null) {
			if(tempUi.getCompetence()==1) {
				System.out.println("管理员登陆成功");
				System.out.println(tempUi.getCompetence());
				return "/bbs_back/admin_index";				
			}
			else {
				System.out.println("用户登陆成功");
				System.out.println(tempUi.getCompetence());
				return "/bbs_front/user_index";		
			}			
		} 
		else {
			System.out.println("登陆失败");
			return "redirect:/user_login.jsp";
		}
	}
	
	
	@RequestMapping("/userlist")
	public String userlist() {
		return "redirect:/testtable.jsp";
	}
	
	//用户注册
	@RequestMapping("/regist")
	public String regist(User user,Model model){
		
		System.out.println("用户注册："+user.getUserName()+"  "+user.getPassword());				
		userService.regist(user);		
		//注册成功后跳转success.jsp页面
		return "redirect:/user_login.jsp";
	}
	
	//使用pagerHelper实现分页
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
	
	/**
	 * 校验输入的图形验证码是否正确
	 */
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
	
}
