package com.student.servlet;

import java.io.IOException;

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

public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 数据传输时的编码
		request.setCharacterEncoding("utf-8");// 请求编码
		response.setCharacterEncoding("utf-8");// 响应编码
		// 数据显示时的编码
		response.setContentType("text/html; charset=UTF-8");
		// PrintWriter out = response.getWriter();
		String stuno = request.getParameter("stuno");
		System.out.println("*********" + stuno);
		IStudentService service1 = new StudentServiceImpl();
		Student student = service1.queryStudent2(stuno);
		request.setAttribute("student", student);

		String labID = student.getLabID();
		ILabService service2 = new LabServiceImpl();
		Lab lab = service2.queryLab(labID);
		request.setAttribute("lab", lab);
		request.getRequestDispatcher("page/StudentInfo.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
