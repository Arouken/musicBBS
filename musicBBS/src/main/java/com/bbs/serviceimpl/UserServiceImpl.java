package com.bbs.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.UserDao;
import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.bbs.utils.SendSms;
import com.github.pagehelper.PageHelper;


@Service("UserService")
public class UserServiceImpl implements UserService {

	//����Ҫset���������autowriteע���Ѿ���װ��
	//�������ͽ���
	@Autowired
	private UserDao userDao;

	//��½
	@Override
	public User login(String userID, String password) {		
		return userDao.findUserInfoByCond(userID, password);
	}
	
	//�û�ע��ʱ���ID�Ƿ��ظ�
	@Override
	public User idIsExist(String userID) {
			
		return userDao.findUser(userID);
	}

	//ע��
	@Override
	public void regist(User user) {		
		userDao.addUser(user);
	}

	//�û���ҳ
	@Override
	public List<User> getUserPage(Integer page, Integer limit) {
		//ʹ��PageHelper.startPage��̬��������
		//startPage����ĵ�һ�������ݿ�����ķ��������Զ����з�ҳ��sql����������limit�ؼ���
		PageHelper.startPage(page, limit);//pageΪ�����ѯ��ҳ�룬limitΪһҳ��ʾ����������
		List<User> user = userDao.getUserList();//PageHelper.startPage()���������Ӳ�ѯ���ݵķ���
		return user;		
	}

	
	//��֤��Ƚ�
	@Override
	public int checkImgCode(String code, HttpSession session) {
		System.out.println("��ʼ�Ƚ�");
		// ��ȡϵͳ���ɵ���֤��
		String verifyCode=(String) session.getAttribute("verifyCode");
		System.out.println("���ɵģ�"+verifyCode);
		System.out.println("����ģ�"+code);
		//�Ƚ�ϵͳ���ɵ���֤��ͱ��������֤���Ƿ�һ��(���Դ�С����)
		if (verifyCode.equalsIgnoreCase(code)) {
		//��֤����ȷ
			System.out.println("��֤����ȷ");
			return 1;
		}
		//��֤�����
		System.out.println("��֤�����");
		return 0;
	}
	
    //�û��޸�ͷ��
	@Override
	public void uploadUserPhoto(String userID, String photo) {
		
		userDao.uploadUserPhoto(userID,photo);		
	}
    //�û��޸�����
	@Override
	public void updateUserPassword(String userID, String password) {
		// TODO Auto-generated method stub	
		userDao.updateUserPassword(userID, password);
	}

	//��������
	@Override
	public User checkOldPassword(String userID, String password) {
		// TODO Auto-generated method stub
		return userDao.findUserInfoByCond(userID, password);		
	}

	//���û�������֤��
	@Override
	public String sendPhoneCode(String phone) {
		// TODO Auto-generated method stub
		int code = SendSms.sendCode(phone);
		if(code>0) {
			String oldCode=phone+"#"+code;
			return oldCode;
		}else {
			return null;
		}
		
	}

	//����ֻ����Ƿ��
	@Override
	public User checkPhoneIsExit(String phone) {
		
		
		return userDao.findUserByPhone(phone);
		// TODO Auto-generated method stub
		
	}	

}
