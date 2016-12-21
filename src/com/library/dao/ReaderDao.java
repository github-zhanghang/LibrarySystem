package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.ReaderBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class ReaderDao {
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 读者登录
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param readerPassword
	 *            密码
	 * @return 是否登录成功
	 */
	public boolean login(String readerAccount, String readerPassword) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_READER
				+ " where ReaderAccount=? and ReaderPassword=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mStatement.setString(2, readerPassword);
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
	 * 根据账号获取读者
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @return 读者对象
	 */
	public ReaderBean getReaderByAccount(String readerAccount) {
		ReaderBean readerBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_READER
				+ " where ReaderAccount=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String readerId = mResultSet.getString(1);
				String readerPassword = mResultSet.getString(3);
				String readerName = mResultSet.getString(4);
				String readerPhone = mResultSet.getString(5);
				String createTime = mResultSet.getString(6);
				int isEnable = mResultSet.getInt(7);
				readerBean = new ReaderBean(readerId, readerAccount,
						readerPassword, readerName, readerPhone, createTime,
						isEnable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return readerBean;
	}

	/**
	 * 根据Id获取读者
	 * 
	 * @param readerId
	 *            读者Id
	 * @return 读者对象
	 */
	public ReaderBean getReaderById(String readerId) {
		ReaderBean readerBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_READER
				+ " where ReaderID=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerId);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String readerAccount = mResultSet.getString(2);
				String readerPassword = mResultSet.getString(3);
				String readerName = mResultSet.getString(4);
				String readerPhone = mResultSet.getString(5);
				String createTime = mResultSet.getString(6);
				int isEnable = mResultSet.getInt(7);
				readerBean = new ReaderBean(readerId, readerAccount,
						readerPassword, readerName, readerPhone, createTime,
						isEnable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return readerBean;
	}

	/**
	 * 添加读者（注册）
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param readerPassword
	 *            读者密码
	 * @param readerName
	 *            读者姓名
	 * @param readerPhone
	 *            读者联系方式
	 * @return 操作是否成功
	 */
	public boolean addReader(String readerAccount, String readerPassword,
			String readerName, String readerPhone) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into "
				+ TableUtill.TABLE_NAME_READER
				+ "(ReaderAccount,ReaderPassword,ReaderName,ReaderPhone) values(?,?,?,?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mStatement.setString(2, readerPassword);
			mStatement.setString(3, readerName);
			mStatement.setString(4, readerPhone);
			int lines = mStatement.executeUpdate();// 受影响行数
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
	 * 删除读者(如果该读者有过借书情况，则不可删除)
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @return 是否删除成功
	 */
	public boolean deleteReader(String readerAccount) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "delete from " + TableUtill.TABLE_NAME_READER
				+ " where ReaderAccount=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
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
	 * 是否封禁(解禁)读者
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param isEnable
	 *            1表示解除封禁，0表示封禁(该读者不可借阅书籍)
	 * @return 操作是否成功
	 */
	public boolean setReaderEnabled(String readerAccount, int isEnable) {
		boolean isSuccess = false;
		if (isEnable == 0 || isEnable == 1) {
			mConnection = DBUtil.getConnection();
			String sql = "update " + TableUtill.TABLE_NAME_READER
					+ " set IsEnable=? where ReaderAccount=?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, isEnable);
				mStatement.setString(2, readerAccount);
				int lines = mStatement.executeUpdate();// 受影响行数
				if (lines == 1) {
					isSuccess = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(mStatement, mConnection, mResultSet);
			}
		}
		return isSuccess;
	}

	/**
	 * 修改读者信息
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param newReaderName
	 *            新姓名
	 * @param newReaderPhone
	 *            新联系方式
	 * @return 操作是否成功
	 */
	public boolean updateReader(String readerAccount, String newReaderName,
			String newReaderPhone) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "update " + TableUtill.TABLE_NAME_READER
				+ " setReaderName=?,ReaderPhone=? where ReaderAccount=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, newReaderName);
			mStatement.setString(2, newReaderPhone);
			mStatement.setString(3, readerAccount);
			int lines = mStatement.executeUpdate();// 受影响行数
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
	 * 查询所有读者
	 * 
	 * @param page
	 *            分页的页码
	 * @return 读者对象
	 */
	public List<ReaderBean> getAllReaders(int currentPage) {
		List<ReaderBean> readerList = new ArrayList<ReaderBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_READER
				+ " limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, (currentPage - 1) * 15);
			mStatement.setInt(2, (currentPage) * 15);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String readerId = mResultSet.getString(1);
				String readerAccount = mResultSet.getString(2);
				String readerPassword = mResultSet.getString(3);
				String readerName = mResultSet.getString(4);
				String readerPhone = mResultSet.getString(5);
				String createTime = mResultSet.getString(6);
				int isEnable = mResultSet.getInt(7);

				readerList.add(new ReaderBean(readerId, readerAccount,
						readerPassword, readerName, readerPhone, createTime,
						isEnable));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return readerList;
	}
}
