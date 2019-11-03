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

		// 接口 xxx = new 实现类
		ILabService service = new LabServiceImpl();// 上层servlet调用下层service
		boolean result = service.addLab(lab);// service返回值传给servlet
		// 设置响应编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// 响应对象
		if (!result) {
			out.println("增加失败");
			response.setHeader("refresh", "1;URL=page/InsertLab.jsp");
		} else {
			out.println("增加成功");
			response.setHeader("refresh", "1;URL=QueryAllLabServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
