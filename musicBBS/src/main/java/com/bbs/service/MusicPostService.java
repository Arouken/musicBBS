package com.bbs.service;

import java.util.List;

import com.bbs.pojo.MusicPost;
import com.github.pagehelper.PageInfo;

public interface MusicPostService {
	
	//�����������
	public void addMusicPost(MusicPost musicPost);
	//��ѯ��������������
	public PageInfo<MusicPost> getOneMusicPostList(Integer page, Integer size,int musicID);

}
