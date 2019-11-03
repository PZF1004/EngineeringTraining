package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IRecycleEquipmentDao;
import com.engineering.dao.impl.RecycleEquipmentDaoImpl;
import com.engineering.entity.Equipment;
import com.engineering.service.IRecycleEquipmentService;

public class RecycleEquipmentServiceImpl implements IRecycleEquipmentService {

	// Service中调用Dao(多态：接口 xxx = new 实现类)
	IRecycleEquipmentDao recycle = new RecycleEquipmentDaoImpl();

	// 从回收站中彻底删除设备信息
	public boolean deleteRecycleEquipment(String equipmentID) {
		if (recycle.isExistRecycleEquipment(equipmentID)) {
			return recycle.deleteRecycleEquipment(equipmentID);
		} else {
			return false;
		}
	}

	// 从回收站中恢复设备信息
	public boolean recoverEquipment(String equipmentID) {
		if (!recycle.isExistEquipment(equipmentID)) {
			return recycle.recoverEquipment(equipmentID);
		} else { // 存在
			System.out.println("此设备已存在！");
			return false;
		}
	}

	// 查询回收站的设备信息
	public Equipment queryRecycleEquipment(String equipmentID) {
		return recycle.queryRecycleEquipment(equipmentID);
	}

	// 查询全部回收站的设备信息(通过List集合)
	public List<Equipment> queryAllRecycleEquipments() {
		return recycle.queryAllRecycleEquipments();
	}

}
