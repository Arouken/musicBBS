package com.bbs.dao;

import java.util.List;

import com.bbs.pojo.MusicPost;

public interface MusicPostDao {
	
	//添加音乐评论
	public void addMusicPost(MusicPost musicPost);
	//查询单个歌曲的评论
	public List<MusicPost> getOneMusicPostList(int musicID);

}
