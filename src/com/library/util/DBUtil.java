package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String NAME = "root";
	private static final String PWD = "zhanghang";
	private static final String URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";

	static {
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到连接
	 */
	public static Connection getConnection() {
		// 获取连接
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, NAME, PWD);
			if (conn != null) {
				System.out.println("数据库连接成功");
			} else {
				System.out.println("数据库连接失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭连接
	 */
	public static void close(Statement statement, Connection connection,
			ResultSet resultSet) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
