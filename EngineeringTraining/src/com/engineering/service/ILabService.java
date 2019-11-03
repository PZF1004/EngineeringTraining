package com.engineering.service;

import java.util.List;

import com.engineering.entity.Lab;

public interface ILabService {

	// 添加实验室
	public boolean addLab(Lab lab);

	// 删除实验室（根据传来的labID）
	public boolean deleteLab(String labID);

	// 修改实验室信息信息（根据传来的labID）
	public boolean updateLab(String labID, Lab lab);

	// 查询实验室信息（根据传来的labID）
	public Lab queryLab(String labID);

	// 查询全部实验室信息(通过List集合)
	public List<Lab> queryAllLabs();
}
