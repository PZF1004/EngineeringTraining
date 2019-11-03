package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IStudentDao;
import com.engineering.dao.impl.StudentDaoImpl;
import com.engineering.entity.Student;
import com.engineering.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	// Service中调用Dao(多态：接口 xxx = new 实现类)
	IStudentDao studentdao = new StudentDaoImpl();

	// 添加学生信息
	public boolean addStudent(Student student) {
		if (!studentdao.isExist(student.getStuno())) { // 不存在则调用方法增加
			return studentdao.addStudent(student); // 增加，并且Dao层将成功信息返回给service
		} else { // 存在
			System.out.println("此人已存在！");
			return false;
		}
	}

	// 添加学生信息（图片）
	public boolean addStudent2(Student student) {
		if (!studentdao.isExist(student.getStuno())) {
			return studentdao.addStudent2(student);
		} else { // 存在
			System.out.println("此人已存在！");
			return false;
		}
	}

	// 删除学生信息（根据传来的stuno）
	public boolean deleteStudent(String stuno) {
		if (studentdao.isExist(stuno)) {
			return studentdao.deleteStudent(stuno);
		} else {
			return false;
		}
	}

	// 修改学生信息（根据传来的stuno）
	public boolean updateStudent(String stuno, Student student) {
		if (studentdao.isExist(stuno)) {
			return studentdao.updateStudent(stuno, student);
		} else {
			return false;
		}
	}

	// 修改学生信息(图片)（根据传来的stuno）
	public boolean updateStudent2(String stuno, Student student) {
		if (studentdao.isExist(stuno)) {
			return studentdao.updateStudent2(stuno, student);
		} else {
			return false;
		}
	}

	// 查询学生信息（根据传来的stuno）
	public Student queryStudent(String stuno) {
		return studentdao.queryStudent(stuno);
	}

	// 查询学生信息（图片）（根据传来的stuno）
	public Student queryStudent2(String stuno) {
		return studentdao.queryStudent2(stuno);
	}

	// 查询学生信息（根据传来的labID）
	public List<Student> queryStudentInLab(String labID) {
		return studentdao.queryStudentInLab(labID);
	}

	// 查询全部学生信息(通过List集合)
	public List<Student> queryAllStudents() {
		return studentdao.queryAllStudents();
	}

	// 查询数据总条数
	public int getTotalCount() {
		return studentdao.getTotalCount();
	}

	// 查询当前页的数据集合
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return studentdao.queryStudentsByPage(currentPage, pageSize);
	}

	// 搜索功能
	public List<Student> searchStudent(String search) {
		return studentdao.searchStudent(search);
	}

	// 查询全部学生，并且排序
	public List<Student> querySort(String type) {
		return studentdao.querySort(type);
	}

}
