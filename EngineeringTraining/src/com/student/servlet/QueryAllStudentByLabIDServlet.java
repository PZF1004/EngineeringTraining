package com.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Lab;
import com.engineering.entity.Student;
import com.engineering.service.ILabService;
import com.engineering.service.IStudentService;
import com.engineering.service.impl.LabServiceImpl;
import com.engineering.service.impl.StudentServiceImpl;

public class QueryAllStudentByLabIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryAllStudentByLabIDServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// PrintWriter out = response.getWriter();
		String labID = request.getParameter("labID");
		IStudentService service1 = new StudentServiceImpl();
		List<Student> students = service1.queryStudentInLab(labID);
		request.setAttribute("students", students);

		ILabService service2 = new LabServiceImpl();
		Lab lab = service2.queryLab(labID);
		request.setAttribute("lab", lab);

		request.getRequestDispatcher("page/LabInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
