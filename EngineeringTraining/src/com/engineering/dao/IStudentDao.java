package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Student;

public interface IStudentDao {
	// ���ѧ��
	public boolean addStudent(Student student);

	// ���ѧ��(ͼƬ)
	public boolean addStudent2(Student student);

	// ����Ϣ��ӵ����ձ�ͬʱɾ��ѧ�����еĴ�����¼
	public boolean deleteStudent(String stuno);

	// �޸�ѧ����Ϣ
	public boolean updateStudent(String stuno, Student student);

	// �޸�ѧ����Ϣ��ͼƬ��
	public boolean updateStudent2(String stuno, Student student);

	// ����ѧ�Ų�ѯѧ���Ƿ����
	public boolean isExist(String stuno);

	// ����ѧ�Ų�ѯѧ����Ϣ
	public Student queryStudent(String stuno);

	// ����ѧ�Ų�ѯѧ����Ϣ(ͼƬ)
	public Student queryStudent2(String stuno);

	// ����ʵ���ұ�Ų�ѯѧ����Ϣ
	public List<Student> queryStudentInLab(String labID);

	// ��ѯȫ������(ͨ��List����)
	public List<Student> queryAllStudents();

	// ��ѯ��ǰҳ�������
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);

	// ��ѯ��������
	public int getTotalCount();

	// ��������
	public List<Student> searchStudent(String search);

	// ��ѯȫ��ѧ������������
	public List<Student> querySort(String type);
}
