package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.engineering.entity.Student;
import com.engineering.service.IStudentService;
import com.engineering.service.impl.StudentServiceImpl;

public class UpdateStudentServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStudentServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 数据传输时的编码
		request.setCharacterEncoding("utf-8");// 请求编码
		response.setCharacterEncoding("utf-8");// 响应编码
		// 数据显示时的编码
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();// 响应对象
		// 上传
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) { // 判断前台的form是否有 mutipart属性
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 通过parseRequest解析form中的所有请求字段，并保存到 items集合中
				List<FileItem> items = upload.parseRequest(request);
				// 遍历items中的数据（item=sno sname spicture）
				Iterator<FileItem> iter = items.iterator();
				String stuno = null;
				String name = null;
				String sex = null;
				String phone = null;
				String dept = null;
				String classID = null;
				String labID = null;
				String position = null;
				String gameExperience = null;
				String winInformation = null;
				String employmentUnit = null;
				String performance = null;
				String entryTime = null;
				String graduationTime = null;
				String fileName = null;
				String no = request.getParameter("no");
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					switch (itemName) {
					case "stuno":
						stuno = item.getString("UTF-8");
						break;
					case "name":
						name = item.getString("UTF-8");
						break;
					case "sex":
						sex = item.getString("UTF-8");
						break;
					case "phone":
						phone = item.getString("UTF-8");
						break;
					case "dept":
						dept = item.getString("UTF-8");
						break;
					case "classID":
						classID = item.getString("UTF-8");
						break;
					case "labID":
						labID = item.getString("UTF-8");
						break;
					case "position":
						position = item.getString("UTF-8");
						break;
					case "gameExperience":
						gameExperience = item.getString("UTF-8");
						break;
					case "winInformation":
						winInformation = item.getString("UTF-8");
						break;
					case "employmentUnit":
						employmentUnit = item.getString("UTF-8");
						break;
					case "performance":
						performance = item.getString("UTF-8");
						break;
					case "entryTime":
						String temp = item.getString("UTF-8");
						entryTime = (temp.equals("")) ? "1111-11-11" : temp;
						break;
					case "graduationTime":
						String temp2 = item.getString("UTF-8");
						graduationTime = (temp2.equals("")) ? "1111-11-11" : temp2;
						break;
					default:
						fileName = item.getName();
						break;
					}
				}
				Student student = new Student(stuno, name, sex, phone, dept, classID, labID, position, gameExperience,
						winInformation, employmentUnit, performance, entryTime, graduationTime, fileName);
				IStudentService service = new StudentServiceImpl();
				boolean result = service.updateStudent2(no, student);

				if (!result) {
					out.println("修改失败");
					response.setHeader("refresh", "2;URL=page/UpdateStudent.jsp");
				} else {
					out.println("修改成功");
					// response.setHeader("refresh", "2;URL=QueryAllStudentByPageServlet");
					response.setHeader("refresh", "2;URL=QueryAllStudentByPageServlet");

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
		doGet(request, response);
	}

}
