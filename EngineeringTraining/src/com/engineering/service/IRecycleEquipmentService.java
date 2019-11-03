package com.engineering.service;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IRecycleEquipmentService {
	// �ӻ���վ�г���ɾ���豸��Ϣ
	public boolean deleteRecycleEquipment(String equipmentID);

	// �ӻ���վ�лָ��豸��Ϣ
	public boolean recoverEquipment(String equipmentID);

	// ��ѯ����վ���豸��Ϣ
	public Equipment queryRecycleEquipment(String equipmentID);

	// ��ѯȫ������վ���豸��Ϣ(ͨ��List����)
	public List<Equipment> queryAllRecycleEquipments();
}
