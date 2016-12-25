package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.BookDetailBean;
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

		if (currentPage > 0) {
			mConnection = DBUtil.getConnection();
			String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
					+ " where IsEnable=1 limit ?,?";
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
					String imageUrl = mResultSet.getString(11);
					String bookPress = mResultSet.getString(12);

					bookList.add(new BookDetailBean(bookId, bookName,
							bookAuthor, bookType, bookAddress, stockCount,
							borrowedCount, createTime, borrowTimes, isEnable,
							imageUrl, bookPress));
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
					+ " where BookType=? and IsEnable=1 limit ?,?";
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
					String imageUrl = mResultSet.getString(11);
					String bookPress = mResultSet.getString(12);

					bookList.add(new BookDetailBean(bookId, bookName,
							bookAuthor, typeName, bookAddress, stockCount,
							borrowedCount, createTime, borrowTimes, isEnable,
							imageUrl, bookPress));
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
				String imageUrl = mResultSet.getString(11);
				String bookPress = mResultSet.getString(12);

				bookDetailBean = new BookDetailBean(bookId, bookName,
						bookAuthor, bookType, bookAddress, stockCount,
						borrowedCount, createTime, borrowTimes, isEnable,
						imageUrl, bookPress);
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
				String imageUrl = mResultSet.getString(11);
				String bookPress = mResultSet.getString(12);

				bookDetailBean = new BookDetailBean(bookId, bookName,
						bookAuthor, bookType, bookAddress, stockCount,
						borrowedCount, createTime, borrowTimes, isEnable,
						imageUrl, bookPress);
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
		List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
				+ " where BookAuthor=? and IsEnable=1";
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
				String imageUrl = mResultSet.getString(11);
				String bookPress = mResultSet.getString(12);

				bookList.add(new BookDetailBean(bookId, bookName, bookAuthor,
						bookType, bookAddress, stockCount, borrowedCount,
						createTime, borrowTimes, isEnable, imageUrl, bookPress));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return bookList;
	}

	/**
	 * 查询借阅次数最多的count种图书
	 * 
	 * @param count
	 *            要查询的数量
	 * @return 书籍集合
	 */

	public List<BookDetailBean> getMaxBorrowedBooks(int count) {
		List<BookDetailBean> bookList = new ArrayList<BookDetailBean>();

		if (count >= 0) {
			mConnection = DBUtil.getConnection();
			String sql = "select * from " + TableUtill.TABLE_NAME_BOOK
					+ " where IsEnable=1 order by BorrowTimes desc limit ? ";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, count);
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
					String imageUrl = mResultSet.getString(11);
					String bookPress = mResultSet.getString(12);

					bookList.add(new BookDetailBean(bookId, bookName,
							bookAuthor, bookType, bookAddress, stockCount,
							borrowedCount, createTime, borrowTimes, isEnable,
							imageUrl, bookPress));
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
	 * @param imageUrl
	 *            书籍图片地址
	 * @param bookPress
	 *            书籍出版社
	 * @return 是否添加成功
	 */
	public boolean addBook(String bookName, String bookAuthor, String bookType,
			String bookAddress, int count, String imageUrl, String bookPress) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into "
				+ TableUtill.TABLE_NAME_BOOK
				+ "(BookName,BookAuthor,BookType,BookAddress,BookStockCount,BookImage,BookPress) values(?,?,?,?,?,?,?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookName);
			mStatement.setString(2, bookAuthor);
			mStatement.setString(3, bookType);
			mStatement.setString(4, bookAddress);
			mStatement.setInt(5, count);
			mStatement.setString(6, imageUrl);
			mStatement.setString(7, bookPress);
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
	 * 删除书籍(如果此图书没有过借阅记录则可以删除，否则删除失败)
	 * 
	 * @param bookName
	 *            书籍名称
	 * @return 是否删除成功
	 */
	public boolean deleteBookByName(String bookName) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "delete from " + TableUtill.TABLE_NAME_BOOK
				+ " where BookName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookName);
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
	 * 删除书籍(如果此图书没有过借阅记录则可以删除，否则删除失败)
	 * 
	 * @param bookId
	 *            书籍id
	 * @return 是否删除成功
	 */
	public boolean deleteBookById(String bookId) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "delete from " + TableUtill.TABLE_NAME_BOOK
				+ " where BookID=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, bookId);
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
	 * 修改书籍信息
	 * 
	 * @param oldBookName
	 *            书籍名称
	 * @param newBookAuthor
	 *            新作者
	 * @param newBookType
	 *            新类型
	 * @param newBookAddress
	 *            新位置
	 * @param newBookCount
	 *            新库存数量
	 * @param newBookImage
	 *            新图片
	 * @param newBookPress
	 *            新出版社
	 * 
	 * @return 更新的结果
	 */
	public boolean updateBookByName(String oldBookName, String newBookName,
			String newBookAuthor, String newBookType, String newBookAddress,
			int newBookCount, String newBookImage, String newBookPress) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "update "
				+ TableUtill.TABLE_NAME_BOOK
				+ " set BookName=?,BookAuthor=?,BookType=?,BookAddress=?,BookStockCount=?,BookImage=?,BookPress=? where BookName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, newBookName);
			mStatement.setString(2, newBookAuthor);
			mStatement.setString(3, newBookType);
			mStatement.setString(4, newBookAddress);
			mStatement.setInt(5, newBookCount);
			mStatement.setString(6, newBookImage);
			mStatement.setString(7, newBookPress);
			mStatement.setString(8, oldBookName);
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
	public boolean setBookEnableByName(String bookName, int isEnable) {
		boolean isSuccess = false;

		if (isEnable == 0 || isEnable == 1) {
			mConnection = DBUtil.getConnection();
			String sql = "update " + TableUtill.TABLE_NAME_BOOK
					+ " set IsEnable=? where BookName=?";
			try {
				mStatement = mConnection.prepareStatement(sql);
				mStatement.setInt(1, isEnable);
				mStatement.setString(2, bookName);
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

	/**
	 * 查询所有书籍时的总页数
	 * 
	 * @return
	 */
	public int getAllBooksPageCount() {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from " + TableUtill.TABLE_NAME_BOOK
				+ " where IsEnable=1";
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
	 * 根据分类查询所有书籍时的总页数
	 * 
	 * @return
	 */
	public int getAllBooksByTypePageCount(String typeName) {
		int count = 0;

		mConnection = DBUtil.getConnection();
		String sql = "select count(*) from " + TableUtill.TABLE_NAME_BOOK
				+ "  where BookType=? and IsEnable=1";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, typeName);
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
