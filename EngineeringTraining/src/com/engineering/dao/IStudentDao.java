package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Student;

public interface IStudentDao {
	// 添加学生
	public boolean addStudent(Student student);

	// 添加学生(图片)
	public boolean addStudent2(Student student);

	// 将信息添加到回收表，同时删除学生表中的此条记录
	public boolean deleteStudent(String stuno);

	// 修改学生信息
	public boolean updateStudent(String stuno, Student student);

	// 修改学生信息（图片）
	public boolean updateStudent2(String stuno, Student student);

	// 根据学号查询学生是否存在
	public boolean isExist(String stuno);

	// 根据学号查询学生信息
	public Student queryStudent(String stuno);

	// 根据学号查询学生信息(图片)
	public Student queryStudent2(String stuno);

	// 根据实验室编号查询学生信息
	public List<Student> queryStudentInLab(String labID);

	// 查询全部读者(通过List集合)
	public List<Student> queryAllStudents();

	// 查询当前页面的数据
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);

	// 查询总数据量
	public int getTotalCount();

	// 搜索功能
	public List<Student> searchStudent(String search);

	// 查询全部学生，并且排序
	public List<Student> querySort(String type);
}
