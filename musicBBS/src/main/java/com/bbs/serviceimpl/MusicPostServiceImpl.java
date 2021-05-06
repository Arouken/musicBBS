package com.bbs.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.MusicPostDao;
import com.bbs.pojo.MusicPost;
import com.bbs.service.MusicPostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service("MusicPostService")
public class MusicPostServiceImpl implements MusicPostService {

	@Autowired
	private MusicPostDao musicPostDao;
	
	//�����������
	@Override
	public void addMusicPost(MusicPost musicPost) {
		// TODO Auto-generated method stub
		musicPostDao.addMusicPost(musicPost);
	}
	//��ѯ������������
	@Override
	public PageInfo<MusicPost> getOneMusicPostList(Integer page, Integer size, int musicID) {
		// TODO Auto-generated method stub
		//1����̬��ҳ
	    PageHelper.startPage(page,size);
	    //2�����ϲ�ѯ
	    List<MusicPost> oneMusicPostList = musicPostDao.getOneMusicPostList(musicID);
		return new PageInfo<MusicPost>(oneMusicPostList);
	}

	

}
