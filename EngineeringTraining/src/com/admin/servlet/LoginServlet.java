package com.admin.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.engineering.entity.Administrator;
import com.engineering.service.IAdministratorService;
import com.engineering.service.impl.AdministratorServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		// 获得当前时间
		Date date = new Date();
		// 转换成指定格式的字符串
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String loginTime = format.format(date);
		session.setAttribute("loginTime", loginTime);
		// 设置服务端响应的编码
		response.setContentType("text/html; charset=UTF-8");
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		IAdministratorService adminservice = new AdministratorServiceImpl();
		Administrator administrator = adminservice.queryAdministrator(number);

		if (administrator != null && administrator.getAdminName().equals(name)
				&& administrator.getPassword().equals(password)) {
			Cookie cookie1 = new Cookie("cookie_number", administrator.getAdminID());
			Cookie cookie2 = new Cookie("cookie_name", administrator.getAdminName());
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			cookie1.setMaxAge(60); // 设置最大有效期为60秒
			cookie2.setMaxAge(60);

			session.setAttribute("administrator", administrator);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			response.sendRedirect("loginFail.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
