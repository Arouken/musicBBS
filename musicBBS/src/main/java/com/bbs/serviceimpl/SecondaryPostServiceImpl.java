package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.SecondaryPostDao;
import com.bbs.pojo.SecondaryPost;
import com.bbs.service.SecondaryPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service("SecondaryPostService")
public class SecondaryPostServiceImpl implements SecondaryPostService {
	
	@Autowired
	private SecondaryPostDao secondaryPostDao;


	//��������ID��ȡ���л�����Ϣ
	//��ѯ�������ӵĻ���
	@Override
	public PageInfo<SecondaryPost> getSecondaryPostList(Integer page, Integer size,int mainPostID) {
		// TODO Auto-generated method stub
		//1����̬��ҳ
	    PageHelper.startPage(page,size);
	    //2�����ϲ�ѯ
	    List<SecondaryPost> secondaryPostList = secondaryPostDao.getSecondaryPostList(mainPostID);
	    //3������PageInfo:�������ݽ����+��ҳ��Ϣ
	    return new PageInfo<SecondaryPost>(secondaryPostList);
		
	}


	//�ظ�����
	@Override
	public void addSecondaryPost(SecondaryPost secondaryPost) {
		// TODO Auto-generated method stub
		secondaryPostDao.addSecondaryPost(secondaryPost);
	}
	
	

}
