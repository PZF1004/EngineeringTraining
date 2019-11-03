package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.IRecycleLabDao;
import com.engineering.entity.Lab;
import com.engineering.util.DBUtil;

public class RecycleLabDaoImpl implements IRecycleLabDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// �ӻ���վ�г���ɾ��ʵ����
	public boolean deleteRecycleLab(String labID) {
		String sql = "delete from lab_recycle where labID = ?";
		Object[] params = { labID };
		return DBUtil.executeUpdate(sql, params);
	}

	// �ӻ���վ�лָ�ʵ����
	public boolean recoverLab(String labID) {
		boolean flag1 = false;
		boolean flag2 = false;
		String sql1 = "insert into lab select * from lab_recycle where labID=?";
		String sql2 = "delete from lab_recycle where labID = ?";
		Object[] params = { labID };
		flag1 = DBUtil.executeUpdate(sql1, params);
		flag2 = DBUtil.executeUpdate(sql2, params);
		if (flag1 && flag2) {
			return true;
		} else {
			return false;
		}
	}

	// ����ʵ���ұ�Ų�ѯʵ���ұ����Ƿ���ڸ�ʵ����
	public boolean isExistLab(String labID) {
		return queryLab(labID) == null ? false : true;
	}

	// ����ʵ���ұ�Ų�ѯʵ���ұ��е���Ϣ
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

	// ����ʵ���ұ�Ų�ѯ����վ���Ƿ���ڸ�ʵ����
	public boolean isExistRecycleLab(String labID) {
		return queryRecycleLab(labID) == null ? false : true;
	}

	// ����ʵ���ұ�Ų�ѯ����վ��ʵ���ҵ���Ϣ
	public Lab queryRecycleLab(String labID) {
		Lab lab = null;
		try {
			String sql = "select * from lab_recycle where labID=?";
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

	// ��ѯ����վ��ȫ��ʵ������Ϣ(ͨ��List����)
	public List<Lab> queryAllRecycleLabs() {
		List<Lab> labs = new ArrayList<>();
		Lab lab = null;
		try {
			String sql = "select * from lab_recycle";
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
