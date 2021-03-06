package com.library.bean;

import java.io.Serializable;

/**
 * 书籍信息对象
 * 
 * @author 张航
 * 
 */
public class BookDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bookID;// 图书主键ID
	private String bookName;// 图书名称
	private String bookAuthor;// 图书作者
	private String bookType;// 图书类型
	private String bookAddress;// 图书所属书架位置
	private int isBorrowed;// 是否已经借出
	private int borrowTimes;// 借阅次数
	private String createTime;// 图书入库时间
	private int isEnable;// 是否可借（如：已下架）
	private String imageUrl;// 图片地址
	private String bookPress;// 出版社

	public BookDetailBean(String bookID, String bookName, String bookAuthor,
			String bookType, String bookAddress, int isBorrowed,
			int borrowTimes, String createTime, int isEnable, String imageUrl,
			String bookPress) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookAddress = bookAddress;
		this.isBorrowed = isBorrowed;
		this.borrowTimes = borrowTimes;
		this.createTime = createTime;
		this.isEnable = isEnable;
		this.imageUrl = imageUrl;
		this.bookPress = bookPress;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getBookAddress() {
		return bookAddress;
	}

	public void setBookAddress(String bookAddress) {
		this.bookAddress = bookAddress;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getBorrowTimes() {
		return borrowTimes;
	}

	public void setBorrowTimes(int borrowTimes) {
		this.borrowTimes = borrowTimes;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBookPress() {
		return bookPress;
	}

	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}

	public int getIsBorrowed() {
		return isBorrowed;
	}

	public void setIsBorrowed(int isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
