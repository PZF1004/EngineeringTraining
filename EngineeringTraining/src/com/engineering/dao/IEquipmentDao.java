package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Equipment;

public interface IEquipmentDao {

	// 添加设备
	public boolean addEquipment(Equipment equipment);

	// 将信息添加到回收表，同时删除此条记录
	public boolean deleteEquipment(String equipmentID);

	// 修改设备信息
	public boolean updateEquipment(String no, Equipment equipment);

	// 根据设备号查询设备是否存在
	public boolean isExist(String equipmentID);

	// 根据设备号查询设备信息
	public Equipment queryEquipment(String equipmentID);

	// 查询全部设备信息(通过List集合)
	public List<Equipment> queryAllEquipments();

}
