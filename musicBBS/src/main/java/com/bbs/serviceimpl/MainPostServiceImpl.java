package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.MainPostDao;
import com.bbs.pojo.MainPost;
import com.bbs.service.MainPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("MainPostService")
public class MainPostServiceImpl implements MainPostService {
	
	//��̨չʾ����
	//�������ͽ��У�����Ҫset���������autowriteע���Ѿ���װ��
	@Autowired
	private MainPostDao mainPostDao;

	@Override
	public List<MainPost> getMainPostPage(Integer page, Integer limit) {
		PageHelper.startPage(page, limit);//pageΪ�����ѯ��ҳ�룬limitΪһҳ��ʾ����������
		List<MainPost> mainPostList = mainPostDao.getMainPostList();//PageHelper.startPage()���������Ӳ�ѯ���ݵķ���
		return mainPostList;		
	}

    //ǰ̨չʾ����
	@Override
	public PageInfo<MainPost> pageHelperList(Integer page, Integer size) {
		//1����̬��ҳ
	    PageHelper.startPage(page,size);
	    //2�����ϲ�ѯ
	    List<MainPost> mainPostList = mainPostDao.getMainPostList();
	    //3������PageInfo:�������ݽ����+��ҳ��Ϣ
	    return new PageInfo<MainPost>(mainPostList);
	}
	

	//��������
	@Override
	public void addMainPost(MainPost mainpost) {
		mainPostDao.addMainPost(mainpost);
	}

	//��ѯ����������Ϣ
	@Override
	public MainPost getOneMainPost(int mainPostID) {
		MainPost mainpost = mainPostDao.getOneMainPost(mainPostID);
		return mainpost;
	}

	//���޼�һ
	@Override
	public void addLikeCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addLikeCount(mainPostID);
	}

	//������һ
	@Override
	public void deleteLikeCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteLikeCount(mainPostID);
	}
	
	//�ղؼ�һ
	@Override
	public void addCollectCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addCollectCount(mainPostID);
	}

	//�ղؼ�һ
	@Override
	public void deleteCollectCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteCollectCount(mainPostID);
	}

	//��ѯר������
	@Override
	public PageInfo<MainPost> getCategoryPostList(Integer page, Integer size, String categoryName) {
		// TODO Auto-generated method stub
		//1����̬��ҳ
	    PageHelper.startPage(page,size);
	    //2�����ϲ�ѯ
	    List<MainPost> mainPostList = mainPostDao.getCategoryPostList(categoryName);
	    //3������PageInfo:�������ݽ����+��ҳ��Ϣ
	    return new PageInfo<MainPost>(mainPostList);
		
	}

	//�ٱ���+1
	@Override
	public void addReportCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addReportCount(mainPostID);
	}
	//�ٱ���-1
	@Override
	public void deleteReportCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteReportCount(mainPostID);
	}
	//�ظ���
	@Override
	public void addReplyCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.addReplyCount(mainPostID);
	}
	//�ظ���
	@Override
	public void deleteReplyCount(int mainPostID) {
		// TODO Auto-generated method stub
		mainPostDao.deleteReplyCount(mainPostID);
	} 
	
	
	

}
