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
	//添加音乐评论
	@RequestMapping("/addMusicPost")
	public String addMusicPost(HttpSession session,RedirectAttributes attributes,
			@RequestParam("musicPostContent") String musicPostContent) {
		MusicPost musicPost = new MusicPost();
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		musicPost.setUserID(userID);
		//获取回复音乐ID
		Music music = (Music) session.getAttribute("music");
		int musicID = music.getMusicID();
		musicPost.setMusicID(musicID);
		//获取回复内容
		musicPost.setMusicPostContent(musicPostContent);
		//获取发布时间
		Date createDate = new Date();
		Timestamp musicPostTime = new Timestamp(createDate.getTime());
		musicPost.setMusicPostTime(musicPostTime);
		//获取回复对象，这里是对音乐进行评论，所以值为空
		musicPost.setReplyUserID(null);
		//执行评论方法
		musicPostService.addMusicPost(musicPost);
		//把musicID值传给查询方法
		attributes.addAttribute("musicID",musicID);
		return "redirect:/MusicPost/getMusicPost";
	}
	
	@RequestMapping("/addReMusicPost")
	public String addReMusicPost(HttpSession session,RedirectAttributes attributes,
			@RequestParam("musicPostContent") String musicPostContent,String replyUserID) {
		MusicPost musicPost = new MusicPost();
		//获取发布对象id
		User user = (User) session.getAttribute("userSession");
		String userID = user.getUserID();
		musicPost.setUserID(userID);
		//获取回复音乐ID
		Music music = (Music) session.getAttribute("music");
		int musicID = music.getMusicID();
		musicPost.setMusicID(musicID);
		//获取回复内容
		musicPost.setMusicPostContent(musicPostContent);
		//获取发布时间
		Date createDate = new Date();
		Timestamp musicPostTime = new Timestamp(createDate.getTime());
		musicPost.setMusicPostTime(musicPostTime);
		//获取回复对象
		musicPost.setReplyUserID(replyUserID);
		//执行评论方法
		musicPostService.addMusicPost(musicPost);
		//把musicID值传给查询方法
		attributes.addAttribute("musicID",musicID);
		return "redirect:/MusicPost/getMusicPost";
	}
	
	//查询音乐评论
	@RequestMapping("/getMusicPost")
	public String getMusicPost(Model model,int musicID,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "20")int size) {
		
		//集合查询
		PageInfo<MusicPost> oneMusicPost = musicPostService.getOneMusicPostList(page, size, musicID);
		//存储到model
		model.addAttribute("oneMusicPost",oneMusicPost);
		
		return "/bbs_front/user_music_play";
	}

}
