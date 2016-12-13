package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.BookDetailBean;
import com.library.bean.BookTypeBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class BookDetailDao {
	// 分页查询，每页显示的数量
	private static final int NUM_PERPAGE = 15;

	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 获取所有图书(分页)
	 * 
	 * @param currentPage
	 *            查询的页码(大于等于1)
	 * @return 书籍集合
	 */
	public List<BookDetailBean> getBooks(int currentPage) {
		List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();

		if (currentPage >= 0) {
			mConnection = DBUtil.getConnection();
			String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
					+ " limit ?,?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, (currentPage - 1) * NUM_PERPAGE);
				mStatement.setInt(2, (currentPage) * NUM_PERPAGE);
				mResultSet = mStatement.executeQuery();
				while (mResultSet.next()) {
					String bookId = mResultSet.getString(1);
					String bookName = mResultSet.getString(2);
					String bookAuthor = mResultSet.getString(3);
					String bookType = mResultSet.getString(4);
					String bookAddress = mResultSet.getString(5);
					int stockCount = mResultSet.getInt(6);
					int borrowedCount = mResultSet.getInt(7);
					String createTime = mResultSet.getString(8);
					int borrowTimes = mResultSet.getInt(9);
					int isEnable = mResultSet.getInt(10);

					bookList.add(new BookDetailBean(bookId, bookName,
							bookAuthor, bookType, bookAddress, stockCount,
							borrowedCount, createTime, borrowTimes, isEnable));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(mStatement, mConnection, mResultSet);
			}
		}
		return bookList;
	}

	/**
	 * 根据分类获取图书(分页)
	 * 
	 * @param typeId
	 *            书籍类型id
	 * @param currentPage
	 *            查询的页码(大于等于1)
	 * @return 书籍集合
	 */
	public List<BookDetailBean> getBooksByType(String typeName, int currentPage) {
		List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();

		if (currentPage >= 0) {
			mConnection = DBUtil.getConnection();
			String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
					+ " where BookType=? limit ?,?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setString(1, typeName);
				mStatement.setInt(2, (currentPage - 1) * NUM_PERPAGE);
				mStatement.setInt(3, (currentPage) * NUM_PERPAGE);
				mResultSet = mStatement.executeQuery();
				while (mResultSet.next()) {
					String bookId = mResultSet.getString(1);
					String bookName = mResultSet.getString(2);
					String bookAuthor = mResultSet.getString(3);
					String bookAddress = mResultSet.getString(5);
					int stockCount = mResultSet.getInt(6);
					int borrowedCount = mResultSet.getInt(7);
					String createTime = mResultSet.getString(8);
					int borrowTimes = mResultSet.getInt(9);
					int isEnable = mResultSet.getInt(10);

					bookList.add(new BookDetailBean(bookId, bookName,
							bookAuthor, typeName, bookAddress, stockCount,
							borrowedCount, createTime, borrowTimes, isEnable));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(mStatement, mConnection, mResultSet);
			}
		}
		return bookList;
	}

	/**
	 * 根据书名获取图书
	 * 
	 * @param bookName
	 *            书籍名称
	 * @return 书籍集合
	 */
	public BookDetailBean getBookByName(String bookName) {
		BookDetailBean bookDetailBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
				+ " where BookName=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookName);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String bookId = mResultSet.getString(1);
				String bookAuthor = mResultSet.getString(3);
				String bookType = mResultSet.getString(4);
				String bookAddress = mResultSet.getString(5);
				int stockCount = mResultSet.getInt(6);
				int borrowedCount = mResultSet.getInt(7);
				String createTime = mResultSet.getString(8);
				int borrowTimes = mResultSet.getInt(9);
				int isEnable = mResultSet.getInt(10);

				bookDetailBean = new BookDetailBean(bookId, bookName,
						bookAuthor, bookType, bookAddress, stockCount,
						borrowedCount, createTime, borrowTimes, isEnable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return bookDetailBean;
	}

	/**
	 * 根据书籍Id获取图书
	 * 
	 * @param bookId
	 *            书籍id
	 * @return 书籍对象
	 */
	public BookDetailBean getBookById(String bookId) {
		BookDetailBean bookDetailBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
				+ " where BookId=? limit 1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookId);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String bookName = mResultSet.getString(2);
				String bookAuthor = mResultSet.getString(3);
				String bookType = mResultSet.getString(4);
				String bookAddress = mResultSet.getString(5);
				int stockCount = mResultSet.getInt(6);
				int borrowedCount = mResultSet.getInt(7);
				String createTime = mResultSet.getString(8);
				int borrowTimes = mResultSet.getInt(9);
				int isEnable = mResultSet.getInt(10);

				bookDetailBean = new BookDetailBean(bookId, bookName,
						bookAuthor, bookType, bookAddress, stockCount,
						borrowedCount, createTime, borrowTimes, isEnable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return bookDetailBean;
	}

	/**
	 * 根据书籍作者获取图书
	 * 
	 * @param bookAuthor
	 *            书籍作者
	 * @return 书籍对象
	 */
	public List<BookDetailBean> getBooksByAuthor(String bookAuthor) {
		List<BookDetailBean> bookDetailBeanList = new ArrayList<BookDetailBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
				+ " where BookAuthor=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookAuthor);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String bookId = mResultSet.getString(1);
				String bookName = mResultSet.getString(2);
				String bookType = mResultSet.getString(4);
				String bookAddress = mResultSet.getString(5);
				int stockCount = mResultSet.getInt(6);
				int borrowedCount = mResultSet.getInt(7);
				String createTime = mResultSet.getString(8);
				int borrowTimes = mResultSet.getInt(9);
				int isEnable = mResultSet.getInt(10);

				bookDetailBeanList.add(new BookDetailBean(bookId, bookName,
						bookAuthor, bookType, bookAddress, stockCount,
						borrowedCount, createTime, borrowTimes, isEnable));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return bookDetailBeanList;
	}

	/**
	 * 查询借阅次数最多的count种图书
	 * 
	 * @param count
	 *            Maximum
	 * @return 书籍集合
	 */
	/*
	 * public List<BookDetailBean> getMaxBorrowedBooks(int currentPage) {
	 * List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();
	 * 
	 * if (currentPage >= 0) { mConnection = DBUtil.getConnection(); String sql
	 * = "select * from " + TableUtill.TABLE_NAME_BOOK + " where limit "; try {
	 * mStatement = mConnection.prepareStatement(sql); mStatement.setString(1,
	 * typeId); mStatement.setInt(2, (currentPage - 1) * NUM_PERPAGE);
	 * mStatement.setInt(3, (currentPage) * NUM_PERPAGE); mResultSet =
	 * mStatement.executeQuery(); while (mResultSet.next()) { String bookId =
	 * mResultSet.getString(1); String bookName = mResultSet.getString(2);
	 * String bookAuthor = mResultSet.getString(3); String bookTypeId =
	 * mResultSet.getString(4); String bookAddressId = mResultSet.getString(5);
	 * int isBorrowed = mResultSet.getInt(6); String createTime =
	 * mResultSet.getString(7); int borrowTimes = mResultSet.getInt(8); //
	 * 根据书籍类型id获取类型名称 String bookTypeName = new BookTypeDao().getTypeById(
	 * bookTypeId).getTypeName(); // 根据书架id获取书架名称 String bookAddressName = new
	 * BookAddressDao() .getShelfNameById(bookAddressId).getShelfName();
	 * bookList.add(new BookDetailBean(bookId, bookName, bookAuthor,
	 * bookTypeName, bookAddressName, isBorrowed, borrowTimes, createTime)); } }
	 * catch (SQLException e) { e.printStackTrace(); } finally {
	 * DBUtil.close(mStatement, mConnection, mResultSet); } } return bookList; }
	 */

	/**
	 * 添加书籍
	 * 
	 * @param bookName
	 *            书籍名称
	 * @param bookAuthor
	 *            书籍作者
	 * @param bookType
	 *            书籍类型
	 * @param bookAddress
	 *            书籍位置
	 * @param count
	 *            书籍数量
	 * @return 是否添加成功
	 */
	public boolean addBook(String bookName, String bookAuthor, String bookType,
			String bookAddress, int count) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into "
				+ TableUtill.TABLE_NAME_BOOK
				+ "(BookName,BookAuthor,BookType,BookAddress,BookStockCount) values(?,?,?,?,?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookName);
			mStatement.setString(2, bookAuthor);
			mStatement.setString(3, bookType);
			mStatement.setString(4, bookAddress);
			mStatement.setInt(5, count);
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
	 * 修改书籍信息
	 * 
	 * @param bookName
	 *            书籍名称
	 * @param newBookAuthor
	 *            新作者
	 * @param newBookType
	 *            新类型
	 * @param newBookAddress
	 *            新位置
	 * 
	 * @return 更新的结果
	 */
	public boolean updateBookByName(String bookName, String newBookAuthor,
			String newBookType, String newBookAddress) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "update " + TableUtill.TABLE_NAME_BOOK
				+ " set BookAuthor=?,BookType=?,BookAddress=? where BookName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, newBookAuthor);
			mStatement.setString(2, newBookType);
			mStatement.setString(3, newBookAddress);
			mStatement.setString(4, bookName);
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
	 * 设置书籍的是否可以借出(例如：书籍的上架与下架)
	 * 
	 * @param bookName
	 *            书籍名称
	 * @param isEnable
	 *            0表示不可借出，1表示可以借出
	 * @return 更改的数量
	 */
	public int setBookEnableByName(String bookName, int isEnable) {
		int count = 0;

		if (isEnable == 0 || isEnable == 1) {
			mConnection = DBUtil.getConnection();
			String sql = "update " + TableUtill.TABLE_NAME_BOOK
					+ " set IsEnable=? where BookName=?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, isEnable);
				mStatement.setString(2, bookName);
				count = mStatement.executeUpdate();// 受影响行数
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(mStatement, mConnection, mResultSet);
			}
		}
		return count;
	}

	/**
	 * 设置书籍的是否可以借出(例如：书籍的上架与下架)
	 * 
	 * @param bookId
	 *            书籍Id
	 * @param isEnable
	 *            0表示不可借出，1表示可以借出
	 * @return 更改的数量
	 */
	public int setBookEnableById(String bookId, int isEnable) {
		int count = 0;

		if (isEnable == 0 || isEnable == 1) {
			mConnection = DBUtil.getConnection();
			String sql = "update " + TableUtill.TABLE_NAME_BOOK
					+ " set IsEnable=? where BookID=?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, isEnable);
				mStatement.setString(2, bookId);
				count = mStatement.executeUpdate();// 受影响行数
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.close(mStatement, mConnection, mResultSet);
			}
		}
		return count;
	}
}
