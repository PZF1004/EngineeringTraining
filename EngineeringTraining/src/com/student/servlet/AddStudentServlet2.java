package com.student.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AddStudentServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:mysql://localhost:3306/engineering_training";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	Connection connection = null;
	PreparedStatement pstmt = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ݴ���ʱ�ı���
		request.setCharacterEncoding("utf-8");// �������
		response.setCharacterEncoding("utf-8");// ��Ӧ����
		// ������ʾʱ�ı���
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();// ��Ӧ����
		// �ϴ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "insert into student(stuno,name,sex,phone,dept,classID,labID,position,gameExperience,winInformation,employmentUnit,performance,picture) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) { // �ж�ǰ̨��form�Ƿ��� mutipart����
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				int count = 0;
				InputStream is = null;
				// ͨ��parseRequest����form�е����������ֶΣ������浽 items������
				List<FileItem> items = upload.parseRequest(request);
				// ����items�е����ݣ�item=sno sname spicture��
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();// getFieldName�ǻ�ȡ��ͨ���ֶε�Nameֵ
					// �ж�ǰ̨�ֶ� ����ͨform���ֶ�(sno sname)�������ļ��ֶ�

					switch (itemName) {
					case "stuno":
						String stuno = item.getString("UTF-8");
						pstmt.setString(1, stuno);
						break;
					case "name":
						String name = item.getString("UTF-8");
						pstmt.setString(2, name);
						break;
					case "sex":
						String sex = item.getString("UTF-8");
						pstmt.setString(3, sex);
						break;
					case "phone":
						String phone = item.getString("UTF-8");
						pstmt.setString(4, phone);
						break;
					case "dept":
						String dept = item.getString("UTF-8");
						pstmt.setString(5, dept);
						break;
					case "classID":
						String classID = item.getString("UTF-8");
						pstmt.setString(6, classID);
						break;
					case "labID":
						String labID = item.getString("UTF-8");
						pstmt.setString(7, labID);
						break;
					// case "entryTime":
					// String entryTime = item.getString("UTF-8");
					// pstmt.setString(8, entryTime);
					// break;
					case "position":
						String position = item.getString("UTF-8");
						pstmt.setString(8, position);
						break;
					case "gameExperience":
						String gameExperience = item.getString("UTF-8");
						pstmt.setString(9, gameExperience);
						break;
					case "winInformation":
						String winInformation = item.getString("UTF-8");
						pstmt.setString(10, winInformation);
						break;
					// case "graduationTime":
					// String graduationTime = item.getString("UTF-8");
					// pstmt.setString(12, graduationTime);
					// break;
					case "employmentUnit":
						String employmentUnit = item.getString("UTF-8");
						pstmt.setString(11, employmentUnit);
						break;
					case "performance":
						String performance = item.getString("UTF-8");
						pstmt.setString(12, performance);
						break;
					default:
						String fileName = item.getName();
						File file = new File(fileName);
						is = new FileInputStream(file);
						pstmt.setBinaryStream(13, is);
						break;
					}
				}
				count = pstmt.executeUpdate();
				is.close();
				if (count > 0) {
					out.println("�ļ����ӳɹ�");
					System.out.println("�ϴ��ɹ���");
					response.setHeader("refresh", "3;URL=QueryAllStudentServlet");
				} else {
					out.println("�ļ�����ʧ��");
					System.out.println("ʧ��");
					response.setHeader("refresh", "3;URL=page/InsertStudent.jsp");
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
