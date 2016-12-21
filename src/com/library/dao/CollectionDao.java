package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.CollectionBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class CollectionDao {
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 获取读者的收藏记录
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @return 收藏对象集合
	 */
	public List<CollectionBean> getCollectionRecord(String readerAccount) {
		List<CollectionBean> collectionList = new ArrayList<CollectionBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_COLLECTION
				+ " where ReaderAccount=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String collectionId = mResultSet.getString(1);
				String bookName = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);

				collectionList.add(new CollectionBean(collectionId,
						readerAccount, bookName, borrowTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return collectionList;
	}

	/**
	 * 添加收藏记录
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param bookNames
	 *            收藏的书籍名称集合
	 * @return 是否添加成功
	 */
	public boolean collectBooks(String readerAccount, List<String> bookNames) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into " + TableUtill.TABLE_NAME_COLLECTION
				+ "(ReaderAccount,BookName) values";
		for (int i = 0; i < bookNames.size(); i++) {
			sql += "('" + readerAccount + "','" + bookNames.get(i) + "')";
			if (i != bookNames.size() - 1) {
				sql += ",";
			}
		}
		try {
			mStatement = mConnection.prepareStatement(sql);
			int lines = mStatement.executeUpdate();
			if (lines == bookNames.size()) {
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
	 * 删除一条收藏记录
	 * 
	 * @param collectionId
	 * @return
	 */
	public boolean deleteCollection(String collectionId) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		try {
			String sql = "delete from " + TableUtill.TABLE_NAME_COLLECTION
					+ " where CollectionID=?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, collectionId);
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
}
