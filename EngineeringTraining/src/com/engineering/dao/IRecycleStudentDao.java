package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Student;

public interface IRecycleStudentDao {

	// 从回收站中彻底删除学生
	public boolean deleteRecycleStudent(String stuno);

	// 从回收站中恢复学生
	public boolean recoverStudent(String stuno);

	// 根据学号查询学生表学生是否存在该信息
	public boolean isExistStudent(String stuno);

	// 根据学号查询学生表中的学生信息
	public Student queryStudent(String stuno);

	// 根据学号查询回收站中是否存在该信息
	public boolean isExistRecycleStudent(String stuno);

	// 根据学号查询回收站中的学生信息
	public Student queryRecycleStudent(String stuno);

	// 查询回收站中的全部学生信息(通过List集合)
	public List<Student> queryAllRecycleStudents();
}
