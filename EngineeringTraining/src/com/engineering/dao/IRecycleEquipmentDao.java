package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IRecycleEquipmentDao {

	// �ӻ���վ�г���ɾ���豸��Ϣ
	public boolean deleteRecycleEquipment(String equipmentID);

	// �ӻ���վ�лָ��豸��Ϣ
	public boolean recoverEquipment(String equipmentID);

	// �����豸��Ų�ѯ�豸�����Ƿ���ڸ���Ϣ
	public boolean isExistEquipment(String equipmentID);

	// �����豸��Ų�ѯ�豸���е���Ϣ
	public Equipment queryEquipment(String equipmentID);

	// �����豸��Ų�ѯ����վ���Ƿ���ڸ���Ϣ
	public boolean isExistRecycleEquipment(String equipmentID);

	// �����豸��Ų�ѯ����վ�е��豸��Ϣ
	public Equipment queryRecycleEquipment(String equipmentID);

	// ��ѯ����վ�е�ȫ���豸��Ϣ(ͨ��List����)
	public List<Equipment> queryAllRecycleEquipments();

}
