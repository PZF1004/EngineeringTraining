package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IEquipmentDao;
import com.engineering.dao.impl.EquipmentDaoImpl;
import com.engineering.entity.Equipment;
import com.engineering.service.IEquipmentService;

public class EquipmentServiceImpl implements IEquipmentService {
	// Service中调用Dao(多态：接口 xxx = new 实现类)
	IEquipmentDao equipmentdao = new EquipmentDaoImpl();

	// 添加设备信息
	public boolean addEquipment(Equipment equipment) {
		if (!equipmentdao.isExist(equipment.getEquipmentID())) { // 不存在则调用方法增加
			return equipmentdao.addEquipment(equipment);
		} else {
			System.out.println("此设备已存在！");
			return false;
		}
	}

	// 删除设备信息（根据传来的equipmentID）
	public boolean deleteEquipment(String equipmentID) {
		if (equipmentdao.isExist(equipmentID)) {
			return equipmentdao.deleteEquipment(equipmentID);
		} else {
			return false;
		}
	}

	// 修改设备信息（根据传来的equipmentID）
	public boolean updateEquipment(String no, Equipment equipment) {
		if (equipmentdao.isExist(no)) {
			return equipmentdao.updateEquipment(no, equipment);
		} else {
			return false;
		}
	}

	// 查询设备信息（根据传来的equipment）
	public Equipment queryEquipment(String equipmentID) {
		return equipmentdao.queryEquipment(equipmentID);
	}

	// 查询全部设备信息(通过List集合)
	public List<Equipment> queryAllEquipments() {
		return equipmentdao.queryAllEquipments();
	}

}
