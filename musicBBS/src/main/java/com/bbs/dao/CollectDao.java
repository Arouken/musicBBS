package com.bbs.dao;

import com.bbs.pojo.Collect;

public interface CollectDao {
	
	//�ղ�
	public void collectPost(Collect collect);
	//ȡ���ղ�
	public void disCollectPost(Collect collect);
	//��ѯ�Ƿ��ղ�
	public Collect selectCollectPost(Collect collect);

}
