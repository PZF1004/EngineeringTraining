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

public class AddLabServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String labID = request.getParameter("labID");
		String labName = request.getParameter("labName");
		String labPlace = request.getParameter("labPlace");
		String temp = request.getParameter("labTime");
		String labTime = (temp.equals("")) ? "1111-11-11" : temp;
		String Introduction = request.getParameter("Introduction");
		Lab lab = new Lab(labID, labName, labPlace, labTime, Introduction);

		// �ӿ� xxx = new ʵ����
		ILabService service = new LabServiceImpl();// �ϲ�servlet�����²�service
		boolean result = service.addLab(lab);// service����ֵ����servlet
		// ������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// ��Ӧ����
		if (!result) {
			out.println("����ʧ��");
			response.setHeader("refresh", "1;URL=page/InsertLab.jsp");
		} else {
			out.println("���ӳɹ�");
			response.setHeader("refresh", "1;URL=QueryAllLabServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
