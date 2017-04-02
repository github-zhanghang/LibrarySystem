package com.library.bean;

import java.io.Serializable;

public class BookBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String bookName;// 图书名称
	private String bookAuthor;// 图书作者
	private String bookType;// 图书类型
	private String bookAddress;// 图书所属书架位置
	private int totalCount;// 总数
	private int borrowTimes;// 总的借阅次数
	private String createTime;// 图书入库时间
	private String imageUrl;// 图片地址
	private String bookPress;// 出版社

	public BookBean() {

	}

	public BookBean(String bookName, String bookAuthor, String bookType,
			String bookAddress, int totalCount, int borrowTimes,
			String createTime, String imageUrl, String bookPress) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookAddress = bookAddress;
		this.totalCount = totalCount;
		this.borrowTimes = borrowTimes;
		this.createTime = createTime;
		this.imageUrl = imageUrl;
		this.bookPress = bookPress;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBorrowTimes() {
		return borrowTimes;
	}

	public void setBorrowTimes(int borrowTimes) {
		this.borrowTimes = borrowTimes;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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

	@Override
	public String toString() {
		return "BookBean [bookName=" + bookName + ", bookAuthor=" + bookAuthor
				+ ", bookType=" + bookType + ", bookAddress=" + bookAddress
				+ ", totalCount=" + totalCount + ", borrowTimes=" + borrowTimes
				+ ", createTime=" + createTime + ", imageUrl=" + imageUrl
				+ ", bookPress=" + bookPress + "]";
	}

}
