package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IEquipmentDao;
import com.engineering.dao.impl.EquipmentDaoImpl;
import com.engineering.entity.Equipment;
import com.engineering.service.IEquipmentService;

public class EquipmentServiceImpl implements IEquipmentService {
	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	IEquipmentDao equipmentdao = new EquipmentDaoImpl();

	// ����豸��Ϣ
	public boolean addEquipment(Equipment equipment) {
		if (!equipmentdao.isExist(equipment.getEquipmentID())) { // ����������÷�������
			return equipmentdao.addEquipment(equipment);
		} else {
			System.out.println("���豸�Ѵ��ڣ�");
			return false;
		}
	}

	// ɾ���豸��Ϣ�����ݴ�����equipmentID��
	public boolean deleteEquipment(String equipmentID) {
		if (equipmentdao.isExist(equipmentID)) {
			return equipmentdao.deleteEquipment(equipmentID);
		} else {
			return false;
		}
	}

	// �޸��豸��Ϣ�����ݴ�����equipmentID��
	public boolean updateEquipment(String no, Equipment equipment) {
		if (equipmentdao.isExist(no)) {
			return equipmentdao.updateEquipment(no, equipment);
		} else {
			return false;
		}
	}

	// ��ѯ�豸��Ϣ�����ݴ�����equipment��
	public Equipment queryEquipment(String equipmentID) {
		return equipmentdao.queryEquipment(equipmentID);
	}

	// ��ѯȫ���豸��Ϣ(ͨ��List����)
	public List<Equipment> queryAllEquipments() {
		return equipmentdao.queryAllEquipments();
	}

}
