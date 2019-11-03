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

		// �ӿ� xxx = new ʵ����
		IEquipmentService service = new EquipmentServiceImpl();// �ϲ�servlet�����²�service
		boolean result = service.addEquipment(equipment);// service����ֵ����servlet
		// ������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// ��Ӧ����
		if (!result) {
			out.println("����ʧ��");
			response.setHeader("refresh", "3;URL=page/InsertEquipment.jsp");
		} else {
			out.println("���ӳɹ�");
			response.setHeader("refresh", "3;URL=QueryAllEquipmentServlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
