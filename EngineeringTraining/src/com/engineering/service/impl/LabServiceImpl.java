package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.ILabDao;
import com.engineering.dao.impl.LabDaoImpl;
import com.engineering.entity.Lab;
import com.engineering.service.ILabService;

public class LabServiceImpl implements ILabService {
	// Service中调用Dao(多态：接口 xxx = new 实现类)
	ILabDao labdao = new LabDaoImpl();

	// 添加实验室
	public boolean addLab(Lab lab) {
		if (!labdao.isExist(lab.getLabID())) { // 不存在则调用方法增加
			return labdao.addLab(lab); // 增加，并且Dao层将成功信息返回给service
		} else { // 存在
			System.out.println("此实验室已存在！");
			return false;
		}
	}

	// 删除实验室（根据传来的labID）
	public boolean deleteLab(String labID) {
		if (labdao.isExist(labID)) {
			return labdao.deleteLab(labID);
		} else {
			return false;
		}
	}

	// 修改实验室信息信息（根据传来的labID）
	public boolean updateLab(String labID, Lab lab) {
		return labdao.updateLab(labID, lab);
	}

	// 查询实验室信息（根据传来的labID）
	public Lab queryLab(String labID) {
		return labdao.queryLab(labID);
	}

	// 查询全部实验室信息(通过List集合)
	public List<Lab> queryAllLabs() {
		return labdao.queryAllLabs();
	}

}
