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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 获取读者的借阅记录
	 * 
	 * @param readerId
	 *            读者id
	 * @param currentPage
	 *            页码
	 * 
	 * @return 借阅记录对象集合
	 */
	public Map<String, Object> getBorrowingRecord(String readerAccount,
			int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();

		mConnection = DBUtil.getConnection();
		try {
			mConnection.setAutoCommit(false);

			// 查询借阅记录
			String borrowSql = "SELECT N.ReaderName,M.BookName,M.BorrowTime,M.ReturnTime,M.BorrowDays,M.IsReturned,M.RenewTimes FROM "
					+ TableUtill.TABLE_NAME_BORROW
					+ " AS M JOIN "
					+ TableUtill.TABLE_NAME_READER
					+ " AS N ON M.ReaderAccount=N.ReaderAccount WHERE N.ReaderAccount=? limit ?,?";
			mStatement = mConnection.prepareStatement(borrowSql);
			mStatement.setString(1, readerAccount);
			mStatement.setInt(2, (currentPage - 1) * NUM_PERPAGE);
			mStatement.setInt(3, (currentPage) * NUM_PERPAGE);
			mResultSet = mStatement.executeQuery();
			List<BorrowBean> borrowList = new ArrayList<BorrowBean>();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			while (mResultSet.next()) {
				String readerName = mResultSet.getString("ReaderName");
				String bookName = mResultSet.getString("BookName");
				String borrowTime = format.format(mResultSet
						.getLong("BorrowTime"));
				String returnTime = format.format(mResultSet
						.getLong("ReturnTime"));
				int BorrowDays = mResultSet.getInt("BorrowDays");
				boolean isReturned = mResultSet.getBoolean("IsReturned");
				boolean isOverDue = judgeIsOverdue(borrowTime, BorrowDays);
				int renewTimes = mResultSet.getInt("RenewTimes");
				borrowList.add(new BorrowBean(readerName, bookName, borrowTime,
						returnTime, isReturned, isOverDue, renewTimes));
			}
			map.put("borrow_info", borrowList);

			// 查询总页数
			String pageSql = "select count(*) from "
					+ TableUtill.TABLE_NAME_BORROW + " where ReaderAccount=?";
			mStatement = mConnection.prepareStatement(pageSql);
			mStatement.setString(1, readerAccount);
			mResultSet = mStatement.executeQuery();
			int totalPage = 0;
			while (mResultSet.next()) {
				int count = mResultSet.getInt(1);
				if (count % NUM_PERPAGE == 0) {
					totalPage = count / NUM_PERPAGE;
				} else {
					totalPage = count / NUM_PERPAGE + 1;
				}
			}
			map.put("totalPage", totalPage);

			mConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				mConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return map;
	}

	/**
	 * 获取读者的借阅记录
	 * 
	 * @param value
	 *            读者账号或书名
	 * @param currentPage
	 *            页码
	 * 
	 * @return
	 */
	public Map<String, Object> getBorrowingRecordByAccountOrBookName(
			String value, int currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();

		mConnection = DBUtil.getConnection();
		try {
			mConnection.setAutoCommit(false);

			// 查询借阅记录
			String borrowSql = "SELECT N.ReaderName,M.BookName,M.BorrowTime,M.ReturnTime,M.BorrowDays,M.IsReturned,M.RenewTimes FROM "
					+ TableUtill.TABLE_NAME_BORROW
					+ " AS M JOIN "
					+ TableUtill.TABLE_NAME_READER
					+ " AS N ON M.ReaderAccount=N.ReaderAccount WHERE N.ReaderAccount=? or M.BookName=? limit ?,?";
			mStatement = mConnection.prepareStatement(borrowSql);
			mStatement.setString(1, value);
			mStatement.setString(2, value);
			mStatement.setInt(3, (currentPage - 1) * NUM_PERPAGE);
			mStatement.setInt(4, (currentPage) * NUM_PERPAGE);
			mResultSet = mStatement.executeQuery();
			List<BorrowBean> borrowList = new ArrayList<BorrowBean>();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			while (mResultSet.next()) {
				String readerName = mResultSet.getString("ReaderName");
				String bookName = mResultSet.getString("BookName");
				String borrowTime = format.format(mResultSet
						.getLong("BorrowTime"));
				String returnTime = format.format(mResultSet
						.getLong("ReturnTime"));
				int BorrowDays = mResultSet.getInt("BorrowDays");
				boolean isReturned = mResultSet.getBoolean("IsReturned");
				boolean isOverDue = judgeIsOverdue(borrowTime, BorrowDays);
				int renewTimes = mResultSet.getInt("RenewTimes");
				borrowList.add(new BorrowBean(readerName, bookName, borrowTime,
						returnTime, isReturned, isOverDue, renewTimes));
			}
			map.put("borrow_info", borrowList);

			// 查询总页数
			String pageSql = "select count(*) from "
					+ TableUtill.TABLE_NAME_BORROW
					+ " where ReaderAccount=? or BookName=?";
			mStatement = mConnection.prepareStatement(pageSql);
			mStatement.setString(1, value);
			mStatement.setString(2, value);
			mResultSet = mStatement.executeQuery();
			int totalPage = 0;
			while (mResultSet.next()) {
				int count = mResultSet.getInt(1);
				if (count % NUM_PERPAGE == 0) {
					totalPage = count / NUM_PERPAGE;
				} else {
					totalPage = count / NUM_PERPAGE + 1;
				}
			}
			map.put("totalPage", totalPage);

			mConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				mConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return map;
	}

	/**
	 * 获取某个读者借阅超时并且尚未归还的借阅记录(分页)
	 * 
	 * @param readerAccounnt
	 *            账号
	 * @param page
	 *            分页页码(大于等于1)
	 * @return 借阅记录对象集合
	 */
	public Map<String, Object> getOverdueAndUnreturnedBorrowingRecordByAccount(
			String readerAccounnt, int page) {
		Map<String, Object> map = new HashMap<String, Object>();

		mConnection = DBUtil.getConnection();
		try {
			mConnection.setAutoCommit(false);

			// 查询借阅记录
			String borrowSql = "SELECT N.ReaderName,M.BookName,M.BorrowTime,M.ReturnTime,M.BorrowDays,M.IsReturned,M.RenewTimes FROM "
					+ TableUtill.TABLE_NAME_BORROW
					+ " AS M JOIN "
					+ TableUtill.TABLE_NAME_READER
					+ " AS N ON M.ReaderAccount=N.ReaderAccount WHERE N.ReaderAccount=? and IsReturned=false and BorrowTime+?<? limit ?,?";
			mStatement = mConnection.prepareStatement(borrowSql);
			mStatement.setString(1, readerAccounnt);
			mStatement.setLong(2, 30 * 24 * 60 * 60 * 1000);
			mStatement.setLong(3, System.currentTimeMillis());
			mStatement.setInt(4, (page - 1) * NUM_PERPAGE);
			mStatement.setInt(5, (page) * NUM_PERPAGE);
			mResultSet = mStatement.executeQuery();
			List<BorrowBean> borrowList = new ArrayList<BorrowBean>();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			while (mResultSet.next()) {
				String readerName = mResultSet.getString("ReaderName");
				String bookName = mResultSet.getString("BookName");
				String borrowTime = format.format(mResultSet
						.getLong("BorrowTime"));
				String returnTime = format.format(mResultSet
						.getLong("ReturnTime"));
				int BorrowDays = mResultSet.getInt("BorrowDays");
				boolean isReturned = mResultSet.getBoolean("IsReturned");
				boolean isOverDue = judgeIsOverdue(borrowTime, BorrowDays);
				int renewTimes = mResultSet.getInt("RenewTimes");
				borrowList.add(new BorrowBean(readerName, bookName, borrowTime,
						returnTime, isReturned, isOverDue, renewTimes));
			}
			map.put("borrow_info", borrowList);

			// 查询总页数
			String pageSql = "select count(*) from "
					+ TableUtill.TABLE_NAME_BORROW
					+ " where ReaderAccount=?  and IsReturned=false and BorrowTime+?<?";
			mStatement = mConnection.prepareStatement(pageSql);
			mStatement.setString(1, readerAccounnt);
			mStatement.setLong(2, 30 * 24 * 60 * 60 * 1000);
			mStatement.setLong(3, System.currentTimeMillis());
			mResultSet = mStatement.executeQuery();
			int totalPage = 0;
			while (mResultSet.next()) {
				int count = mResultSet.getInt(1);
				if (count % NUM_PERPAGE == 0) {
					totalPage = count / NUM_PERPAGE;
				} else {
					totalPage = count / NUM_PERPAGE + 1;
				}
			}
			map.put("totalPage", totalPage);

			mConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				mConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return map;
	}

	/**
	 * 判断书籍是否归还
	 * 
	 * @return 是否归还
	 */
	public boolean isReturned(String readerAccount, String bookName) {
		mConnection = DBUtil.getConnection();
		String sql = "select IsReturned from " + TableUtill.TABLE_NAME_BORROW
				+ " where ReaderAccount=? and BookName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, readerAccount);
			mStatement.setString(2, bookName);
			mResultSet = mStatement.executeQuery();
			if (mResultSet.next()) {
				return mResultSet.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return false;
	}

	/**
	 * 添加借阅记录(借书)
	 * 
	 * @param readeAccount
	 *            读者账号
	 * @param bookName
	 *            借阅的书籍
	 * @param days
	 *            借阅天数
	 * @return 是否添加成功
	 */
	public boolean borrowBook(String readeAccount, String bookName, int days) {
		mConnection = DBUtil.getConnection();
		try {
			mConnection.setAutoCommit(false);

			// 插入一条借阅记录
			String borrowSql = "insert into "
					+ TableUtill.TABLE_NAME_BORROW
					+ "(ReaderAccount,BookName,BorrowDays,BorrowTime) values(?,?,?,?)";
			mStatement = mConnection.prepareStatement(borrowSql);
			mStatement.setString(1, readeAccount);
			mStatement.setString(2, bookName);
			mStatement.setInt(3, days);
			mStatement.setLong(4, System.currentTimeMillis());
			int lines = mStatement.executeUpdate();
			if (lines < 1) {
				mConnection.rollback();
				return false;
			}

			// 更新书籍状态
			String bookSql = "update "
					+ TableUtill.TABLE_NAME_BOOK
					+ " set BookStockCount=BookStockCount-1,BookBorrowedCount=BookBorrowedCount+1,BorrowTimes=BorrowTimes+1 where BookName=?";
			mStatement = mConnection.prepareStatement(bookSql);
			mStatement.setString(1, bookName);
			int lines2 = mStatement.executeUpdate();
			if (lines2 < 1) {
				mConnection.rollback();
				return false;
			}
			mConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				mConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return true;
	}

	/**
	 * 还书
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param bookName
	 *            书籍名称
	 * @return 还书是否成功
	 */
	public boolean returnBook(String readerAccount, String bookName) {

		mConnection = DBUtil.getConnection();
		try {
			mConnection.setAutoCommit(false);

			// 更新borrow表
			String borrowSql = "update "
					+ TableUtill.TABLE_NAME_BORROW
					+ " set ReturnTime=?,IsReturned=true where ReaderAccount=? and BookName=?";
			mStatement = mConnection.prepareStatement(borrowSql);
			mStatement.setLong(1, System.currentTimeMillis());
			mStatement.setString(2, readerAccount);
			mStatement.setString(3, bookName);
			int lines = mStatement.executeUpdate();
			if (lines < 1) {
				mConnection.rollback();
				return false;
			}

			// 更新书籍状态
			String bookSql = "update "
					+ TableUtill.TABLE_NAME_BOOK
					+ " set BookStockCount=BookStockCount+1,BookBorrowedCount=BookBorrowedCount-1 where BookName=?";
			mStatement = mConnection.prepareStatement(bookSql);
			mStatement.setString(1, bookName);
			int lines2 = mStatement.executeUpdate();
			if (lines2 < 1) {
				mConnection.rollback();
				return false;
			}
			mConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				mConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return true;
	}

	/**
	 * 续借
	 * 
	 * @param readerAccount
	 *            读者账号
	 * @param bookName
	 *            书籍名称
	 * @param days
	 *            续借时长
	 * @return 续借是否成功
	 */
	public boolean renewBook(String readerAccount, String bookName, int days) {
		mConnection = DBUtil.getConnection();
		try {
			// 更新borrow表
			String borrowSql = "update "
					+ TableUtill.TABLE_NAME_BORROW
					+ " set BorrowDays=BorrowDays+?,RenewTimes=RenewTimes+1 where ReaderAccount=? and BookName=?";
			mStatement = mConnection.prepareStatement(borrowSql);
			mStatement.setInt(1, days);
			mStatement.setString(2, readerAccount);
			mStatement.setString(3, bookName);
			int lines = mStatement.executeUpdate();
			if (lines == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return false;
	}

	/**
	 * 判断是否超时
	 * 
	 * @param borrowTime
	 * @return
	 */
	private boolean judgeIsOverdue(String borrowTime, int borrowDays) {
		try {
			Date d1 = Calendar.getInstance().getTime();
			Date d2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse(borrowTime);
			int days = (int) ((d1.getTime() - d2.getTime()) / 86400000);
			if (days > borrowDays) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
