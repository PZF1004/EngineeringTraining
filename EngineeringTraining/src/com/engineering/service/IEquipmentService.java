package com.engineering.service;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IEquipmentService {

	// 添加设备信息
	public boolean addEquipment(Equipment equipment);

	// 删除设备信息（根据传来的equipmentID）
	public boolean deleteEquipment(String equipmentID);

	// 修改设备信息（根据传来的equipmentID）
	public boolean updateEquipment(String no, Equipment equipment);

	// 查询设备信息（根据传来的equipment）
	public Equipment queryEquipment(String equipmentID);

	// 查询全部设备信息(通过List集合)
	public List<Equipment> queryAllEquipments();

}
