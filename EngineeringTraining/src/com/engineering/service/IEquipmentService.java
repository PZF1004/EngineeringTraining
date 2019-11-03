package com.engineering.service;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IEquipmentService {

	// ����豸��Ϣ
	public boolean addEquipment(Equipment equipment);

	// ɾ���豸��Ϣ�����ݴ�����equipmentID��
	public boolean deleteEquipment(String equipmentID);

	// �޸��豸��Ϣ�����ݴ�����equipmentID��
	public boolean updateEquipment(String no, Equipment equipment);

	// ��ѯ�豸��Ϣ�����ݴ�����equipment��
	public Equipment queryEquipment(String equipmentID);

	// ��ѯȫ���豸��Ϣ(ͨ��List����)
	public List<Equipment> queryAllEquipments();

}
