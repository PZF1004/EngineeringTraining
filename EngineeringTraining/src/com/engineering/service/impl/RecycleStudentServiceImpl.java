package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IRecycleStudentDao;
import com.engineering.dao.impl.RecycleStudentDaoImpl;
import com.engineering.entity.Student;
import com.engineering.service.IRecycleStudentService;

public class RecycleStudentServiceImpl implements IRecycleStudentService {

	// Service中调用Dao(多态：接口 xxx = new 实现类)
	IRecycleStudentDao recycle = new RecycleStudentDaoImpl();

	// 从回收站中彻底删除学生（根据传来的stuno）
	public boolean deleteRecycleStudent(String stuno) {
		if (recycle.isExistRecycleStudent(stuno)) {
			return recycle.deleteRecycleStudent(stuno);
		} else {
			return false;
		}
	}

	// 从回收站中恢复学生
	public boolean recoverStudent(String stuno) {
		if (!recycle.isExistStudent(stuno)) {
			return recycle.recoverStudent(stuno);
		} else { // 存在
			System.out.println("此人已存在！");
			return false;
		}
	}

	// 查询回收站的学生信息（根据传来的stuno）
	public Student queryRecycleStudent(String stuno) {
		return recycle.queryRecycleStudent(stuno);
	}

	// 查询全部回收站的学生信息(通过List集合)
	public List<Student> queryAllRecoverStudents() {
		return recycle.queryAllRecycleStudents();
	}
}
