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

//ͨ�õ����ݿ��������
//��DBUtil������static�ؼ��֣������ֱ��ͨ����������
public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/engineering_training";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static PreparedStatement pstmt = null;
	public static Connection connection = null;
	public static ResultSet rs = null;
	static InputStream is = null;

	// ��������,��ȡ���Ӷ���
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�������û���ҵ���");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ��������ݿ����Լ��û��ʺţ�");
		}
		return connection;
	}

	// ��ȡPreparedStatement��������ֵ
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) {
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);// Ԥ����
			if (params != null) { // �ж�Ҫ���Ĳ��������Ƿ�Ϊ��
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);// ��ֵ
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	// ͨ�õ���ɾ��
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

	// ����ͼƬ
	public static PreparedStatement createPreparedStatement2(String sql, Object[] params) {
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length - 1; i++) {
					pstmt.setObject(i + 1, params[i]);
					System.out.println((i + 1) + "params--" + params[i]);
				}
				System.out.println(params.length + "params�ļ�--" + params[params.length - 1]);
				File file = new File((String) params[params.length - 1]);
				if (file.exists() && file.length() != 0) {// ����ļ�����
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

	// ����ͼƬ
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

	// �޸����ݣ�ͼƬ��
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
				System.out.println(params.length - 1 + "params�ļ�--" + params[params.length - 2]);
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

	// ͨ�õĲ� :ͨ�� ��ʾ �ʺ��� �κβ�ѯ(���ɹرգ�����ò���ResultSet�����)
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

	// ͨ�õģ���ѯ����
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

	// ͨ�õĹرգ�Statement�Ǹ��࣬����رգ�������ض��رգ�
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
