package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.MusicPost;

public interface MusicPostDao {
	
	//�����������
	public void addMusicPost(MusicPost musicPost);
	//��ѯ��������������
	public List<MusicPost> getOneMusicPostList(int musicID);

}
