package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.bean.BorrowBean;
import com.library.bean.ReaderBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class BorrowDao {
	// 分页查询是每页显示的数量
	private final int NUM_PERPAGE = 15;

	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 获取读者的借阅记录
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getBorrowingRecord(String readerAccount) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		ReaderBean readerBean = new ReaderDao()
				.getReaderByAccount(readerAccount);
		if (readerBean == null) {
			return null;
		} else {
			// 根据readerAccount获取readerId
			String readerId = readerBean.getReaderId();
			mConnection = DBUtil.getConnection();
			String sql = "select * from " + TableUtill.TABLE_NAME_BORROW
					+ " where ReaderID=?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setString(1, readerId);
				mResultSet = mStatement.executeQuery();
				while (mResultSet.next()) {
					String borrowId = mResultSet.getString(1);
					String bookId = mResultSet.getString(3);
					String borrowTime = mResultSet.getString(4);
					String returnTime = mResultSet.getString(5);

					// 根据bookId获取bookName
					String bookName = new BookDetailDao().getBooksById(bookId)
							.getBookName();
					borrowList.add(new BorrowBean(borrowId, readerAccount,
							bookName, borrowTime, returnTime));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(mStatement, mConnection, mResultSet);
			}
		}
		return borrowList;
	}

	/**
	 * 获取借阅超时的借阅记录(分页)
	 * 
	 * @param maxDay
	 *            最大借阅时间(天)
	 * @param page
	 *            分页页码(大于等于1)
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getOverdueBorrowingRecord(int maxDay, int page) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		if (page < 1) {
			return null;
		}
		mConnection = DBUtil.getConnection();
		String sql = "select * from "
				+ TableUtill.TABLE_NAME_BORROW
				+ " where ReturnTime>BorrowTime and adddate(BorrowTime,interval ? day)>now() limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, maxDay);
			mStatement.setInt(2, (page - 1) * NUM_PERPAGE);
			mStatement.setInt(3, page * NUM_PERPAGE);

			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String borrowId = mResultSet.getString(1);
				String readerAccount = mResultSet.getString(2);
				String bookId = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);
				String returnTime = mResultSet.getString(5);

				// 根据bookId获取bookName
				String bookName = new BookDetailDao().getBooksById(bookId)
						.getBookName();
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
	 * @param readerId
	 *            读者id
	 * @param bookId
	 *            书籍id
	 * @return 是否添加成功
	 */
	public boolean addBorrowingRecord(String readerId, String bookId) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into " + TableUtill.TABLE_NAME_BORROW
				+ "(ReaderID,BookID) values(?,?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerId);
			mStatement.setString(2, bookId);
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
	 * 还书
	 * 
	 * @param readerId
	 *            读者id
	 * @param bookId
	 *            书籍id
	 * @param returnTime
	 *            还书时间(格式举例:2016-12-02 14:39:15)
	 * @return 还书是否成功
	 */
	public boolean returnBook(String readerId, String bookId, String returnTime) {
		boolean isSuccess = true;
		// 判断时间格式是否正确
		try {
			new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(returnTime);
		} catch (ParseException e2) {
			e2.printStackTrace();
			return false;
		}

		PreparedStatement statement2 = null;
		mConnection = DBUtil.getConnection();
		try {
			// 取消自动提交，JDBC中默认是true，自动提交事务
			mConnection.setAutoCommit(false);

			// 更新borrow表
			String sql = "update " + TableUtill.TABLE_NAME_BORROW
					+ " set ReturnTime=? where readerID=? and BookID=?";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, returnTime);
			mStatement.setString(2, readerId);
			mStatement.setString(3, bookId);
			mStatement.executeUpdate();

			// 更新books表
			String sql2 = "update " + TableUtill.TABLE_NAME_BOOK
					+ " set IsBorrowed=1 where BookID=?";
			statement2 = mConnection.prepareStatement(sql2);
			statement2.setString(1, bookId);
			statement2.executeUpdate();

			// 提交事务
			mConnection.commit();
		} catch (SQLException e1) {
			isSuccess = false;
			try {
				mConnection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				isSuccess = false;
			}
			e1.printStackTrace();
		} finally {
			try {
				// 恢复自动提交
				mConnection.setAutoCommit(true);
				if (statement2 != null) {
					statement2.close();
				}
				DBUtil.close(mStatement, mConnection, mResultSet);
			} catch (SQLException e) {
				e.printStackTrace();
				isSuccess = false;
			}
		}
		return isSuccess;
	}

}
