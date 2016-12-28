package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.library.bean.BorrowBean;
import com.library.bean.ReaderBean;
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

				ReaderBean readerBean = new ReaderDao()
						.getReaderByAccount(readerAccount);
				int isOverdue = judgeIsOverdue(borrowTime);
				int isReturned = judgeIsReturned(borrowTime, returnTime);
				borrowList
						.add(new BorrowBean(borrowId, readerBean, bookName,
								borrowTime, returnTime, "" + isReturned, ""
										+ isOverdue));
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

				ReaderBean readerBean = new ReaderDao()
						.getReaderByAccount(readerAccount);
				int isOverdue = judgeIsOverdue(borrowTime);
				int isReturned = judgeIsReturned(borrowTime, returnTime);
				borrowList
						.add(new BorrowBean(borrowId, readerBean, bookName,
								borrowTime, returnTime, "" + isReturned, ""
										+ isOverdue));
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
	 * @param value
	 *            读者账号或书名
	 * @param currentPage
	 *            页码
	 * 
	 * @return 借阅记录对象集合
	 */
	public List<BorrowBean> getBorrowingRecordByAccountOrBookName(String value,
			int currentPage) {
		List<BorrowBean> borrowList = new ArrayList<BorrowBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReaderAccount=? or BookName=? limit ?,?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, value);
			mStatement.setString(2, value);
			mStatement.setInt(3, (currentPage - 1) * NUM_PERPAGE);
			mStatement.setInt(4, (currentPage) * NUM_PERPAGE);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String borrowId = mResultSet.getString(1);
				String readerAccount = mResultSet.getString(2);
				String bookName = mResultSet.getString(3);
				String borrowTime = mResultSet.getString(4);
				String returnTime = mResultSet.getString(5);

				ReaderBean readerBean = new ReaderDao()
						.getReaderByAccount(readerAccount);
				int isOverdue = judgeIsOverdue(borrowTime);
				int isReturned = judgeIsReturned(borrowTime, returnTime);
				borrowList
						.add(new BorrowBean(borrowId, readerBean, bookName,
								borrowTime, returnTime, "" + isReturned, ""
										+ isOverdue));
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

				ReaderBean readerBean = new ReaderDao()
						.getReaderByAccount(readerAccount);
				int isOverdue = judgeIsOverdue(borrowTime);
				int isReturned = judgeIsReturned(borrowTime, returnTime);
				borrowList
						.add(new BorrowBean(borrowId, readerBean, bookName,
								borrowTime, returnTime, "" + isReturned, ""
										+ isOverdue));
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

				ReaderBean readerBean = new ReaderDao()
						.getReaderByAccount(readerAccount);
				int isOverdue = judgeIsOverdue(borrowTime);
				int isReturned = judgeIsReturned(borrowTime, returnTime);
				borrowList
						.add(new BorrowBean(borrowId, readerBean, bookName,
								borrowTime, returnTime, "" + isReturned, ""
										+ isOverdue));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return borrowList;
	}

	/**
	 * 判断书籍是否归还
	 * 
	 * @return 是否归还
	 */
	public boolean isReturned(String readerAccount, String bookName) {
		boolean isSuccess = true;

		mConnection = DBUtil.getConnection();
		String sql = "select * from "
				+ TableUtill.TABLE_NAME_BORROW
				+ " where ReturnTime<BorrowTime and ReaderAccount=? and BookName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mStatement.setString(2, bookName);
			mResultSet = mStatement.executeQuery();
			if (mResultSet.next()) {
				isSuccess = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return isSuccess;
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
	 * @return 还书是否成功
	 */
	public boolean returnBook(String readerAccount, String bookName) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		try {
			// 更新borrow表
			String sql = "update "
					+ TableUtill.TABLE_NAME_BORROW
					+ " set ReturnTime=now() where readerAccount=? and BookName=? and ReturnTime<BorrowTime";
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mStatement.setString(2, bookName);
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
	 * 判断是否超时
	 * 
	 * @param borrowTime
	 * @return
	 */
	private int judgeIsOverdue(String borrowTime) {
		try {
			Date d1 = Calendar.getInstance().getTime();
			Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(borrowTime);
			int days = (int) ((d1.getTime() - d2.getTime()) / 86400000);
			if (days >= 15) {
				return 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 判断是否归还
	 * 
	 * @param borrowTime
	 * @param returnTime
	 * @return
	 */
	public int judgeIsReturned(String borrowTime, String returnTime) {
		try {
			Date d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(borrowTime);
			Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(returnTime);
			if (d1.getTime() - d2.getTime() <= 0) {
				return 1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 根据读者账号或姓名查询所有借阅记录时的总页数
	 * 
	 * @return
	 */
	public int getBorrowingRecordByAccountOrNamePages(String value) {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReaderAccount=? or BookName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, value);
			mStatement.setString(1, value);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				count = 1 + mResultSet.getInt(1) / NUM_PERPAGE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return count;
	}

	/**
	 * 查询所有借阅记录时的总页数
	 * 
	 * @return
	 */
	public int getBorrowingRecordPages() {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from " + TableUtill.TABLE_NAME_BORROW;
		try {
			mStatement = mConnection.prepareStatement(sql);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				count = 1 + mResultSet.getInt(1) / NUM_PERPAGE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return count;
	}

	/**
	 * 根据读者账号查询所有借阅记录时的总页数
	 * 
	 * @return
	 */
	public int getBorrowingRecordByAccountPages(String value) {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReaderAccount=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, value);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				count = 1 + mResultSet.getInt(1) / NUM_PERPAGE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return count;
	}

	/**
	 * 查询尚未归还的借阅记录时的总页数
	 * 
	 * @return
	 */
	public int getUnreturnedBorrowingRecordPages() {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReturnTime<BorrowTime ";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				count = 1 + mResultSet.getInt(1) / NUM_PERPAGE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return count;
	}

	/**
	 * 查询尚未归还并且借阅超时的借阅记录时的总页数
	 * 
	 * @return
	 */
	public int getOverdueAndUnreturnedBorrowingRecordPages(int maxDay) {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from "
				+ TableUtill.TABLE_NAME_BORROW
				+ " where ReturnTime<BorrowTime and adddate(BorrowTime,interval ? day)>now() ";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setInt(1, maxDay);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				count = 1 + mResultSet.getInt(1) / NUM_PERPAGE;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return count;
	}
}
