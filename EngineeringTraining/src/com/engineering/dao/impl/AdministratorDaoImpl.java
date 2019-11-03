package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.IAdministratorDao;
import com.engineering.entity.Administrator;
import com.engineering.util.DBUtil;

public class AdministratorDaoImpl implements IAdministratorDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// ��ӹ���Ա
	public boolean addAdministrator(Administrator administrator) {

		String sql = "insert into administrator(adminID,adminName,sex,dept,password,labID) values(?,?,?,?,?,?)";
		Object[] params = { administrator.getAdminID(), administrator.getAdminName(), administrator.getSex(),
				administrator.getDept(), administrator.getPassword(), administrator.getLabID() };
		return DBUtil.executeUpdate(sql, params);
	}

	// ����Ϣ��ӵ����ձ�ͬʱɾ��������¼
	public boolean deleteAdministrator(String adminID) {
		String sql = "delete from administrator where adminID = ?";
		Object[] params = { adminID };
		return DBUtil.executeUpdate(sql, params);
	}

	// �޸Ĺ���Ա��Ϣ
	public boolean updateAdministrator(String adminID, Administrator administrator) {
		String sql = "update administrator set adminID=?,adminName=?,sex=?,dept=?,password=?,labID=? where adminID=?";
		Object[] params = { administrator.getAdminID(), administrator.getAdminName(), administrator.getSex(),
				administrator.getDept(), administrator.getPassword(), administrator.getLabID(), adminID };
		return DBUtil.executeUpdate(sql, params);
	}

	// ���ݹ���Ա��Ų�ѯ����Ա�Ƿ����
	public boolean isExist(String adminID) {
		return queryAdministrator(adminID) == null ? false : true;
	}

	// ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	public Administrator queryAdministrator(String adminID) {
		Administrator administrator = null;
		try {
			String sql = "select * from administrator where adminID=?";
			Object[] params = { adminID };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String adminName = rs.getString("adminName");
				String sex = rs.getString("sex");
				String dept = rs.getString("dept");
				String password = rs.getString("password");
				String labID = rs.getString("labID");
				administrator = new Administrator(adminID, adminName, sex, dept, password, labID);
			}
			return administrator;
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

	// ��ѯȫ������Ա��Ϣ(ͨ��List����)
	public List<Administrator> queryAllAdministrators() {
		List<Administrator> administrators = new ArrayList<>();
		Administrator administrator = null;
		try {
			String sql = "select * from administrator";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String adminID = rs.getString("adminID");
				String adminName = rs.getString("adminName");
				String sex = rs.getString("sex");
				String dept = rs.getString("dept");
				String password = rs.getString("password");
				String labID = rs.getString("labID");
				administrator = new Administrator(adminID, adminName, sex, dept, password, labID);
				administrators.add(administrator);
			}
			return administrators;
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
