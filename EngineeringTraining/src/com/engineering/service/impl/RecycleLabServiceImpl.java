package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IRecycleLabDao;
import com.engineering.dao.impl.RecycleLabDaoImpl;
import com.engineering.entity.Lab;
import com.engineering.service.IRecycleLabService;

public class RecycleLabServiceImpl implements IRecycleLabService {

	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	IRecycleLabDao recycle = new RecycleLabDaoImpl();

	// ����ɾ��ʵ���ң����ݴ�����labID��
	public boolean deleteRecycleLab(String labID) {
		if (recycle.isExistRecycleLab(labID)) {
			return recycle.deleteRecycleLab(labID);
		} else {
			return false;
		}
	}

	// �ָ�ʵ����
	public boolean recoverLab(String labID) {
		if (!recycle.isExistLab(labID)) { // ��ѯʵ���ұ����Ƿ���ڸü�¼
			return recycle.recoverLab(labID);
		} else { // ����
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}

	// ��ѯ����վ�е�ʵ������Ϣ�����ݴ�����labID��
	public Lab queryRecycleLab(String labID) {
		return recycle.queryRecycleLab(labID);
	}

	// ��ѯ����վ��ȫ��ʵ������Ϣ(ͨ��List����)
	public List<Lab> queryAllRecycleLabs() {
		return recycle.queryAllRecycleLabs();
	}
}
