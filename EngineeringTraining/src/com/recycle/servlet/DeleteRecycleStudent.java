package com.recycle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.service.IRecycleStudentService;
import com.engineering.service.impl.RecycleStudentServiceImpl;

public class DeleteRecycleStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String stuno = request.getParameter("no");
		IRecycleStudentService service = new RecycleStudentServiceImpl();
		boolean result = service.deleteRecycleStudent(stuno);
		if (!result) {
			out.println("É¾³ýÊ§°Ü");
			response.setHeader("refresh", "3;URL=QueryAllRecycleStudent");
		} else {
			request.getRequestDispatcher("QueryAllRecycleStudent").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
