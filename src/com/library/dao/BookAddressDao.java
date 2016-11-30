package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.util.DBUtil;
import com.library.util.TableUtill;
import com.llibrary.bean.BookAddressBean;
import com.llibrary.bean.BookTypeBean;

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
	public BookAddressBean getShelfNameById(String shelfId) {
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
}
