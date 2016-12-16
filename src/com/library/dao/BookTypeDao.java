package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.bean.BookTypeBean;
import com.library.util.DBUtil;
import com.library.util.TableUtill;

public class BookTypeDao {
	private Connection mConnection;
	private PreparedStatement mStatement;
	private ResultSet mResultSet;

	/**
	 * 获取所有分类
	 * 
	 * @return 类别集合
	 */
	public List<BookTypeBean> getAllTypes() {
		List<BookTypeBean> typeList = new ArrayList<BookTypeBean>();

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOKTYPE;
		try {
			mStatement = mConnection.prepareStatement(sql);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String typeId = mResultSet.getString(1);
				String typeName = mResultSet.getString(2);
				String createTime = mResultSet.getString(3);
				typeList.add(new BookTypeBean(typeId, typeName, createTime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return typeList;
	}

	/**
	 * 根据Id获取分类
	 * 
	 * @param typeId
	 *            类别Id
	 * @return 类别对象
	 */
	public BookTypeBean getTypeById(String typeId) {
		BookTypeBean typeBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOKTYPE
				+ " where TypeID=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, typeId);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String typeName = mResultSet.getString(2);
				String createTime = mResultSet.getString(3);
				typeBean = new BookTypeBean(typeId, typeName, createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return typeBean;
	}

	/**
	 * 根据名称获取分类
	 * 
	 * @param typeName
	 *            类别名称
	 * @return 类别对象
	 */
	public BookTypeBean getTypeByName(String typeName) {
		BookTypeBean typeBean = null;

		mConnection = DBUtil.getConnection();
		String sql = "select * from " + TableUtill.TABLE_NAME_BOOKTYPE
				+ " where TypeName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, typeName);
			mResultSet = mStatement.executeQuery();
			while (mResultSet.next()) {
				String typeId = mResultSet.getString(1);
				String createTime = mResultSet.getString(3);
				typeBean = new BookTypeBean(typeId, typeName, createTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(mStatement, mConnection, mResultSet);
		}
		return typeBean;
	}

	/**
	 * 添加分类
	 * 
	 * @param typeName
	 *            类别名称
	 * @return 是否添加成功
	 */
	public boolean createType(String typeName) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "insert into " + TableUtill.TABLE_NAME_BOOKTYPE
				+ "(TypeName) values(?)";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, typeName);
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
	 * 删除分类(如果此类别下没有图书则可以删除，否则删除失败)
	 * 
	 * @param typeName
	 *            类别名称
	 * @return 是否删除成功
	 */
	public boolean deleteType(String typeName) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "delete from " + TableUtill.TABLE_NAME_BOOKTYPE
				+ " where TypeName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, typeName);
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
	 * 修改分类
	 * 
	 * @param oldTypeName
	 *            修改前的类别名称
	 * @param oldTypeName
	 *            修改后的类别名称
	 * @return 是否修改成功
	 */
	public boolean updateType(String oldTypeName, String newTypeName) {
		boolean isSuccess = false;

		mConnection = DBUtil.getConnection();
		String sql = "update " + TableUtill.TABLE_NAME_BOOKTYPE
				+ " set TypeName=? where TypeName=?";
		try {
			mStatement = mConnection.prepareStatement(sql);
			mStatement.setString(1, newTypeName);
			mStatement.setString(2, oldTypeName);
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
