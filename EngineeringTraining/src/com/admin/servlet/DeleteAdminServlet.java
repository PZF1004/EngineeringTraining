package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.service.IAdministratorService;
import com.engineering.service.impl.AdministratorServiceImpl;

public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String adminID = request.getParameter("no");
		IAdministratorService service = new AdministratorServiceImpl();
		boolean result = service.deleteAdministrator(adminID);
		if (!result) {
			out.println("É¾³ýÊ§°Ü");
			response.setHeader("refresh", "3;URL=QueryAllAdminServlet");
		} else {
			request.getRequestDispatcher("QueryAllAdminServlet").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
