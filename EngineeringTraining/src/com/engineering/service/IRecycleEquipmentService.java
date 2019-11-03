package com.engineering.service;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IRecycleEquipmentService {
	// 从回收站中彻底删除设备信息
	public boolean deleteRecycleEquipment(String equipmentID);

	// 从回收站中恢复设备信息
	public boolean recoverEquipment(String equipmentID);

	// 查询回收站的设备信息
	public Equipment queryRecycleEquipment(String equipmentID);

	// 查询全部回收站的设备信息(通过List集合)
	public List<Equipment> queryAllRecycleEquipments();
}
