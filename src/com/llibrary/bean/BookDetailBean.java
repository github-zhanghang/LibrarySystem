package com.llibrary.bean;

/**
 * 书籍信息对象
 * 
 * @author 张航
 *
 */
public class BookDetailBean {
	private String bookID;// 图书主键ID
	private String bookName;// 图书名称
	private String bookAuthor;// 图书作者
	private String bookType;// 图书类型
	private String bookAddress;// 图书所属书架位置
	private int isBorrowed;// 是否已经被借出，0表示已借出，1表示未借出
	private int borrowTimes;// 借阅次数
	private String createTime;// 图书入库时间

	public BookDetailBean(String bookID, String bookName, String bookAuthor,
			String bookType, String bookAddress, int isBorrowed,
			int borrowTimes, String createTime) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookAddress = bookAddress;
		this.isBorrowed = isBorrowed;
		this.borrowTimes = borrowTimes;
		this.createTime = createTime;
	}

	public String getBookID() {
		return bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public String getBookType() {
		return bookType;
	}

	public String getBookAddress() {
		return bookAddress;
	}

	public int getIsBorrowed() {
		return isBorrowed;
	}

	public int getBorrowTimes() {
		return borrowTimes;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "BookDetailBean [bookID=" + bookID + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookType=" + bookType
				+ ", bookAddress=" + bookAddress + ", isBorrowed=" + isBorrowed
				+ ", borrowTimes=" + borrowTimes + ", createTime=" + createTime
				+ "]";
	}

}
