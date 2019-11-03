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

		// ��ǰҳ currentPage
		String cPage = request.getParameter("currentPage");
		if (cPage == null) {
			cPage = "1";
		}
		int currentPage = Integer.parseInt(cPage);

		// ��������
		int totalCount = studentService.getTotalCount();

		// ����ÿҳ��������Ϊ3������
		int pageSize = 25;

		// ���㵱ǰҳ�����ݼ��� ��currentPage����ǰҳ��ҳ�룩 students :��ǰҳ�����ݼ��ϣ���ǰҳ������ѧ����
		List<Student> students = studentService.queryStudentsByPage(currentPage, pageSize);
		// ����ҳ�����5���ֶΣ�������1���Զ����㣬���ʵ��ֻ��Ҫ��װ4�����ɣ�����װ��page����֮��
		Page page = new Page();
		// �Զ������ ��ҳ�� ���ע��˳���ȼ�����������setTotalCount()���ټ���ҳ���СsetPageSize()
		page.setCurrentPage(currentPage);
		page.setTotalCount(totalCount);// ��������
		page.setPageSize(pageSize);// ҳ���С
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
