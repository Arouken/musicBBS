package com.bbs.service;

import java.util.List;

import com.bbs.pojo.MusicPost;
import com.github.pagehelper.PageInfo;

public interface MusicPostService {
	
	//添加音乐评论
	public void addMusicPost(MusicPost musicPost);
	//查询单个歌曲的评论
	public PageInfo<MusicPost> getOneMusicPostList(Integer page, Integer size,int musicID);

}
