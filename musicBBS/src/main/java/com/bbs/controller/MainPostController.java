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
	
	@ResponseBody //�Զ�����json��ʽ������
	@RequestMapping("/getMainPostList")
	public Map<String, Object> getMainPostList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		//page��limit��������layui��table���Ĭ���Զ����ݵģ�����ֻ����ռ���
		Map<String, Object> map = new HashMap<String, Object>();
		List<MainPost> list = mainPostService.getMainPostPage(page, limit);//ִ�з�ҳ��ѯ�ķ���
		PageInfo<MainPost> mainPostPageInfo = new PageInfo<MainPost>(list);
		//System.out.println("list������Ϊ��" + list.get(2));
		System.out.println("pageInfo������Ϊ��" + mainPostPageInfo.getTotal());
		map.put("code", 0);
		map.put("msg", "�����ɹ�");
		map.put("count", mainPostPageInfo.getTotal());
		map.put("data", mainPostPageInfo.getList());//������ؼ��Ĵ��룬layui��table���Զ���ȡ����ʾ�����ݼ�
		return map;
	}	
	
	
	/***
	 * ǰ̨����չʾ
	 * @param model
	 * @return
	 */
	@RequestMapping("/getMainPostListUser")
	public String getMainPostListUser(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
	                   @RequestParam(value = "size",required = false,defaultValue = "10")int size,
	                   Model model){
	    //���ϲ�ѯ
	    PageInfo<MainPost> pageInfo = mainPostService.pageHelperList(page,size);
	    //�����ݴ��뵽Model��
	    model.addAttribute("pageInfo",pageInfo);
	    System.out.println("ǰ̨����controller");
	    return "/bbs_front/user_index";
	}
	

}
