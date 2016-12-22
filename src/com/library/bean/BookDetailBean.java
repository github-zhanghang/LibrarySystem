package com.library.bean;

import java.io.Serializable;

/**
 * 书籍信息对象
 * 
 * @author 张航
 * 
 */
public class BookDetailBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookID;// 图书主键ID
	private String bookName;// 图书名称
	private String bookAuthor;// 图书作者
	private String bookType;// 图书类型
	private String bookAddress;// 图书所属书架位置
	private int stockCount;// 该图书总数量
	private int borrowedCount;// 已借出的数量
	private String createTime;// 图书入库时间
	private int borrowTimes;// 借阅次数
	private int isEnable;// 是否可借
	private String imageUrl;// 图片地址
	private String bookPress;// 出版社

	public BookDetailBean(String bookID, String bookName, String bookAuthor,
			String bookType, String bookAddress, int stockCount,
			int borrowedCount, String createTime, int borrowTimes,
			int isEnable, String imageUrl, String press) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookAddress = bookAddress;
		this.stockCount = stockCount;
		this.borrowedCount = borrowedCount;
		this.createTime = createTime;
		this.borrowTimes = borrowTimes;
		this.isEnable = isEnable;
		this.imageUrl = imageUrl;
		this.bookPress = press;
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

	public int getStockCount() {
		return stockCount;
	}

	public int getBorrowedCount() {
		return borrowedCount;
	}

	public String getCreateTime() {
		return createTime;
	}

	public int getBorrowTimes() {
		return borrowTimes;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBookPress() {
		return bookPress;
	}

	@Override
	public String toString() {
		return "BookDetailBean [bookID=" + bookID + ", bookName=" + bookName
				+ ", bookAuthor=" + bookAuthor + ", bookType=" + bookType
				+ ", bookAddress=" + bookAddress + ", stockCount=" + stockCount
				+ ", borrowedCount=" + borrowedCount + ", createTime="
				+ createTime + ", borrowTimes=" + borrowTimes + ", isEnable="
				+ isEnable + ", imageUrl=" + imageUrl + ", press=" + bookPress
				+ "]";
	}

}
