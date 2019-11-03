package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Page;
import com.engineering.entity.Student;
import com.engineering.service.IStudentService;
import com.engineering.service.impl.StudentServiceImpl;

public class QueryAllStudentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryAllStudentByPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService studentService = new StudentServiceImpl();

		// 当前页 currentPage
		String cPage = request.getParameter("currentPage");
		if (cPage == null) {
			cPage = "1";
		}
		int currentPage = Integer.parseInt(cPage);

		// 总数据数
		int totalCount = studentService.getTotalCount();

		// 设置每页的数据数为3条数据
		int pageSize = 25;

		// 计算当前页的数据集合 ：currentPage：当前页（页码） students :当前页的数据集合（当前页的所有学生）
		List<Student> students = studentService.queryStudentsByPage(currentPage, pageSize);
		// 将分页所需的5个字段（其中有1个自动计算，因此实际只需要组装4个即可），组装到page对象之中
		Page page = new Page();
		// 自动计算出 总页数 务必注意顺序：先计算数据总数setTotalCount()，再计算页面大小setPageSize()
		page.setCurrentPage(currentPage);
		page.setTotalCount(totalCount);// 数据总数
		page.setPageSize(pageSize);// 页面大小
		page.setStudents(students);
		request.setAttribute("p", page);
		request.getRequestDispatcher("page/QueryAllStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
