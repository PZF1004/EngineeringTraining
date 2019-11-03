package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Administrator;

public interface IAdministratorDao {

	// 添加管理员
	public boolean addAdministrator(Administrator administrator);

	// 将信息添加到回收表，同时删除此条记录
	public boolean deleteAdministrator(String adminID);

	// 修改管理员信息
	public boolean updateAdministrator(String adminID, Administrator administrator);

	// 根据管理员编号查询管理员是否存在
	public boolean isExist(String adminID);

	// 根据管理员编号查询管理员信息
	public Administrator queryAdministrator(String adminID);

	// 查询全部管理员信息(通过List集合)
	public List<Administrator> queryAllAdministrators();

}
