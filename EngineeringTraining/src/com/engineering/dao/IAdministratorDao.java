package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Administrator;

public interface IAdministratorDao {

	// ��ӹ���Ա
	public boolean addAdministrator(Administrator administrator);

	// ����Ϣ��ӵ����ձ�ͬʱɾ��������¼
	public boolean deleteAdministrator(String adminID);

	// �޸Ĺ���Ա��Ϣ
	public boolean updateAdministrator(String adminID, Administrator administrator);

	// ���ݹ���Ա��Ų�ѯ����Ա�Ƿ����
	public boolean isExist(String adminID);

	// ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	public Administrator queryAdministrator(String adminID);

	// ��ѯȫ������Ա��Ϣ(ͨ��List����)
	public List<Administrator> queryAllAdministrators();

}
