package com.bbs.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.Part;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.AbstractID3v2Frame;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.jaudiotagger.tag.id3.framebody.FrameBodyAPIC;
import org.springframework.web.multipart.MultipartFile;

/**
 * �ϴ��ļ�������
 * @author admin
 *
 */
public class UploadTool {
	/**
	 * �ϴ�ͼƬ
	 */
	public static String uploadImg(MultipartFile multipartFile) {
		//����һ���ļ�����
		String photo="";
				/**
				 * �ļ��ϴ���
				 * 1����ȡ�����ϴ����ļ���part���󣨷�װ���ϴ����ļ���Ϣ��
				 * 2����ȡ�ϴ����ļ����ƣ������ļ����Ƶ����ݿ��
				 * 3�������ϴ����ļ���Ŀ���ַ��F:\\musicBBS\\userPhoto\\
				 * 
				 */
				try {
					//��ȡ�ϴ����ļ�����
					String submittedFileName = multipartFile.getOriginalFilename();
					//����ͬ���ļ����ǣ��Զ����ַ�+����������� random  math��
					//UUID���������:����32����ַ�
					String uuid = UUID.randomUUID().toString();
					//��ȡ�ļ���׺
					String type=submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
					//�������ļ���uuid+�ļ���׺
					photo=uuid+type;	
					//���ļ����浽Ŀ��Ŀ¼:Ŀ¼��ַ+�ļ�����
					String path="F:\\musicBBS\\userPhoto\\";
					File desFile = new File(path+photo);
					multipartFile.transferTo(desFile);//�����ļ�
					//part.write(path);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return photo;
		
	}
	
	//��ȡ������MP3�ļ�
	public static byte[] getMP3Image(String path) {
        byte[] imageData = null;
    	MP3File mp3File;
		try {
			mp3File = (MP3File) AudioFileIO.read(new File(path));
	        AbstractID3v2Tag tag = mp3File.getID3v2Tag();
	        AbstractID3v2Frame frame = (AbstractID3v2Frame) tag.getFrame("APIC");
	        FrameBodyAPIC body = (FrameBodyAPIC) frame.getBody();
	        imageData = body.getImageData();
	        
	        System.out.println("MP3����������ļ���"+imageData);
	        
		} catch (Exception e) {
			System.out.println("MP3Utils:��ȡMP3����ʧ�ܣ�");
			return null;
		}
        return imageData;
    }

	//����MP3�ļ�������
	 public static String saveMP3Image(String path) {
	        //����mp3ͼƬ·��
		    String uploadDocsImgPath = "F:\\musicBBS\\music\\img";
	        String musicImgID = UUID.randomUUID().toString();
	        String mp3ImageFullPath = uploadDocsImgPath + ("\\"+musicImgID+".jpg");
	        String musicImgName = musicImgID+".jpg";  	      
	        //����mp3���Ŀ¼
	        File saveDirectory = new File(uploadDocsImgPath);
	        saveDirectory.mkdirs();
	 
	        //��ȡmp3ͼƬ
	        byte imageData[];
			imageData = getMP3Image(path);
			if(imageData == null){
				System.out.println("MP3Utils:��ȡMP3����ʧ�ܣ�");	          
				return null;
			}
			
	        //��ͼƬ�����ڣ���ֱ�ӷ���null
	        if (null == imageData || imageData.length == 0) {
	            return null;
	        }
	        //����mp3ͼƬ�ļ�
	        FileOutputStream fos = null;
	        try {
	            fos = new FileOutputStream(mp3ImageFullPath);
	            fos.write(imageData);
	            System.out.println("����ɹ���");
	            fos.close();
	        } catch(Exception e) {
	        	System.out.println("MP3Utils:��ȡMP3����ʧ�ܣ�");
	        	return null;
	        }
	        return musicImgName;
	    }
	 
	 //��ӷ���ͼƬ
	 public static String addCategoryImg(MultipartFile multipartFile) {
			//����һ���ļ�����
			String photo="";
					/**
					 * �ļ��ϴ���
					 * 1����ȡ�����ϴ����ļ���part���󣨷�װ���ϴ����ļ���Ϣ��
					 * 2����ȡ�ϴ����ļ����ƣ������ļ����Ƶ����ݿ��
					 * 3�������ϴ����ļ���Ŀ���ַ��F:\\musicBBS\\userPhoto\\
					 * 
					 */
					try {
						//��ȡ�ϴ����ļ�����
						String submittedFileName = multipartFile.getOriginalFilename();
						//����ͬ���ļ����ǣ��Զ����ַ�+����������� random  math��
						//UUID���������:����32����ַ�
						String uuid = UUID.randomUUID().toString();
						//��ȡ�ļ���׺
						String type=submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
						//�������ļ���uuid+�ļ���׺
						photo=uuid+type;	
						//���ļ����浽Ŀ��Ŀ¼:Ŀ¼��ַ+�ļ�����
						String path="F:\\musicBBS\\categoryImg\\";
						File desFile = new File(path+photo);
						multipartFile.transferTo(desFile);//�����ļ�
						//part.write(path);
					} catch (Exception e) {
						e.printStackTrace();
					}
			
			return photo;
			
		}
}
