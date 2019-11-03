package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.IRecycleStudentDao;
import com.engineering.entity.Student;
import com.engineering.util.DBUtil;

public class RecycleStudentDaoImpl implements IRecycleStudentDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 从回收站中彻底删除学生
	public boolean deleteRecycleStudent(String stuno) {
		String sql = "delete from student_recycle where stuno = ?";
		Object[] params = { stuno };
		return DBUtil.executeUpdate(sql, params);
	}

	// 从回收站中恢复学生
	public boolean recoverStudent(String stuno) {
		boolean flag1 = false;
		boolean flag2 = false;
		String sql1 = "insert into student select * from student_recycle where stuno=?";
		String sql2 = "delete from student_recycle where stuno = ?";
		Object[] params = { stuno };
		flag1 = DBUtil.executeUpdate(sql1, params);
		flag2 = DBUtil.executeUpdate(sql2, params);
		if (flag1 && flag2) {
			return true;
		} else {
			return false;
		}
	}

	// 根据学号查询学生表学生是否存在该信息
	public boolean isExistStudent(String stuno) {
		return queryStudent(stuno) == null ? false : true;
	}

	// 根据学号查询学生表中的学生信息
	public Student queryStudent(String stuno) {
		Student student = null;
		try {
			String sql = "select * from student where stuno=?";
			Object[] params = { stuno };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				// Timestamp timestamp = rs.getTimestamp("readerDate");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, dept, classID, labID, timestamp, position, gameExperience,
						winInformation, graduationTime, employmentUnit, performance);
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

	// 根据学号查询回收站中是否存在该信息
	public boolean isExistRecycleStudent(String stuno) {
		return queryRecycleStudent(stuno) == null ? false : true;
	}

	// 根据学号查询回收站中的学生信息
	public Student queryRecycleStudent(String stuno) {
		Student student = null;
		try {
			String sql = "select * from student_recycle where stuno=?";
			Object[] params = { stuno };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				// Timestamp timestamp = rs.getTimestamp("readerDate");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, dept, classID, labID, timestamp, position, gameExperience,
						winInformation, graduationTime, employmentUnit, performance);
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

	// 查询回收站中的全部学生信息(通过List集合)
	public List<Student> queryAllRecycleStudents() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		try {
			String sql = "select * from student_recycle";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String stuno = rs.getString("stuno");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String dept = rs.getString("dept");
				String classID = rs.getString("classID");
				String labID = rs.getString("labID");
				// Timestamp timestamp = rs.getTimestamp("readerDate");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("entryTime"));
				String position = rs.getString("position");
				String gameExperience = rs.getString("gameExperience");
				String winInformation = rs.getString("winInformation");
				String graduationTime = rs.getString("graduationTime");
				String employmentUnit = rs.getString("employmentUnit");
				String performance = rs.getString("performance");
				student = new Student(stuno, name, sex, dept, classID, labID, timestamp, position, gameExperience,
						winInformation, graduationTime, employmentUnit, performance);
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
