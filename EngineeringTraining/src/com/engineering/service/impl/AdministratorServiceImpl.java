package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IAdministratorDao;
import com.engineering.dao.impl.AdministratorDaoImpl;
import com.engineering.entity.Administrator;
import com.engineering.service.IAdministratorService;

public class AdministratorServiceImpl implements IAdministratorService {

	// Service中调用Dao(多态：接口 xxx = new 实现类)
	IAdministratorDao administratordao = new AdministratorDaoImpl();

	// 管理员注册
	public boolean addAdministrator(Administrator administrator) {
		if (!administratordao.isExist(administrator.getAdminID())) { // 不存在则调用方法增加
			return administratordao.addAdministrator(administrator); // 增加，并且Dao层将成功信息返回给service
		} else { // 存在
			System.out.println("此人已存在！");
			return false;
		}
	}

	// 删除管理员信息（根据传来的adminID）
	public boolean deleteAdministrator(String adminID) {
		if (administratordao.isExist(adminID)) {
			return administratordao.deleteAdministrator(adminID);
		} else {
			return false;
		}
	}

	// 修改管理员信息（根据传来的adminID）
	public boolean updateAdministrator(String adminID, Administrator administrator) {
		if (administratordao.isExist(adminID)) {
			return administratordao.updateAdministrator(adminID, administrator);
		} else {
			return false;
		}
	}

	// 查询管理员信息（根据传来的adminID）
	public Administrator queryAdministrator(String adminID) {
		return administratordao.queryAdministrator(adminID);
	}

	// 查询全部管理员信息(通过List集合)
	public List<Administrator> queryAllAdministrators() {
		return administratordao.queryAllAdministrators();
	}

}
