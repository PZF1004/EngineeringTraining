package com.engineering.service;

import java.util.List;

import com.engineering.entity.Student;

public interface IStudentService {

	// ���ѧ����Ϣ
	public boolean addStudent(Student student);

	// ���ѧ����Ϣ
	public boolean addStudent2(Student student);

	// ɾ��ѧ����Ϣ�����ݴ�����stuno��
	public boolean deleteStudent(String stuno);

	// �޸�ѧ����Ϣ�����ݴ�����stuno��
	public boolean updateStudent(String stuno, Student student);

	// �޸�ѧ����Ϣ��ͼƬ�������ݴ�����stuno��
	public boolean updateStudent2(String stuno, Student student);

	// ��ѯѧ����Ϣ�����ݴ�����stuno��
	public Student queryStudent(String stuno);

	// ��ѯѧ����Ϣ(ͼƬ)�����ݴ�����stuno��
	public Student queryStudent2(String stuno);

	// ��ѯѧ����Ϣ�����ݴ�����labID��
	public List<Student> queryStudentInLab(String labID);

	// ��ѯȫ��ѧ����Ϣ(ͨ��List����)
	public List<Student> queryAllStudents();

	// ��ѯ����������
	public int getTotalCount();

	// ��ѯ��ǰҳ�����ݼ���
	public List<Student> queryStudentsByPage(int currentPage, int pageSize);

	// ��������
	public List<Student> searchStudent(String search);

	// ��ѯȫ��ѧ������������
	public List<Student> querySort(String type);
}
