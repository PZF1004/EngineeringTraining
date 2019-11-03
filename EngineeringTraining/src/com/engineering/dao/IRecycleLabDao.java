package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Lab;

public interface IRecycleLabDao {
	// 从回收站中彻底删除实验室
	public boolean deleteRecycleLab(String labID);

	// 从回收站中恢复实验室
	public boolean recoverLab(String labID);

	// 根据实验室编号查询实验室表中是否存在该实验室
	public boolean isExistLab(String labID);

	// 根据实验室编号查询实验室表的信息
	public Lab queryLab(String labID);

	// 根据实验室编号查询回收站中是否存在该实验室
	public boolean isExistRecycleLab(String labID);

	// 根据实验室编号查询回收站中实验室的信息
	public Lab queryRecycleLab(String labID);

	// 查询回收站中全部实验室信息(通过List集合)
	public List<Lab> queryAllRecycleLabs();
}
