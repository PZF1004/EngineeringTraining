package com.engineering.service;

import java.util.List;

import com.engineering.entity.Lab;

public interface ILabService {

	// ���ʵ����
	public boolean addLab(Lab lab);

	// ɾ��ʵ���ң����ݴ�����labID��
	public boolean deleteLab(String labID);

	// �޸�ʵ������Ϣ��Ϣ�����ݴ�����labID��
	public boolean updateLab(String labID, Lab lab);

	// ��ѯʵ������Ϣ�����ݴ�����labID��
	public Lab queryLab(String labID);

	// ��ѯȫ��ʵ������Ϣ(ͨ��List����)
	public List<Lab> queryAllLabs();
}
