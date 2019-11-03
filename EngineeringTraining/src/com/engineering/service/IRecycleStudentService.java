package com.engineering.service;

import java.util.List;

import com.engineering.entity.Student;

public interface IRecycleStudentService {
	// 从回收站中彻底删除学生（根据传来的stuno）
	public boolean deleteRecycleStudent(String stuno);

	// 从回收站中恢复学生
	public boolean recoverStudent(String stuno);

	// 查询回收站的学生信息（根据传来的stuno）
	public Student queryRecycleStudent(String stuno);

	// 查询全部回收站的学生信息(通过List集合)
	public List<Student> queryAllRecoverStudents();
}
