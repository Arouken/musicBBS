package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Music;
import com.github.pagehelper.PageInfo;

public interface MusicService {
	
	//�������
	public void addMusicSong(Music music);
	//��ѯ�����б�
	public List<Music> getMusicList();
	//ǰ̨��ѯ�����б�
	PageInfo<Music> getFrontMusicList(Integer page, Integer size);
	//��ѯ����������Ϣ
	public Music getOneMusic(int musicID);

}
