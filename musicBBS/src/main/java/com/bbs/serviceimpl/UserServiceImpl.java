package com.bbs.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.UserDao;
import com.bbs.pojo.User;
import com.bbs.service.UserService;
import com.github.pagehelper.PageHelper;


@Service("UserService")
public class UserServiceImpl implements UserService {

	//����Ҫset���������autowriteע���Ѿ���װ��
	//�������ͽ���
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String userName, String password) {		
		return userDao.findUserInfoByCond(userName, password);
	}

	@Override
	public void regist(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public List<User> getUserPage(Integer page, Integer limit) {
		//ʹ��PageHelper.startPage��̬��������
		//startPage����ĵ�һ�������ݿ�����ķ��������Զ����з�ҳ��sql����������limit�ؼ���
		PageHelper.startPage(page, limit);//pageΪ�����ѯ��ҳ�룬limitΪһҳ��ʾ����������
		List<User> users = userDao.getUserList();//PageHelper.startPage()���������Ӳ�ѯ���ݵķ���
		return users;		
	}

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

}
