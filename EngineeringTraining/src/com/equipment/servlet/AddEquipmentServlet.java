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

public class AddEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String equipmentID = request.getParameter("equipmentID");
		String equipmentName = request.getParameter("equipmentName");

		String temp = request.getParameter("equipmentNumber");
		int equipmentNumber = temp.equals("") ? 0 : Integer.parseInt(temp);

		String equipmentPlace = request.getParameter("equipmentPlace");
		String equipmentManager = request.getParameter("equipmentManager");

		String temp2 = request.getParameter("equipmentPrice");
		int equipmentPrice = temp2.equals("") ? 0 : Integer.parseInt(temp2);

		String equipmentStatus = request.getParameter("equipmentStatus");
		String introduction = request.getParameter("introduction");

		String temp3 = request.getParameter("equipmentTime");
		String equipmentTime = (temp3.equals("")) ? "1111-11-11" : temp3;

		Equipment equipment = new Equipment(equipmentID, equipmentName, equipmentNumber, equipmentPlace,
				equipmentManager, equipmentPrice, equipmentStatus, introduction, equipmentTime);

		// 接口 xxx = new 实现类
		IEquipmentService service = new EquipmentServiceImpl();// 上层servlet调用下层service
		boolean result = service.addEquipment(equipment);// service返回值传给servlet
		// 设置响应编码
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// 响应对象
		if (!result) {
			out.println("增加失败");
			response.setHeader("refresh", "3;URL=page/InsertEquipment.jsp");
		} else {
			out.println("增加成功");
			response.setHeader("refresh", "3;URL=QueryAllEquipmentServlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
