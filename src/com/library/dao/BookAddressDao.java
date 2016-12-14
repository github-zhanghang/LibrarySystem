package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.bean.BookAddressBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class BookAddressDao {
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 根据书架id获取书架信息
	 * 
	 * @param shelfId
	 *            书架Id
	 * @return 书架对象
	 */
	public BookAddressBean getShelfById(String shelfId) {
		BookAddressBean addressBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_SHELF
				+ " where ShelfID=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, shelfId);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String shelfName = mResultSet.getString(2);
				String createTime = mResultSet.getString(3);
				addressBean = new BookAddressBean(shelfId, shelfName,
						createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return addressBean;
	}

	/**
	 * 根据书架id获取书架信息
	 * 
	 * @param shelfName
	 *            书架名
	 * @return 书架对象
	 */
	public BookAddressBean getShelfByName(String shelfName) {
		BookAddressBean addressBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_SHELF
				+ " where ShelfName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, shelfName);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String shelfId = mResultSet.getString(1);
				String createTime = mResultSet.getString(3);
				addressBean = new BookAddressBean(shelfId, shelfName,
						createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return addressBean;
	}
}
