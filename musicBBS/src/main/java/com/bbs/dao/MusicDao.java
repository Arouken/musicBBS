package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.Music;

public interface MusicDao {
	
	//�������
	public void addMusicSong(Music music);
	//��ѯ�����б�
	public List<Music> getMusicList();
	//��ѯ����������Ϣ
	public Music getOneMusic(int musicID);

}
