package com.bbs.service;

import com.bbs.pojo.Collect;

public interface CollectService {
	
	//�ղ�
	public void collectPost(Collect collect);
	//ȡ���ղ�
	public void disCollectPost(Collect collect);
	//��ѯ�Ƿ��ղ�
	public Collect selectCollectPost(Collect collect);

}
