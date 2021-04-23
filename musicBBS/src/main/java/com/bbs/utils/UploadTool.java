package com.bbs.utils;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.Part;

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

}
