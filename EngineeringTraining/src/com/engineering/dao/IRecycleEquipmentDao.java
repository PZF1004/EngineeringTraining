package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IRecycleEquipmentDao {

	// 从回收站中彻底删除设备信息
	public boolean deleteRecycleEquipment(String equipmentID);

	// 从回收站中恢复设备信息
	public boolean recoverEquipment(String equipmentID);

	// 根据设备编号查询设备表中是否存在该信息
	public boolean isExistEquipment(String equipmentID);

	// 根据设备编号查询设备表中的信息
	public Equipment queryEquipment(String equipmentID);

	// 根据设备编号查询回收站中是否存在该信息
	public boolean isExistRecycleEquipment(String equipmentID);

	// 根据设备编号查询回收站中的设备信息
	public Equipment queryRecycleEquipment(String equipmentID);

	// 查询回收站中的全部设备信息(通过List集合)
	public List<Equipment> queryAllRecycleEquipments();

}
