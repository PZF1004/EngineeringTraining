package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.IStudentDao;
import com.engineering.entity.Student;
import com.engineering.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 添加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student(stuno,name,sex,phone,url,dept,classID,labID,entryTime,position,gameExperience,winInformation,graduationTime,employmentUnit,performance) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Object[] params = { student.getStuno(), student.getName(), student.getSex(), student.getPhone(),
				student.getDept(), student.getClassID(), student.getLabID(), student.getEntryTime(),
				student.getPosition(), student.getGameExperience(), student.getWinInformation(),
				student.getGraduationTime(), student.getEmploymentUnit(), student.getPerformance() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 添加学生（图片）
	public boolean addStudent2(Student student) {
		String sql = "insert into student(stuno,name,sex,phone,dept,classID,labID,position,gameExperience,winInformation,employmentUnit,performance,entryTime,graduationTime,picture) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Object[] params = { student.getStuno(), student.getName(), student.getSex(), student.getPhone(),
				student.getDept(), student.getClassID(), student.getLabID(), student.getPosition(),
				student.getGameExperience(), student.getWinInformation(), student.getEmploymentUnit(),
				student.getPerformance(), student.getEntryTime(), student.getGraduationTime(), student.getPicture() };
		return DBUtil.executeUpdate2(sql, params);
	}

	// 将信息添加到回收表，同时在学生表中删除此条记录
	public boolean deleteStudent(String stuno) {
		boolean flag1 = false;
		boolean flag2 = false;
		String sql1 = "insert into student_recycle select * from student where stuno=?";
		String sql2 = "delete from student where stuno = ?";
		Object[] params = { stuno };
		flag1 = DBUtil.executeUpdate(sql1, params);
		flag2 = DBUtil.executeUpdate(sql2, params);
		if (flag1 && flag2) {
			return true;
		} else {
			return false;
		}
	}

	// 修改学生信息
	public boolean updateStudent(String no, Student student) {
		String sql = "update student set stuno=?,name=?,sex=?,phone,dept=?,classID=?,labID=?,entryTime=?,position=?,gameExperience=?,winInformation=?,graduationTime=?,employmentUnit=?,performance=? where stuno=?";
		Object[] params = { student.getStuno(), student.getName(), student.getSex(), student.getPhone(),
				student.getDept(), student.getClassID(), student.getLabID(), student.getEntryTime(),
				student.getPosition(), student.getGameExperience(), student.getWinInformation(),
				student.getGraduationTime(), student.getEmploymentUnit(), no, student.getPerformance() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 修改学生信息（图片）
	public boolean updateStudent2(String no, Student student) {
		String sql = "update student set stuno=?,name=?,sex=?,phone=?,dept=?,classID=?,labID=?,position=?,gameExperience=?,winInformation=?,employmentUnit=?,performance=?,entryTime=?,graduationTime=?,picture=? where stuno=?";
		Object[] params = { student.getStuno(), student.getName(), student.getSex(), student.getPhone(),
				student.getDept(), student.getClassID(), student.getLabID(), student.getPosition(),
				student.getGameExperience(), student.getWinInformation(), student.getEmploymentUnit(),
				student.getPerformance(), student.getEntryTime(), student.getGraduationTime(), student.getPicture(),
				no };
		return DBUtil.executeUpdate3(sql, params);
	}

	// 根据学号查询学生是否存在
	public boolean isExist(String stuno) {
		return queryStudent(stuno) == null ? false : true;
	}

	// 根据学号查询学生信息
	public Student queryStudent(String stuno) {
		Student student = null;
		try {
			String sql = "select * from student where stuno=?";
			Object[] params = { stuno };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, phone, dept, classID, labID, position, gameExperience,
						winInformation, employmentUnit, performance, timestamp, graduationTime);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 根据学号查询学生信息（图片）
	public Student queryStudent2(String stuno) {
		Student student = null;
		try {
			String sql = "select * from student where stuno=?";
			Object[] params = { stuno };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				String entryTime = rs.getString("entryTime");
				String graduationTime = rs.getString("graduationTime");
				// 图片
				byte[] picture = rs.getBytes("picture");
				String datas = null;
				if (picture == null) {
					datas = "";
				} else {
					datas = new String(picture, "UTF-8");
				}
				student = new Student(stuno, name, sex, phone, dept, classID, labID, position, gameExperience,
						winInformation, employmentUnit, performance, entryTime, graduationTime, datas);
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 根据实验室编号查询学生信息
	public List<Student> queryStudentInLab(String labID) {
		List<Student> students = new ArrayList<>();
		Student student = null;
		try {
			String sql = "select * from student where labID = ?";
			Object[] params = { labID };
			rs = DBUtil.executeQuery(sql, params);
			while (rs.next()) {
				String stuno = rs.getString("stuno");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, phone, dept, classID, labID, timestamp, position,
						gameExperience, winInformation, graduationTime, employmentUnit, performance);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 查询全部学生(通过List集合)
	public List<Student> queryAllStudents() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		try {
			String sql = "select * from student";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String stuno = rs.getString("stuno");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, phone, dept, classID, labID, timestamp, position,
						gameExperience, winInformation, graduationTime, employmentUnit, performance);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 查询当前页面的数据
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		// String sql = "select * from student order by stuno asc limit ?,?";
		String sql = "select * from student limit ?,?";
		Object[] params = { (currentPage - 1) * pageSize, pageSize };
		List<Student> students = new ArrayList<>();
		Student student = null;
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				String stuno = rs.getString("stuno");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, phone, dept, classID, labID, position, gameExperience,
						winInformation, employmentUnit, performance, timestamp, graduationTime);
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	// 查询总数据量
	public int getTotalCount() {
		String sql = "select count(1) from student";// count(1)效率更高
		return DBUtil.getTotalCount(sql);
	}

	// 搜索功能
	public List<Student> searchStudent(String search) {
		List<Student> students = new ArrayList<>();
		try {
			String sql = "select * from student where stuno like ? or name like ? or dept like ? or classID like ? or position like ? or winInformation like ? or employmentUnit like ? ";
			pstmt = DBUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setString(2, "%" + search + "%");
			pstmt.setString(3, "%" + search + "%");
			pstmt.setString(4, "%" + search + "%");
			pstmt.setString(5, "%" + search + "%");
			pstmt.setString(6, "%" + search + "%");
			pstmt.setString(7, "%" + search + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String stuno = rs.getString("stuno");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				Student student = new Student(stuno, name, sex, dept, classID, labID, timestamp, position,
						gameExperience, winInformation, graduationTime, employmentUnit, performance);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}

	// 查询全部学生，并且排序
	public List<Student> querySort(String type) {
		List<Student> students = new ArrayList<>();
		Student student = null;
		String sql;
		if (type.equals("classID")) {
			sql = "select * from student order by classID asc";
		} else if (type.equals("name")) {
			sql = "select * from student order by convert(name using gbk) COLLATE gbk_chinese_ci asc";
		} else {
			sql = "select * from student order by entryTime asc";
		}
		try {
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String stuno = rs.getString("stuno");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, phone, dept, classID, labID, timestamp, position,
						gameExperience, winInformation, graduationTime, employmentUnit, performance);
				students.add(student);
			}
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
}
