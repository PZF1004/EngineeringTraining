package com.engineering.service;

import java.util.List;

import com.engineering.entity.Student;

public interface IRecycleStudentService {
	// �ӻ���վ�г���ɾ��ѧ�������ݴ�����stuno��
	public boolean deleteRecycleStudent(String stuno);

	// �ӻ���վ�лָ�ѧ��
	public boolean recoverStudent(String stuno);

	// ��ѯ����վ��ѧ����Ϣ�����ݴ�����stuno��
	public Student queryRecycleStudent(String stuno);

	// ��ѯȫ������վ��ѧ����Ϣ(ͨ��List����)
	public List<Student> queryAllRecoverStudents();
}
