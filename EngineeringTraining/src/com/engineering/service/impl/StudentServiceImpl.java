package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IStudentDao;
import com.engineering.dao.impl.StudentDaoImpl;
import com.engineering.entity.Student;
import com.engineering.service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	IStudentDao studentdao = new StudentDaoImpl();

	// ���ѧ����Ϣ
	public boolean addStudent(Student student) {
		if (!studentdao.isExist(student.getStuno())) { // ����������÷�������
			return studentdao.addStudent(student); // ���ӣ�����Dao�㽫�ɹ���Ϣ���ظ�service
		} else { // ����
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}

	// ���ѧ����Ϣ��ͼƬ��
	public boolean addStudent2(Student student) {
		if (!studentdao.isExist(student.getStuno())) {
			return studentdao.addStudent2(student);
		} else { // ����
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}

	// ɾ��ѧ����Ϣ�����ݴ�����stuno��
	public boolean deleteStudent(String stuno) {
		if (studentdao.isExist(stuno)) {
			return studentdao.deleteStudent(stuno);
		} else {
			return false;
		}
	}

	// �޸�ѧ����Ϣ�����ݴ�����stuno��
	public boolean updateStudent(String stuno, Student student) {
		if (studentdao.isExist(stuno)) {
			return studentdao.updateStudent(stuno, student);
		} else {
			return false;
		}
	}

	// �޸�ѧ����Ϣ(ͼƬ)�����ݴ�����stuno��
	public boolean updateStudent2(String stuno, Student student) {
		if (studentdao.isExist(stuno)) {
			return studentdao.updateStudent2(stuno, student);
		} else {
			return false;
		}
	}

	// ��ѯѧ����Ϣ�����ݴ�����stuno��
	public Student queryStudent(String stuno) {
		return studentdao.queryStudent(stuno);
	}

	// ��ѯѧ����Ϣ��ͼƬ�������ݴ�����stuno��
	public Student queryStudent2(String stuno) {
		return studentdao.queryStudent2(stuno);
	}

	// ��ѯѧ����Ϣ�����ݴ�����labID��
	public List<Student> queryStudentInLab(String labID) {
		return studentdao.queryStudentInLab(labID);
	}

	// ��ѯȫ��ѧ����Ϣ(ͨ��List����)
	public List<Student> queryAllStudents() {
		return studentdao.queryAllStudents();
	}

	// ��ѯ����������
	public int getTotalCount() {
		return studentdao.getTotalCount();
	}

	// ��ѯ��ǰҳ�����ݼ���
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return studentdao.queryStudentsByPage(currentPage, pageSize);
	}

	// ��������
	public List<Student> searchStudent(String search) {
		return studentdao.searchStudent(search);
	}

	// ��ѯȫ��ѧ������������
	public List<Student> querySort(String type) {
		return studentdao.querySort(type);
	}

}
