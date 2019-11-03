package com.engineering.entity;

import java.util.List;

//��ҳ������
public class Page {

	private int currentPage;// ��ǰҳ currentPage

	private int pageSize; // ҳ���С pageSize

	private int totalCount; // ������ totalCount

	private int totalPage; // ��ҳ�� totalPage

	private List<Student> students; // ��ǰҳ�����ݼ��� students

	public Page() {
	}

	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> students) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	// �Զ������ ��ҳ�� ���ע��˳���ȼ�����������setTotalCount()���ټ���ҳ���СsetPageSize()
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		// ������ҳ���Сʱ�Զ������ ��ҳ��
		// ��ҳ�� = ��������%ҳ���С==0? ��������/ҳ���С:��������/ҳ���С+1 ;
		this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize
				: totalCount / this.pageSize + 1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	// ��ҳ���Ǽ�������ģ����Ǹ�ֵ���ģ�����ȥ��
	// public void setTotalPage(int totalPage) {
	// this.totalPage = totalPage;
	// }

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
