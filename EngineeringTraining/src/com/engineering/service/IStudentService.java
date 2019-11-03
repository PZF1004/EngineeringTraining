package com.engineering.service;

import java.util.List;

import com.engineering.entity.Student;

public interface IStudentService {

	// 添加学生信息
	public boolean addStudent(Student student);

	// 添加学生信息
	public boolean addStudent2(Student student);

	// 删除学生信息（根据传来的stuno）
	public boolean deleteStudent(String stuno);

	// 修改学生信息（根据传来的stuno）
	public boolean updateStudent(String stuno, Student student);

	// 修改学生信息（图片）（根据传来的stuno）
	public boolean updateStudent2(String stuno, Student student);

	// 查询学生信息（根据传来的stuno）
	public Student queryStudent(String stuno);

	// 查询学生信息(图片)（根据传来的stuno）
	public Student queryStudent2(String stuno);

	// 查询学生信息（根据传来的labID）
	public List<Student> queryStudentInLab(String labID);

	// 查询全部学生信息(通过List集合)
	public List<Student> queryAllStudents();

	// 查询数据总条数
	public int getTotalCount();

	// 查询当前页的数据集合
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);

	// 搜索功能
	public List<Student> searchStudent(String search);

	// 查询全部学生，并且排序
	public List<Student> querySort(String type);
}
