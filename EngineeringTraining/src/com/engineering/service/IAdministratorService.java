package com.engineering.service;

import java.util.List;

import com.engineering.entity.Administrator;

public interface IAdministratorService {

	// ����Աע��
	public boolean addAdministrator(Administrator administrator);

	// ɾ������Ա��Ϣ�����ݴ�����adminID��
	public boolean deleteAdministrator(String adminID);

	// �޸Ĺ���Ա��Ϣ�����ݴ�����adminID��
	public boolean updateAdministrator(String adminID, Administrator administrator);

	// ��ѯ����Ա��Ϣ�����ݴ�����adminID��
	public Administrator queryAdministrator(String adminID);

	// ��ѯȫ������Ա��Ϣ(ͨ��List����)
	public List<Administrator> queryAllAdministrators();
}
