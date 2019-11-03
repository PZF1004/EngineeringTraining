package com.engineering.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//通用的数据库操作方法
//在DBUtil中增加static关键字，则可以直接通过类名调用
public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/engineering_training";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static PreparedStatement pstmt = null;
	public static Connection connection = null;
	public static ResultSet rs = null;
	static InputStream is = null;

	// 建立连接,获取连接对象
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载失败！驱动类没有找到！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！请检查数据库名以及用户帐号！");
		}
		return connection;
	}

	// 获取PreparedStatement，参数赋值
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) {
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);// 预编译
			if (params != null) { // 判断要传的参数数组是否为空
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);// 赋值
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	// 通用的增删改
	public static boolean executeUpdate(String sql, Object[] params) {
		try {
			pstmt = createPreparedStatement(sql, params);
			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, pstmt, connection);
		}
	}

	// 增加图片
	public static PreparedStatement createPreparedStatement2(String sql, Object[] params) {
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length - 1; i++) {
					pstmt.setObject(i + 1, params[i]);
					System.out.println((i + 1) + "params--" + params[i]);
				}
				System.out.println(params.length + "params文件--" + params[params.length - 1]);
				File file = new File((String) params[params.length - 1]);
				if (file.exists() && file.length() != 0) {// 如果文件存在
					is = new FileInputStream(file);
					pstmt.setBinaryStream(params.length, is);
					System.out.println("++++++++++++");
				} else {

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	// 增加图片
	public static boolean executeUpdate2(String sql, Object[] params) {
		try {
			pstmt = createPreparedStatement2(sql, params);
			int count = pstmt.executeUpdate();
			is.close();
			if (count > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, pstmt, connection);
		}
	}

	// 修改数据（图片）
	public static boolean executeUpdate3(String sql, Object[] params) {
		int count = 0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length - 2; i++) {
					pstmt.setObject(i + 1, params[i]);
					System.out.println((i + 1) + "params--" + params[i]);
				}
				System.out.println(params.length - 1 + "params文件--" + params[params.length - 2]);
				File file = new File((String) params[params.length - 2]);
				is = new FileInputStream(file);
				pstmt.setBinaryStream(params.length - 1, is);

				pstmt.setObject(params.length, params[params.length - 1]);
				count = pstmt.executeUpdate();
				is.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			closeAll(null, pstmt, connection);
		}
		if (count > 0)
			return true;
		else
			return false;
	}

	// 通用的查 :通用 表示 适合与 任何查询(不可关闭，否则得不到ResultSet结果集)
	public static ResultSet executeQuery(String sql, Object[] params) {// select xxx from xx where name=? or id=?
		try {
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 通用的：查询总数
	public static int getTotalCount(String sql) {// select count(*) from xx ;
		int count = -1;
		try {
			pstmt = createPreparedStatement(sql, null);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, connection);
		}
		return count;
	}

	// 通用的关闭（Statement是父类，父类关闭，则子类必定关闭）
	public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
