package com.equipment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.entity.Equipment;
import com.engineering.service.IEquipmentService;
import com.engineering.service.impl.EquipmentServiceImpl;

public class UpdateEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 设置响应编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// 响应对象

		String no = request.getParameter("no");
		String equipmentID = request.getParameter("equipmentID");
		String equipmentName = request.getParameter("equipmentName");
		int equipmentNumber = Integer.parseInt(request.getParameter("equipmentNumber"));
		int equipmentPrice = Integer.parseInt(request.getParameter("equipmentPrice"));
		String equipmentStatus = request.getParameter("equipmentStatus");
		String Introduction = request.getParameter("introduction");
		String equipmentTime = request.getParameter("equipmentTime");
		Equipment equipment = new Equipment(equipmentID, equipmentName, equipmentNumber, equipmentPrice,
				equipmentStatus, Introduction, equipmentTime);
		IEquipmentService service = new EquipmentServiceImpl();
		boolean result = service.updateEquipment(no, equipment);
		if (!result) {
			out.println("修改失败");
			response.setHeader("refresh", "3;URL=QueryAllEquipmentServlet");
		} else {
			out.println("修改成功");
			response.setHeader("refresh", "3;URL=QueryAllEquipmentServlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
