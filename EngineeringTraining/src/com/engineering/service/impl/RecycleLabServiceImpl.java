package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IRecycleLabDao;
import com.engineering.dao.impl.RecycleLabDaoImpl;
import com.engineering.entity.Lab;
import com.engineering.service.IRecycleLabService;

public class RecycleLabServiceImpl implements IRecycleLabService {

	// Service中调用Dao(多态：接口 xxx = new 实现类)
	IRecycleLabDao recycle = new RecycleLabDaoImpl();

	// 彻底删除实验室（根据传来的labID）
	public boolean deleteRecycleLab(String labID) {
		if (recycle.isExistRecycleLab(labID)) {
			return recycle.deleteRecycleLab(labID);
		} else {
			return false;
		}
	}

	// 恢复实验室
	public boolean recoverLab(String labID) {
		if (!recycle.isExistLab(labID)) { // 查询实验室表中是否存在该记录
			return recycle.recoverLab(labID);
		} else { // 存在
			System.out.println("此人已存在！");
			return false;
		}
	}

	// 查询回收站中的实验室信息（根据传来的labID）
	public Lab queryRecycleLab(String labID) {
		return recycle.queryRecycleLab(labID);
	}

	// 查询回收站中全部实验室信息(通过List集合)
	public List<Lab> queryAllRecycleLabs() {
		return recycle.queryAllRecycleLabs();
	}
}
