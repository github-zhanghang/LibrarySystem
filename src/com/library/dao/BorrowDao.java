package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.BorrowBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class BorrowDao {
	// 分页查询时每页显示的数量
	private final int NUM_PERPAGE = 15;

	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 获取所有借阅记录
	 * 
	 * @param currentPage
	 *            页码
	 * 
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getBorrowingRecord(int currentPage) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BORROW
				+ " limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, (currentPage - 1) * NUM_PERPAGE);
			mStatement.setInt(2, (currentPage) * NUM_PERPAGE);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String borrowId = mResultSet.getString(1);
				String readerAccount = mResultSet.getString(2);
				String bookName = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);
				String returnTime = mResultSet.getString(5);

				borrowList.add(new BorrowBean(borrowId, readerAccount,
						bookName, borrowTime, returnTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return borrowList;
	}

	/**
	 * 获取读者的借阅记录
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param currentPage
	 *            页码
	 * 
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getBorrowingRecordByAccount(String readerAccount,
			int currentPage) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReaderAccount=? limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mStatement.setInt(2, (currentPage - 1) * NUM_PERPAGE);
			mStatement.setInt(3, (currentPage) * NUM_PERPAGE);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String borrowId = mResultSet.getString(1);
				String bookName = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);
				String returnTime = mResultSet.getString(5);

				borrowList.add(new BorrowBean(borrowId, readerAccount,
						bookName, borrowTime, returnTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return borrowList;
	}

	/**
	 * 获取尚未归还的借阅记录(分页)
	 * 
	 * @param page
	 *            分页页码(大于等于1)
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getUnreturnedBorrowingRecord(int page) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		if (page < 1) {
			return null;
		}
		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReturnTime<BorrowTime limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, (page - 1) * NUM_PERPAGE);
			mStatement.setInt(2, page * NUM_PERPAGE);

			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String borrowId = mResultSet.getString(1);
				String readerAccount = mResultSet.getString(2);
				String bookName = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);
				String returnTime = mResultSet.getString(5);

				borrowList.add(new BorrowBean(borrowId, readerAccount,
						bookName, borrowTime, returnTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return borrowList;
	}

	/**
	 * 获取借阅超时并且尚未归还的借阅记录(分页)
	 * 
	 * @param maxDay
	 *            最大借阅时间(天)
	 * @param page
	 *            分页页码(大于等于1)
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getOverdueAndUnreturnedBorrowingRecord(int maxDay,
			int page) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		if (page < 1) {
			return null;
		}
		mConnection = DBUtil.getConnection();
		String sql = "select * from "
				+ TableUtill.TABLE_NAME_BORROW
				+ " where ReturnTime<BorrowTime and adddate(BorrowTime,interval ? day)>now() limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, maxDay);
			mStatement.setInt(2, (page - 1) * NUM_PERPAGE);
			mStatement.setInt(3, page * NUM_PERPAGE);

			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String borrowId = mResultSet.getString(1);
				String readerAccount = mResultSet.getString(2);
				String bookName = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);
				String returnTime = mResultSet.getString(5);

				borrowList.add(new BorrowBean(borrowId, readerAccount,
						bookName, borrowTime, returnTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return borrowList;
	}

	/**
	 * 添加借阅记录(借书)
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param bookNames
	 *            借阅的书籍名称集合
	 * @return 是否添加成功
	 */
	public boolean borrowBooks(String readerAccount, List<String> bookNames) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into " + TableUtill.TABLE_NAME_BORROW
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
	 * 还书
	 * 
	 * @param readerAccount
	 *            读者id
	 * @param bookName
	 *            书籍id
	 * @param returnTime
	 *            还书时间(格式举例:2016-12-02 14:39:15)
	 * @return 还书是否成功
	 */
	public boolean returnBook(String readerAccount, String bookName,
			String returnTime) {
		boolean isSuccess = false;
		// 判断时间格式是否正确
		try {
			new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(returnTime);
		} catch (ParseException e2) {
			e2.printStackTrace();
			return false;
		}

		mConnection = DBUtil.getConnection();
		try {
			// 更新borrow表
			String sql = "update "
					+ TableUtill.TABLE_NAME_BORROW
					+ " set ReturnTime=? where readerAccount=? and BookAccount=?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, returnTime);
			mStatement.setString(2, readerAccount);
			mStatement.setString(3, bookName);
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
