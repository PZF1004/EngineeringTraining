package com.engineering.entity;

import java.util.List;

//分页帮助类
public class Page {

	private int currentPage;// 当前页 currentPage

	private int pageSize; // 页面大小 pageSize

	private int totalCount; // 总数据 totalCount

	private int totalPage; // 总页数 totalPage

	private List<Student> students; // 当前页的数据集合 students

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

	// 自动计算出 总页数 务必注意顺序：先计算数据总数setTotalCount()，再计算页面大小setPageSize()
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		// 再设置页面大小时自动计算出 总页数
		// 总页数 = 数据总数%页面大小==0? 数据总数/页面大小:数据总数/页面大小+1 ;
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

	// 总页数是计算出来的，不是赋值给的，所以去掉
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
