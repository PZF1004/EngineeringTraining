package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IRecycleEquipmentDao;
import com.engineering.dao.impl.RecycleEquipmentDaoImpl;
import com.engineering.entity.Equipment;
import com.engineering.service.IRecycleEquipmentService;

public class RecycleEquipmentServiceImpl implements IRecycleEquipmentService {

	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	IRecycleEquipmentDao recycle = new RecycleEquipmentDaoImpl();

	// �ӻ���վ�г���ɾ���豸��Ϣ
	public boolean deleteRecycleEquipment(String equipmentID) {
		if (recycle.isExistRecycleEquipment(equipmentID)) {
			return recycle.deleteRecycleEquipment(equipmentID);
		} else {
			return false;
		}
	}

	// �ӻ���վ�лָ��豸��Ϣ
	public boolean recoverEquipment(String equipmentID) {
		if (!recycle.isExistEquipment(equipmentID)) {
			return recycle.recoverEquipment(equipmentID);
		} else { // ����
			System.out.println("���豸�Ѵ��ڣ�");
			return false;
		}
	}

	// ��ѯ����վ���豸��Ϣ
	public Equipment queryRecycleEquipment(String equipmentID) {
		return recycle.queryRecycleEquipment(equipmentID);
	}

	// ��ѯȫ������վ���豸��Ϣ(ͨ��List����)
	public List<Equipment> queryAllRecycleEquipments() {
		return recycle.queryAllRecycleEquipments();
	}

}
