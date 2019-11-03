package com.student.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:mysql://localhost:3306/engineering_training";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ReadPictureServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 数据传输时的编码
		request.setCharacterEncoding("utf-8");// 请求编码
		response.setCharacterEncoding("utf-8");// 响应编码
		// 数据显示时的编码
		response.setContentType("text/html; charset=UTF-8");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "select picture from student where stuno = ? ";
			pstmt = connection.prepareStatement(sql);
			String stuno = request.getParameter("stuno");
			pstmt.setString(1, stuno);
			rs = pstmt.executeQuery();
			byte[] picture = null;
			if (rs.next()) {
				picture = rs.getBytes("picture");
				response.setContentType("image/jpeg");// 设置图片格式
				OutputStream os = response.getOutputStream(); // 打开输出流
				if (picture == null) {// 没有图片
					return;
				} else { // 有图片
					os.write(picture); // 输出图片
				}
				os.flush();
				os.close();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();// 对象.方法
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
