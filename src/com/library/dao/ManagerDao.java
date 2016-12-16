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
	 * 管理员登录
	 * 
	 * @param managerAccount
	 *            管理员账号
	 * @param managerPassword
	 *            密码
	 * @return 是否登录成功
	 */
	public boolean login(String managerAccount, String managerPassword) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_MANAGER
				+ " where ManagerAccount=? and ManagerPassword=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, managerAccount);
			mStatement.setString(2, managerPassword);
			mResultSet = mStatement.executeQuery();
			if (mResultSet.next()) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return isSuccess;
	}

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
	 * 根据账号获取管理员
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

	/**
	 * 添加管理员
	 * 
	 * @param managerAccount
	 *            账号
	 * @param managerPassword
	 *            密码
	 * @param managerName
	 *            姓名
	 * @param managerPhone
	 *            联系方式
	 * @param managerDuty
	 *            职责
	 * @return 是否添加成功
	 */
	public boolean addManager(String managerAccount, String managerPassword,
			String managerName, String managerPhone, String managerDuty) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into "
				+ TableUtill.TABLE_NAME_MANAGER
				+ "(ManagerAccount,ManagerPassword,ManagerName,ManagerPhone,ManagerDuty) values(?,?,?,?,?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, managerAccount);
			mStatement.setString(2, managerPassword);
			mStatement.setString(3, managerName);
			mStatement.setString(4, managerPhone);
			mStatement.setString(5, managerDuty);
			int lines = mStatement.executeUpdate();
			if (lines == 1) {
				isSuccess = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return isSuccess;
	}

	/**
	 * 删除管理员
	 * 
	 * @param managerAccount
	 *            管理员账号
	 * @return 是否删除成功
	 */
//	public boolean deleteManager(String managerAccount, String managerPassword) {
//		boolean isSuccess = false;
//
//		mConnection = DBUtil.getConnection();
//		String sql = "select * from " + TableUtill.TABLE_NAME_MANAGER
//				+ " where ManagerAccount=? and ManagerPassword=? limit 1";
//		try {
//			mStatement = mConnection.prepareStatement(sql);
//			mStatement.setString(1, managerAccount);
//			mStatement.setString(2, managerPassword);
//			mResultSet = mStatement.executeQuery();
//			if (mResultSet.next()) {
//				isSuccess = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.close(mStatement, mConnection, mResultSet);
//		}
//		return isSuccess;
//	}
}
