package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.ILabDao;
import com.engineering.dao.impl.LabDaoImpl;
import com.engineering.entity.Lab;
import com.engineering.service.ILabService;

public class LabServiceImpl implements ILabService {
	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	ILabDao labdao = new LabDaoImpl();

	// ���ʵ����
	public boolean addLab(Lab lab) {
		if (!labdao.isExist(lab.getLabID())) { // ����������÷�������
			return labdao.addLab(lab); // ���ӣ�����Dao�㽫�ɹ���Ϣ���ظ�service
		} else { // ����
			System.out.println("��ʵ�����Ѵ��ڣ�");
			return false;
		}
	}

	// ɾ��ʵ���ң����ݴ�����labID��
	public boolean deleteLab(String labID) {
		if (labdao.isExist(labID)) {
			return labdao.deleteLab(labID);
		} else {
			return false;
		}
	}

	// �޸�ʵ������Ϣ��Ϣ�����ݴ�����labID��
	public boolean updateLab(String labID, Lab lab) {
		return labdao.updateLab(labID, lab);
	}

	// ��ѯʵ������Ϣ�����ݴ�����labID��
	public Lab queryLab(String labID) {
		return labdao.queryLab(labID);
	}

	// ��ѯȫ��ʵ������Ϣ(ͨ��List����)
	public List<Lab> queryAllLabs() {
		return labdao.queryAllLabs();
	}

}
