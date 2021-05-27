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
 * 上传文件工具类
 * @author admin
 *
 */
public class UploadTool {
	/**
	 * 上传图片
	 */
	public static String uploadImg(MultipartFile multipartFile) {
		//定义一个文件名称
		String photo="";
				/**
				 * 文件上传：
				 * 1、获取表单中上传的文件：part对象（封装了上传的文件信息）
				 * 2、获取上传的文件名称：保存文件名称到数据库表
				 * 3、保存上传的文件到目标地址：F:\\musicBBS\\userPhoto\\
				 * 
				 */
				try {
					//获取上传的文件名称
					String submittedFileName = multipartFile.getOriginalFilename();
					//避免同名文件覆盖：自定义字符+随机数（日期 random  math）
					//UUID生成随机数:生成32随机字符
					String uuid = UUID.randomUUID().toString();
					//获取文件后缀
					String type=submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
					//重命名文件：uuid+文件后缀
					photo=uuid+type;	
					//将文件保存到目标目录:目录地址+文件名称
					String path="F:\\musicBBS\\userPhoto\\";
					File desFile = new File(path+photo);
					multipartFile.transferTo(desFile);//保存文件
					//part.write(path);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return photo;
		
	}
	
	//获取二进制MP3文件
	public static byte[] getMP3Image(String path) {
        byte[] imageData = null;
    	MP3File mp3File;
		try {
			mp3File = (MP3File) AudioFileIO.read(new File(path));
	        AbstractID3v2Tag tag = mp3File.getID3v2Tag();
	        AbstractID3v2Frame frame = (AbstractID3v2Frame) tag.getFrame("APIC");
	        FrameBodyAPIC body = (FrameBodyAPIC) frame.getBody();
	        imageData = body.getImageData();
	        
	        System.out.println("MP3封面二进制文件："+imageData);
	        
		} catch (Exception e) {
			System.out.println("MP3Utils:读取MP3封面失败！");
			return null;
		}
        return imageData;
    }

	//保存MP3文件并改名
	 public static String saveMP3Image(String path) {
	        //生成mp3图片路径
		    String uploadDocsImgPath = "F:\\musicBBS\\music\\img";
	        String musicImgID = UUID.randomUUID().toString();
	        String mp3ImageFullPath = uploadDocsImgPath + ("\\"+musicImgID+".jpg");
	        String musicImgName = musicImgID+".jpg";  	      
	        //生成mp3存放目录
	        File saveDirectory = new File(uploadDocsImgPath);
	        saveDirectory.mkdirs();
	 
	        //获取mp3图片
	        byte imageData[];
			imageData = getMP3Image(path);
			if(imageData == null){
				System.out.println("MP3Utils:读取MP3封面失败！");	          
				return null;
			}
			
	        //若图片不存在，则直接返回null
	        if (null == imageData || imageData.length == 0) {
	            return null;
	        }
	        //保存mp3图片文件
	        FileOutputStream fos = null;
	        try {
	            fos = new FileOutputStream(mp3ImageFullPath);
	            fos.write(imageData);
	            System.out.println("保存成功！");
	            fos.close();
	        } catch(Exception e) {
	        	System.out.println("MP3Utils:读取MP3封面失败！");
	        	return null;
	        }
	        return musicImgName;
	    }
	 
	 //添加分区图片
	 public static String addCategoryImg(MultipartFile multipartFile) {
			//定义一个文件名称
			String photo="";
					/**
					 * 文件上传：
					 * 1、获取表单中上传的文件：part对象（封装了上传的文件信息）
					 * 2、获取上传的文件名称：保存文件名称到数据库表
					 * 3、保存上传的文件到目标地址：F:\\musicBBS\\userPhoto\\
					 * 
					 */
					try {
						//获取上传的文件名称
						String submittedFileName = multipartFile.getOriginalFilename();
						//避免同名文件覆盖：自定义字符+随机数（日期 random  math）
						//UUID生成随机数:生成32随机字符
						String uuid = UUID.randomUUID().toString();
						//获取文件后缀
						String type=submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
						//重命名文件：uuid+文件后缀
						photo=uuid+type;	
						//将文件保存到目标目录:目录地址+文件名称
						String path="F:\\musicBBS\\categoryImg\\";
						File desFile = new File(path+photo);
						multipartFile.transferTo(desFile);//保存文件
						//part.write(path);
					} catch (Exception e) {
						e.printStackTrace();
					}
			
			return photo;
			
		}
}
