package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Administrator;
import com.engineering.service.IAdministratorService;
import com.engineering.service.impl.AdministratorServiceImpl;

public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String adminID = request.getParameter("adminID");
		String adminName = request.getParameter("adminName");
		String sex = request.getParameter("sex");
		String dept = request.getParameter("dept");
		String password = request.getParameter("password");
		String labID = request.getParameter("labID");
		Administrator administrator = new Administrator(adminID, adminName, sex, dept, password, labID);
		// �ӿ� xxx = new ʵ����
		IAdministratorService service = new AdministratorServiceImpl();
		boolean result = service.addAdministrator(administrator);
		// ������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// ��Ӧ����
		if (!result) {
			out.println("����ʧ��");
			response.setHeader("refresh", "3;URL=page/InsertAdmin.jsp");
		} else {
			out.println("���ӳɹ�");
			response.setHeader("refresh", "3;URL=QueryAllAdminServlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
