package com.bbs.service;

import java.util.List;
import java.util.Map;

import com.bbs.pojo.MainPost;
import com.github.pagehelper.PageInfo;

public interface MainPostService {
	
	//��̨��ѯ�����б�
	public List<MainPost> getMainPostPage(Integer page, Integer limit);	
		
	//��½ʱ��ʼ��10������
	PageInfo<MainPost> userPostInit(Integer page, Integer size);
	
	//�û���ҳչʾ����
	PageInfo<MainPost> pageHelperList(Integer page, Integer size);
    //��������
	public void addMainPost(MainPost mainpost);
	

}
