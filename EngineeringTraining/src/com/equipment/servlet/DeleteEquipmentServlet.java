package com.equipment.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engineering.service.IEquipmentService;
import com.engineering.service.impl.EquipmentServiceImpl;

public class DeleteEquipmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String equipmentID = request.getParameter("no");
		IEquipmentService service = new EquipmentServiceImpl();
		boolean result = service.deleteEquipment(equipmentID);
		if (!result) {
			out.println("ɾ��ʧ��");
			response.setHeader("refresh", "3;URL=QueryAllEquipmentServlet");
		} else {
			request.getRequestDispatcher("QueryAllEquipmentServlet").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
