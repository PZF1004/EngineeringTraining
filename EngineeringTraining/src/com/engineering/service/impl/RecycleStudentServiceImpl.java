package com.engineering.service.impl;

import java.util.List;

import com.engineering.dao.IRecycleStudentDao;
import com.engineering.dao.impl.RecycleStudentDaoImpl;
import com.engineering.entity.Student;
import com.engineering.service.IRecycleStudentService;

public class RecycleStudentServiceImpl implements IRecycleStudentService {

	// Service�е���Dao(��̬���ӿ� xxx = new ʵ����)
	IRecycleStudentDao recycle = new RecycleStudentDaoImpl();

	// �ӻ���վ�г���ɾ��ѧ�������ݴ�����stuno��
	public boolean deleteRecycleStudent(String stuno) {
		if (recycle.isExistRecycleStudent(stuno)) {
			return recycle.deleteRecycleStudent(stuno);
		} else {
			return false;
		}
	}

	// �ӻ���վ�лָ�ѧ��
	public boolean recoverStudent(String stuno) {
		if (!recycle.isExistStudent(stuno)) {
			return recycle.recoverStudent(stuno);
		} else { // ����
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}

	// ��ѯ����վ��ѧ����Ϣ�����ݴ�����stuno��
	public Student queryRecycleStudent(String stuno) {
		return recycle.queryRecycleStudent(stuno);
	}

	// ��ѯȫ������վ��ѧ����Ϣ(ͨ��List����)
	public List<Student> queryAllRecoverStudents() {
		return recycle.queryAllRecycleStudents();
	}
}
