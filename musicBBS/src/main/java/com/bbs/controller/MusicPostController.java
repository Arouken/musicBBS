package com.bbs.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bbs.pojo.Music;
import com.bbs.pojo.MusicPost;
import com.bbs.pojo.User;
import com.bbs.service.MusicPostService;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/MusicPost")
public class MusicPostController {
	
	@Autowired
	private MusicPostService musicPostService;
	//�����������
	@RequestMapping("/addMusicPost")
	public String addMusicPost(HttpSession session,RedirectAttributes attributes,
			@RequestParam("musicPostContent") String musicPostContent) {
		MusicPost musicPost = new MusicPost();
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		musicPost.setUserID(userID);
		//��ȡ�ظ�����ID
		Music music = (Music) session.getAttribute("music");
		int musicID = music.getMusicID();
		musicPost.setMusicID(musicID);
		//��ȡ�ظ�����
		musicPost.setMusicPostContent(musicPostContent);
		//��ȡ����ʱ��
		Date createDate = new Date();
		Timestamp musicPostTime = new Timestamp(createDate.getTime());
		musicPost.setMusicPostTime(musicPostTime);
		//��ȡ�ظ����������Ƕ����ֽ������ۣ�����ֵΪ��
		musicPost.setReplyUserID(null);
		//ִ�����۷���
		musicPostService.addMusicPost(musicPost);
		//��musicIDֵ������ѯ����
		attributes.addAttribute("musicID",musicID);
		return "redirect:/MusicPost/getMusicPost";
	}
	
	@RequestMapping("/addReMusicPost")
	public String addReMusicPost(HttpSession session,RedirectAttributes attributes,
			@RequestParam("musicPostContent") String musicPostContent,String replyUserID) {
		MusicPost musicPost = new MusicPost();
		//��ȡ��������id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		musicPost.setUserID(userID);
		//��ȡ�ظ�����ID
		Music music = (Music) session.getAttribute("music");
		int musicID = music.getMusicID();
		musicPost.setMusicID(musicID);
		//��ȡ�ظ�����
		musicPost.setMusicPostContent(musicPostContent);
		//��ȡ����ʱ��
		Date createDate = new Date();
		Timestamp musicPostTime = new Timestamp(createDate.getTime());
		musicPost.setMusicPostTime(musicPostTime);
		//��ȡ�ظ�����
		musicPost.setReplyUserID(replyUserID);
		//ִ�����۷���
		musicPostService.addMusicPost(musicPost);
		//��musicIDֵ������ѯ����
		attributes.addAttribute("musicID",musicID);
		return "redirect:/MusicPost/getMusicPost";
	}
	
	//��ѯ��������
	@RequestMapping("/getMusicPost")
	public String getMusicPost(Model model,int musicID,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "20")int size) {
		
		//���ϲ�ѯ
		PageInfo<MusicPost> oneMusicPost = musicPostService.getOneMusicPostList(page, size, musicID);
		//�洢��model
		model.addAttribute("oneMusicPost",oneMusicPost);
		
		return "/bbs_front/user_music_play";
	}

}
