package com.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.bbs.pojo.Music;
import com.bbs.pojo.User;
import com.bbs.service.MusicService;
import com.bbs.utils.UploadTool;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/Music")
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
	//��Ӹ���
	@RequestMapping("/song")
	@ResponseBody
	public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
		Map<String, Object> uploadData = new HashMap<String, Object>();
		String uploadDocsPath = "F:\\musicBBS\\music\\";
		for (int i = 0; i < files.length; i++) {
			MultipartFile multipartFile = files[i];
			//UUID���������:����32����ַ�
			String songOtherName = UUID.randomUUID().toString()+".mp3";
			
			//String fileName =files[i].getOriginalFilename();
			String fileName = songOtherName;
			String fileAdress = uploadDocsPath+fileName;
			
			
	        File musicFile = new File(fileAdress);
	        multipartFile.transferTo(musicFile);//�����ļ�
			System.out.println(files[i].getOriginalFilename()+"  �ѱ���");
			
			//Music mp3Info = null;
            try {
				MP3File mp3File = (MP3File) AudioFileIO.read(new File(fileAdress));
				//��ȡͷ
	            MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();	 
	            //����
	            ID3v23Frame songnameFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TIT2");
	            String songName = songnameFrame.getContent();
	            //����
	            ID3v23Frame artistFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TPE1");
	            String artist = artistFrame.getContent();
	            //ר��
	            ID3v23Frame albumFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TALB");
	            String album = albumFrame.getContent();
	             //���������ͼƬ
	            String musicImgName = UploadTool.saveMP3Image(fileAdress);
	            //���浽���ݿ�
	            Music music = new Music();
	            music.setMusicName(songName);
	            music.setSinger(artist);
	            music.setAlbum(album);
	            music.setMusicOtherName(songOtherName);
	            music.setMusicImgName(musicImgName);
	            musicService.addMusicSong(music);

			} catch (CannotReadException | IOException | TagException | ReadOnlyFileException
					| InvalidAudioFrameException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		uploadData.put("code", 0);
        uploadData.put("msg", "�ϴ��ɹ�");
        uploadData.put("data", "");
        return uploadData;
	}
	
	//ǰ̨������ʾ
	@RequestMapping("/getMusicList")
	public String getMusicList(Model model,
			@RequestParam(value = "page",required = false,defaultValue = "1")int page,
			@RequestParam(value = "size",required = false,defaultValue = "10")int size) {
		
		//���ϲ�ѯ
	    PageInfo<Music> musicList = musicService.getFrontMusicList(page, size);
	    //�����ݴ��뵽Model��
	    model.addAttribute("musicList",musicList);
		
		return "/bbs_front/user_music";
	}
	
	//��̨��ʾ����
	@ResponseBody // �Զ�����json��ʽ������
	@RequestMapping("/getBackMusicList")
	public Map<String, Object> getPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
		// page��limit��������layui��table���Ĭ���Զ����ݵģ�����ֻ����ռ���
		Map<String, Object> map = new HashMap<String, Object>();
		List<Music> list = musicService.getMuiscPage(page, limit);// ִ�з�ҳ��ѯ�ķ���
		PageInfo<Music> musicPageInfo = new PageInfo<Music>(list);
		// System.out.println("list������Ϊ��" + list.get(2));
		System.out.println("pageInfo������Ϊ��" + musicPageInfo.getTotal());
		map.put("code", 0);
		map.put("msg", "�����ɹ�");
		map.put("count", musicPageInfo.getTotal());
		map.put("data", musicPageInfo.getList());// layui��table���Զ���ȡ����ʾ�����ݼ�
		return map;
	}
	
	
	//����������֣���������ҳ
	@RequestMapping("/getMusicContent")
	public String getMusicContent(HttpSession session,RedirectAttributes attributes,
			Model model,int musicID) {
		Music music =  musicService.getOneMusic(musicID);
		//model.addAttribute("music", music);
		session.setAttribute("music", music);
		attributes.addAttribute("musicID", musicID); 
		return "redirect:/MusicPost/getMusicPost";
	}
	
	//ɾ������
	@RequestMapping("/deleteMusic")
	@ResponseBody
	public String deleteMusic(@RequestParam("musicID")int musicID) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "1");
		try {
			musicService.deleteMusic(musicID);
			jsonObject.put("result", "1");
		} catch (Exception e) {
			jsonObject.put("result", "0");
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		return jsonObject.toString();	
	}
	
	//��ѯ����
	
	
	//�޸�����
	

	 
}
	
	
	

