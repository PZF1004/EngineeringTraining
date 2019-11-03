package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Lab;

public interface ILabDao {

	// ���ʵ����
	public boolean addLab(Lab lab);

	// ��ʵ������Ϣ��ӵ����ձ�ͬʱɾ��������¼
	public boolean deleteLab(String labID);

	// �޸�ʵ������Ϣ
	public boolean updateLab(String labID, Lab lab);

	// ����ʵ���ұ�Ų�ѯʵ�����Ƿ����
	public boolean isExist(String labID);

	// ����ѧ�Ų�ѯѧ����Ϣ
	public Lab queryLab(String labID);

	// ��ѯȫ������(ͨ��List����)
	public List<Lab> queryAllLabs();
}
