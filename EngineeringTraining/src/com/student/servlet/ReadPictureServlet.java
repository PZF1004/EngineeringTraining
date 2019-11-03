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
		// ���ݴ���ʱ�ı���
		request.setCharacterEncoding("utf-8");// �������
		response.setCharacterEncoding("utf-8");// ��Ӧ����
		// ������ʾʱ�ı���
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
				response.setContentType("image/jpeg");// ����ͼƬ��ʽ
				OutputStream os = response.getOutputStream(); // �������
				if (picture == null) {// û��ͼƬ
					return;
				} else { // ��ͼƬ
					os.write(picture); // ���ͼƬ
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
					pstmt.close();// ����.����
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
