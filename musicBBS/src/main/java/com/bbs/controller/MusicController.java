package com.bbs.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v23Frame;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbs.utils.UploadTool;

@Controller
@RequestMapping("/Music")
public class MusicController {
	
	@RequestMapping("/song")
	@ResponseBody
	public Map<String,Object> uploadFile(@RequestParam("file") MultipartFile[] files) throws IllegalStateException, IOException {
		Map<String, Object> uploadData = new HashMap<String, Object>();
		String uploadDocsPath = "F:\\musicBBS\\music\\test\\";
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
	            
	            System.out.println(audioHeader);
	            System.out.println(songName);
	            System.out.println(artist);
	            System.out.println(album);
	            //���������ͼƬ
	            UploadTool.saveMP3Image(fileAdress);
	            //getMP3Image(fileAdress);
	            

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
	
	
	
	 
	 
	 
}
	
	
	

