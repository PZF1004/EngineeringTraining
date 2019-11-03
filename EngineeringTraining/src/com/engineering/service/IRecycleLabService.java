package com.engineering.service;

import java.util.List;

import com.engineering.entity.Lab;

public interface IRecycleLabService {
	// 彻底删除实验室（根据传来的labID）
	public boolean deleteRecycleLab(String labID);

	// 恢复实验室
	public boolean recoverLab(String labID);

	// 查询回收站中的实验室信息（根据传来的labID）
	public Lab queryRecycleLab(String labID);

	// 查询回收站中全部实验室信息(通过List集合)
	public List<Lab> queryAllRecycleLabs();
}
