package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Lab;
import com.engineering.service.ILabService;
import com.engineering.service.impl.LabServiceImpl;

public class UpdateLabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// ������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// ��Ӧ����
		String no = request.getParameter("no");
		String labID = request.getParameter("labID");
		String labName = request.getParameter("labName");
		String labPlace = request.getParameter("labPlace");
		String labTime = request.getParameter("labTime");
		String Introduction = request.getParameter("Introduction");
		System.out.println(
				"servlet " + no + " " + labID + " " + labName + " " + labPlace + " " + labTime + " " + Introduction);
		Lab lab = new Lab(labID, labName, labPlace, labTime, Introduction);
		// �ӿ� xxx = new ʵ����
		ILabService service = new LabServiceImpl();
		boolean result = service.updateLab(no, lab);

		if (!result) {
			out.println("�޸�ʧ��");
			response.setHeader("refresh", "3;URL=QueryAllLabServlet");
		} else {
			out.println("�޸ĳɹ�");
			response.setHeader("refresh", "3;URL=QueryAllLabServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
