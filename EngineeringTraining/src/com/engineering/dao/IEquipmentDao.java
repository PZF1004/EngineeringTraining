package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IEquipmentDao {

	// ����豸
	public boolean addEquipment(Equipment equipment);

	// ����Ϣ��ӵ����ձ�ͬʱɾ��������¼
	public boolean deleteEquipment(String equipmentID);

	// �޸��豸��Ϣ
	public boolean updateEquipment(String no, Equipment equipment);

	// �����豸�Ų�ѯ�豸�Ƿ����
	public boolean isExist(String equipmentID);

	// �����豸�Ų�ѯ�豸��Ϣ
	public Equipment queryEquipment(String equipmentID);

	// ��ѯȫ���豸��Ϣ(ͨ��List����)
	public List<Equipment> queryAllEquipments();

}
