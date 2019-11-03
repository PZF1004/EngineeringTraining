package com.engineering.dao;

import java.util.List;

import com.engineering.entity.Student;

public interface IRecycleStudentDao {

	// �ӻ���վ�г���ɾ��ѧ��
	public boolean deleteRecycleStudent(String stuno);

	// �ӻ���վ�лָ�ѧ��
	public boolean recoverStudent(String stuno);

	// ����ѧ�Ų�ѯѧ����ѧ���Ƿ���ڸ���Ϣ
	public boolean isExistStudent(String stuno);

	// ����ѧ�Ų�ѯѧ�����е�ѧ����Ϣ
	public Student queryStudent(String stuno);

	// ����ѧ�Ų�ѯ����վ���Ƿ���ڸ���Ϣ
	public boolean isExistRecycleStudent(String stuno);

	// ����ѧ�Ų�ѯ����վ�е�ѧ����Ϣ
	public Student queryRecycleStudent(String stuno);

	// ��ѯ����վ�е�ȫ��ѧ����Ϣ(ͨ��List����)
	public List<Student> queryAllRecycleStudents();
}
