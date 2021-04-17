package com.bbs.service;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;
import com.github.pagehelper.PageInfo;

public interface MainPostService {
	
	//��̨��ѯ�����б�
	public List<MainPost> getMainPostPage(Integer page, Integer limit);	
	//�û���ҳչʾ����1
	public List<MainPost> getMainPostListUser(Map<String,Integer> map);
	//�û���ҳչʾ����2
	public PageInfo<MainPost> pageHelperList(Integer page,Integer size);

}
