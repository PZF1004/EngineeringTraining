package com.recycle.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.service.IRecycleLabService;
import com.engineering.service.impl.RecycleLabServiceImpl;

public class RecoverLab extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String labID = request.getParameter("no");
		IRecycleLabService service = new RecycleLabServiceImpl();
		boolean result = service.recoverLab(labID);
		if (!result) {
			out.println("�ָ�ʧ��");
			response.setHeader("refresh", "3;URL=QueryAllRecycleLab");
		} else {
			request.getRequestDispatcher("QueryAllRecycleLab").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
