package com.recycle.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Student;
import com.engineering.service.IRecycleStudentService;
import com.engineering.service.impl.RecycleStudentServiceImpl;

public class QueryAllRecycleStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// ���÷������Ӧ�ı���
		response.setContentType("text/html; charset=UTF-8");
		// �ӿ� xxx = new ʵ����
		IRecycleStudentService service = new RecycleStudentServiceImpl();
		List<Student> students = service.queryAllRecoverStudents();
		request.setAttribute("students", students);
		request.getRequestDispatcher("recycle/QueryAllRecycleStudent.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
