package com.bbs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.MusicDao;
import com.bbs.pojo.MainPost;
import com.bbs.pojo.Music;
import com.bbs.service.MusicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service("MusicService")
public class MusicServiceImpl implements MusicService {

	@Autowired
	private MusicDao musicDao;
	
	//添加音乐
	@Override
	public void addMusicSong(Music music) {
		// TODO Auto-generated method stub
		musicDao.addMusicSong(music);
	}

	//查询音乐列表
	@Override
	public PageInfo<Music> getFrontMusicList(Integer page, Integer size) {
		// TODO Auto-generated method stub
		//1）静态分页
	    PageHelper.startPage(page,size);
	    //2）集合查询
	    List<Music> Music = musicDao.getMusicList();
	    //3）返回PageInfo:包含数据结果集+分页信息
		return new PageInfo<Music>(Music);
	}

	//后台音乐列表
	@Override
	public List<Music> getMusicList() {
		// TODO Auto-generated method stub
		return null;
	}

	//查询单个歌曲信息
	@Override
	public Music getOneMusic(int musicID) {
		// TODO Auto-generated method stub
		
		return musicDao.getOneMusic(musicID);
	}

}
