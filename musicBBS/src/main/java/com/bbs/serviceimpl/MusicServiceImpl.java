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
	
	//�������
	@Override
	public void addMusicSong(Music music) {
		// TODO Auto-generated method stub
		musicDao.addMusicSong(music);
	}

	//��ѯ�����б�
	@Override
	public PageInfo<Music> getFrontMusicList(Integer page, Integer size) {
		// TODO Auto-generated method stub
		//1����̬��ҳ
	    PageHelper.startPage(page,size);
	    //2�����ϲ�ѯ
	    List<Music> Music = musicDao.getMusicList();
	    //3������PageInfo:�������ݽ����+��ҳ��Ϣ
		return new PageInfo<Music>(Music);
	}

	//��̨�����б�
	@Override
	public List<Music> getMusicList() {
		// TODO Auto-generated method stub
		return null;
	}

	//��ѯ����������Ϣ
	@Override
	public Music getOneMusic(int musicID) {
		// TODO Auto-generated method stub
		
		return musicDao.getOneMusic(musicID);
	}

}
