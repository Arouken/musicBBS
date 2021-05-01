package com.bbs.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.dao.CollectDao;
import com.bbs.pojo.Collect;
import com.bbs.service.CollectService;

@Service("CollectService")
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectDao collectDao;
	
	//�ղ�
	@Override
	public void collectPost(Collect collect) {
		// TODO Auto-generated method stub
		collectDao.collectPost(collect);
	}

	//ȡ���ղ�
	@Override
	public void disCollectPost(Collect collect) {
		// TODO Auto-generated method stub
		collectDao.disCollectPost(collect);
	}

	//��ѯ�Ƿ��ղ�
	@Override
	public Collect selectCollectPost(Collect collect) {
		// TODO Auto-generated method stub
		return collectDao.selectCollectPost(collect);
	}

}
