package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.bean.ManagerBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class ManagerDao {
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 根据姓名获取管理员
	 * 
	 * @param managerName
	 *            管理员姓名
	 * @return 管理员对象
	 */
	public ManagerBean getManagerByName(String managerName) {
		ManagerBean managerBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_MANAGER
				+ " where ManagerName=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, managerName);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String managerId = mResultSet.getString(1);
				String managerAccount = mResultSet.getString(2);
				String managerPassword = mResultSet.getString(3);
				String managerPhone = mResultSet.getString(5);
				String managerDuty = mResultSet.getString(6);
				String createTime = mResultSet.getString(7);
				managerBean = new ManagerBean(managerId, managerAccount,
						managerPassword, managerName, managerPhone,
						managerDuty, createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return managerBean;
	}

	/**
	 * 根据账号获取管理员(登录)
	 * 
	 * @param managerAccount
	 *            管理员姓名
	 * @return 管理员对象
	 */
	public ManagerBean getManagerByAccount(String managerAccount) {
		ManagerBean managerBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_MANAGER
				+ " where ManagerAccount=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, managerAccount);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String managerId = mResultSet.getString(1);
				String managerPassword = mResultSet.getString(3);
				String managerName = mResultSet.getString(4);
				String managerPhone = mResultSet.getString(5);
				String managerDuty = mResultSet.getString(6);
				String createTime = mResultSet.getString(7);
				managerBean = new ManagerBean(managerId, managerAccount,
						managerPassword, managerName, managerPhone,
						managerDuty, createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return managerBean;
	}
}
