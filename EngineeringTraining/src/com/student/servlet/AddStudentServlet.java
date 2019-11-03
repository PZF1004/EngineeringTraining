package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Student;
import com.engineering.service.IStudentService;
import com.engineering.service.impl.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String stuno = request.getParameter("stuno");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String dept = request.getParameter("dept");
		String classID = request.getParameter("classID");
		String labID = request.getParameter("labID");
		String entryTime = request.getParameter("entryTime");
		String position = request.getParameter("position");
		String gameExperience = request.getParameter("gameExperience");
		String winInformation = request.getParameter("winInformation");
		String graduationTime = request.getParameter("graduationTime");
		String employmentUnit = request.getParameter("employmentUnit");
		String performance = request.getParameter("performance");
		Student student = new Student(stuno, name, sex, phone, dept, classID, labID, entryTime, position,
				gameExperience, winInformation, graduationTime, employmentUnit, performance);

		// �ӿ� xxx = new ʵ����
		IStudentService service = new StudentServiceImpl();// �ϲ�servlet�����²�service
		boolean result = service.addStudent(student);// service����ֵ����servlet
		// ������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// ��Ӧ����
		if (!result) {
			out.println("����ʧ��");
			response.setHeader("refresh", "3;URL=page/InsertStudent.jsp");
		} else {
			out.println("���ӳɹ�");
			response.setHeader("refresh", "3;URL=QueryAllStudentServlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
