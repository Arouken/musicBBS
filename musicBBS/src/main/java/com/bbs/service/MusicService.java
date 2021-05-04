package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Music;
import com.github.pagehelper.PageInfo;

public interface MusicService {
	
	//添加音乐
	public void addMusicSong(Music music);
	//查询音乐列表
	public List<Music> getMusicList();
	//前台查询音乐列表
	PageInfo<Music> getFrontMusicList(Integer page, Integer size);
	//查询单个歌曲信息
	public Music getOneMusic(int musicID);

}
