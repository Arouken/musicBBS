package com.bbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.pojo.MainPost;
import com.bbs.service.MainPostService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/MainPost")
public class MainPostController {
	
	@Autowired
	private MainPostService mainPostService;
	
	@ResponseBody //自动返回json格式的数据
	@RequestMapping("/getMainPostList")
	public Map<String, Object> getMainPostList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		//page、limit参数都是layui的table组件默认自动传递的，我们只需接收即可
		Map<String, Object> map = new HashMap<String, Object>();
		List<MainPost> list = mainPostService.getMainPostPage(page, limit);//执行分页查询的方法
		PageInfo<MainPost> mainPostPageInfo = new PageInfo<MainPost>(list);
		//System.out.println("list的内容为：" + list.get(2));
		System.out.println("pageInfo的内容为：" + mainPostPageInfo.getTotal());
		map.put("code", 0);
		map.put("msg", "操作成功");
		map.put("count", mainPostPageInfo.getTotal());
		map.put("data", mainPostPageInfo.getList());//最最最关键的代码，layui的table会自动获取并显示该数据集
		return map;
	}	
	
	
	/***
	 * 前台主贴展示
	 * @param model
	 * @return
	 */
	@RequestMapping("/getMainPostListUser")
	public String getMainPostListUser(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
	                   @RequestParam(value = "size",required = false,defaultValue = "10")int size,
	                   Model model){
	    //集合查询
	    PageInfo<MainPost> pageInfo = mainPostService.pageHelperList(page,size);
	    //将数据存入到Model中
	    model.addAttribute("pageInfo",pageInfo);
	    System.out.println("前台帖子controller");
	    return "/bbs_front/user_index";
	}
	

}
