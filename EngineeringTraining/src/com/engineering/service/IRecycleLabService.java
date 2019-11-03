package com.engineering.service;

import java.util.List;

import com.engineering.entity.Lab;

public interface IRecycleLabService {
	// ����ɾ��ʵ���ң����ݴ�����labID��
	public boolean deleteRecycleLab(String labID);

	// �ָ�ʵ����
	public boolean recoverLab(String labID);

	// ��ѯ����վ�е�ʵ������Ϣ�����ݴ�����labID��
	public Lab queryRecycleLab(String labID);

	// ��ѯ����վ��ȫ��ʵ������Ϣ(ͨ��List����)
	public List<Lab> queryAllRecycleLabs();
}
