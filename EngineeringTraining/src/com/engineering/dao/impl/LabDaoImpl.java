package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.ILabDao;
import com.engineering.entity.Lab;
import com.engineering.util.DBUtil;

public class LabDaoImpl implements ILabDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 添加实验室
	public boolean addLab(Lab lab) {
		String sql = "insert into lab(labID,labName,labPlace,labTime,Introduction) values(?,?,?,?,?)";
		Object[] params = { lab.getLabID(), lab.getLabName(), lab.getLabPlace(), lab.getLabTime(),
				lab.getIntroduction() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 将实验室信息添加到回收表，同时删除此条记录
	public boolean deleteLab(String labID) {
		boolean flag1 = false;
		boolean flag2 = false;
		String sql1 = "insert into lab_recycle select * from lab where labID=?";
		String sql2 = "delete from lab where labID = ?";
		Object[] params = { labID };
		flag1 = DBUtil.executeUpdate(sql1, params);
		flag2 = DBUtil.executeUpdate(sql2, params);
		if (flag1 && flag2) {
			return true;
		} else {
			return false;
		}
	}

	// 修改实验室信息
	public boolean updateLab(String no, Lab lab) {
		System.out.println("update  " + lab.getLabID() + " " + lab.getLabName() + " " + lab.getLabPlace() + " "
				+ lab.getLabTime() + lab.getIntroduction());
		System.out.println("no-----" + no);
		String sql = "update lab set labID=?,labName=?,labPlace=?,labTime=?,Introduction=? where labID=?";
		Object[] params = { lab.getLabID(), lab.getLabName(), lab.getLabPlace(), lab.getLabTime(),
				lab.getIntroduction(), no };
		return DBUtil.executeUpdate(sql, params);
	}

	// 根据实验室编号查询实验室是否存在
	public boolean isExist(String labID) {
		return queryLab(labID) == null ? false : true;
	}

	// 根据实验室编号查询实验室信息
	public Lab queryLab(String labID) {
		Lab lab = null;
		try {
			String sql = "select * from lab where labID=?";
			Object[] params = { labID };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String labName = rs.getString("labName");
				String labPlace = rs.getString("labPlace");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("labTime"));
				String Introduction = rs.getString("Introduction");
				lab = new Lab(labID, labName, labPlace, timestamp, Introduction);
			}
			return lab;
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

	// 查询全部读者(通过List集合)
	public List<Lab> queryAllLabs() {
		List<Lab> labs = new ArrayList<>();
		Lab lab = null;
		try {
			String sql = "select * from lab";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String labID = rs.getString("labID");
				String labName = rs.getString("labName");
				String labPlace = rs.getString("labPlace");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("labTime"));
				String Introduction = rs.getString("Introduction");
				lab = new Lab(labID, labName, labPlace, timestamp, Introduction);
				labs.add(lab);
			}
			return labs;
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
