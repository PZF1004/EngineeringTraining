package com.engineering.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.engineering.dao.IEquipmentDao;
import com.engineering.entity.Equipment;
import com.engineering.util.DBUtil;

public class EquipmentDaoImpl implements IEquipmentDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 添加设备
	public boolean addEquipment(Equipment equipment) {
		String sql = "insert into equipment(equipmentID,equipmentName,equipmentNumber,equipmentPlace,equipmentManager,equipmentPrice,equipmentStatus,introduction,equipmentTime) values(?,?,?,?,?,?,?,?,?)";
		Object[] params = { equipment.getEquipmentID(), equipment.getEquipmentName(), equipment.getEquipmentNumber(),
				equipment.getEquipmentPlace(), equipment.getEquipmentManager(), equipment.getEquipmentPrice(),
				equipment.getEquipmentStatus(), equipment.getIntroduction(), equipment.getEquipmentTime() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 将信息添加到回收表，同时删除此条记录
	public boolean deleteEquipment(String equipmentID) {
		boolean flag1 = false;
		boolean flag2 = false;
		String sql1 = "insert into equipment_recycle select * from equipment where equipmentID=?";
		String sql2 = "delete from equipment where equipmentID = ?";
		Object[] params = { equipmentID };
		flag1 = DBUtil.executeUpdate(sql1, params);
		flag2 = DBUtil.executeUpdate(sql2, params);
		if (flag1 && flag2) {
			return true;
		} else {
			return false;
		}

	}

	// 修改设备信息
	public boolean updateEquipment(String no, Equipment equipment) {
		String sql = "update equipment set equipmentID=?,equipmentName=?,equipmentNumber=?,equipmentPlace=?,equipmentManager=?,equipmentPrice=?,equipmentStatus=?,introduction=?,equipmentTime=? where equipmentID=?";
		Object[] params = { equipment.getEquipmentID(), equipment.getEquipmentName(), equipment.getEquipmentNumber(),
				equipment.getEquipmentPlace(), equipment.getEquipmentManager(), equipment.getEquipmentPrice(),
				equipment.getEquipmentStatus(), equipment.getIntroduction(), equipment.getEquipmentTime(), no };
		return DBUtil.executeUpdate(sql, params);
	}

	// 根据设备号查询设备是否存在
	public boolean isExist(String equipmentID) {
		return queryEquipment(equipmentID) == null ? false : true;
	}

	// 根据设备号查询设备信息
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

	// 查询全部设备信息(通过List集合)
	public List<Equipment> queryAllEquipments() {
		List<Equipment> equipments = new ArrayList<>();
		Equipment equipment = null;
		try {
			String sql = "select * from equipment";
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
