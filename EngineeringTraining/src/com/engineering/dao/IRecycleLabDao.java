package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Lab;

public interface IRecycleLabDao {
	// �ӻ���վ�г���ɾ��ʵ����
	public boolean deleteRecycleLab(String labID);

	// �ӻ���վ�лָ�ʵ����
	public boolean recoverLab(String labID);

	// ����ʵ���ұ�Ų�ѯʵ���ұ����Ƿ���ڸ�ʵ����
	public boolean isExistLab(String labID);

	// ����ʵ���ұ�Ų�ѯʵ���ұ����Ϣ
	public Lab queryLab(String labID);

	// ����ʵ���ұ�Ų�ѯ����վ���Ƿ���ڸ�ʵ����
	public boolean isExistRecycleLab(String labID);

	// ����ʵ���ұ�Ų�ѯ����վ��ʵ���ҵ���Ϣ
	public Lab queryRecycleLab(String labID);

	// ��ѯ����վ��ȫ��ʵ������Ϣ(ͨ��List����)
	public List<Lab> queryAllRecycleLabs();
}
