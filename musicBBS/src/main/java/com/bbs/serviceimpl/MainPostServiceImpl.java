package com.bbs.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.MainPostDao;
import com.bbs.pojo.MainPost;
import com.bbs.service.MainPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("MainPostService")
public class MainPostServiceImpl implements MainPostService {
	
	//����Ҫset���������autowriteע���Ѿ���װ��
	//�������ͽ���
	@Autowired
	private MainPostDao mainPostDao;

	@Override
	public List<MainPost> getMainPostPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//pageΪ�����ѯ��ҳ�룬limitΪһҳ��ʾ����������
		List<MainPost> mainPostList = mainPostDao.getMainPostList();//PageHelper.startPage()���������Ӳ�ѯ���ݵķ���
		return mainPostList;		
	}

	@Override
	public List<MainPost> getMainPostListUser(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<MainPost> pageHelperList(Integer page, Integer size) {
		//1����̬��ҳ
	    PageHelper.startPage(page,size);
	    //2�����ϲ�ѯ
	    List<MainPost> mainPostList = mainPostDao.getMainPostList();
	    //3������PageInfo:�������ݽ����+��ҳ��Ϣ
	    return new PageInfo<MainPost>(mainPostList);
	}
	
	
    
	

}
