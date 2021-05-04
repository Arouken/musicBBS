package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.Music;

public interface MusicDao {
	
	//添加音乐
	public void addMusicSong(Music music);
	//查询音乐列表
	public List<Music> getMusicList();
	//查询单个歌曲信息
	public Music getOneMusic(int musicID);

}
