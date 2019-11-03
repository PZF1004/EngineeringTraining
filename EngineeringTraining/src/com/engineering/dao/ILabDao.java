package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Lab;

public interface ILabDao {

	// 添加实验室
	public boolean addLab(Lab lab);

	// 将实验室信息添加到回收表，同时删除此条记录
	public boolean deleteLab(String labID);

	// 修改实验室信息
	public boolean updateLab(String labID, Lab lab);

	// 根据实验室编号查询实验室是否存在
	public boolean isExist(String labID);

	// 根据学号查询学生信息
	public Lab queryLab(String labID);

	// 查询全部读者(通过List集合)
	public List<Lab> queryAllLabs();
}
