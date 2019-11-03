package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.IRecycleEquipmentDao;
import com.engineering.entity.Equipment;
import com.engineering.util.DBUtil;

public class RecycleEquipmentDaoImpl implements IRecycleEquipmentDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 从回收站中彻底删除设备信息
	public boolean deleteRecycleEquipment(String equipmentID) {
		String sql = "delete from equipment_recycle where equipmentID = ?";
		Object[] params = { equipmentID };
		return DBUtil.executeUpdate(sql, params);
	}

	// 从回收站中恢复设备信息
	public boolean recoverEquipment(String equipmentID) {
		boolean flag1 = false;
		boolean flag2 = false;
		String sql1 = "insert into equipment select * from equipment_recycle where equipmentID=?";
		String sql2 = "delete from equipment_recycle where equipmentID = ?";
		Object[] params = { equipmentID };
		flag1 = DBUtil.executeUpdate(sql1, params);
		flag2 = DBUtil.executeUpdate(sql2, params);
		if (flag1 && flag2) {
			return true;
		} else {
			return false;
		}
	}

	// 根据设备编号查询设备表中是否存在该信息
	public boolean isExistEquipment(String equipmentID) {
		return queryEquipment(equipmentID) == null ? false : true;
	}

	// 根据设备编号查询设备表中的信息
	public Equipment queryEquipment(String equipmentID) {
		Equipment equipment = null;
		try {
			String sql = "select * from equipment where equipmentID=?";
			Object[] params = { equipmentID };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String equipmentName = rs.getString("equipmentName");
				int equipmentNumber = rs.getInt("equipmentNumber");
				String equipmentPlace = rs.getString("equipmentPlace");
				String equipmentManager = rs.getString("equipmentManager");
				int equipmentPrice = rs.getInt("equipmentPrice");
				String equipmentStatus = rs.getString("equipmentStatus");
				String introduction = rs.getString("introduction");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("equipmentTime"));
				equipment = new Equipment(equipmentID, equipmentName, equipmentNumber, equipmentPlace, equipmentManager,
						equipmentPrice, equipmentStatus, introduction, timestamp);
			}
			return equipment;
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

	// 根据设备编号查询回收站中是否存在该信息
	public boolean isExistRecycleEquipment(String equipmentID) {
		return queryRecycleEquipment(equipmentID) == null ? false : true;
	}

	// 根据设备编号查询回收站中的设备信息
	public Equipment queryRecycleEquipment(String equipmentID) {
		Equipment equipment = null;
		try {
			String sql = "select * from equipment_recycle where equipmentID=?";
			Object[] params = { equipmentID };
			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				String equipmentName = rs.getString("equipmentName");
				int equipmentNumber = rs.getInt("equipmentNumber");
				String equipmentPlace = rs.getString("equipmentPlace");
				String equipmentManager = rs.getString("equipmentManager");
				int equipmentPrice = rs.getInt("equipmentPrice");
				String equipmentStatus = rs.getString("equipmentStatus");
				String introduction = rs.getString("introduction");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("equipmentTime"));
				equipment = new Equipment(equipmentID, equipmentName, equipmentNumber, equipmentPlace, equipmentManager,
						equipmentPrice, equipmentStatus, introduction, timestamp);
			}
			return equipment;
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

	// 查询回收站中的全部设备信息(通过List集合)
	public List<Equipment> queryAllRecycleEquipments() {
		List<Equipment> equipments = new ArrayList<>();
		Equipment equipment = null;
		try {
			String sql = "select * from equipment_recycle";
			rs = DBUtil.executeQuery(sql, null);
			while (rs.next()) {
				String equipmentID = rs.getString("equipmentID");
				String equipmentName = rs.getString("equipmentName");
				int equipmentNumber = rs.getInt("equipmentNumber");
				String equipmentPlace = rs.getString("equipmentPlace");
				String equipmentManager = rs.getString("equipmentManager");
				int equipmentPrice = rs.getInt("equipmentPrice");
				String equipmentStatus = rs.getString("equipmentStatus");
				String introduction = rs.getString("introduction");
				String timestamp = new SimpleDateFormat("yyyy-MM-dd").format(rs.getTimestamp("equipmentTime"));
				equipment = new Equipment(equipmentID, equipmentName, equipmentNumber, equipmentPlace, equipmentManager,
						equipmentPrice, equipmentStatus, introduction, timestamp);
				equipments.add(equipment);
			}
			return equipments;
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
