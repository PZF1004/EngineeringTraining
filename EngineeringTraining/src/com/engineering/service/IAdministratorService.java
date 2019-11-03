package com.engineering.service;

import java.util.List;

import com.engineering.entity.Administrator;

public interface IAdministratorService {

	// 管理员注册
	public boolean addAdministrator(Administrator administrator);

	// 删除管理员信息（根据传来的adminID）
	public boolean deleteAdministrator(String adminID);

	// 修改管理员信息（根据传来的adminID）
	public boolean updateAdministrator(String adminID, Administrator administrator);

	// 查询管理员信息（根据传来的adminID）
	public Administrator queryAdministrator(String adminID);

	// 查询全部管理员信息(通过List集合)
	public List<Administrator> queryAllAdministrators();
}
