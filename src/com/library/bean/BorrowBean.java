package com.library.bean;

import java.io.Serializable;

/**
 * 借阅记录实体对象
 * 
 * @author 张航
 * 
 */
public class BorrowBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String borrowId;// 借阅记录主键Id
	private ReaderBean readerInfo;// 借阅者信息
	private String bookName;// 书籍名称
	private String borrowTime;// 借书时间
	private String returnTime;// 还书时间
	private String isReturned;// 是否归还
	private String isOverDue;// 是否超时

	public BorrowBean(String borrowId, ReaderBean readerInfo, String bookName,
			String borrowTime, String returnTime, String isReturned,
			String isOverDue) {
		super();
		this.borrowId = borrowId;
		this.readerInfo = readerInfo;
		this.bookName = bookName;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
		this.isReturned = isReturned;
		this.isOverDue = isOverDue;
	}

	public String getBorrowId() {
		return borrowId;
	}

	public ReaderBean getReaderInfo() {
		return readerInfo;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBorrowTime() {
		int length = borrowTime.length();
		return borrowTime.substring(0, length - 2);
	}

	public String getReturnTime() {
		int length = returnTime.length();
		return returnTime.substring(0, length - 2);
	}

	public String getIsReturned() {
		return isReturned;
	}

	public String getIsOverDue() {
		return isOverDue;
	}

	@Override
	public String toString() {
		return "BorrowBean [borrowId=" + borrowId + ", readerInfo="
				+ readerInfo + ", bookName=" + bookName + ", borrowTime="
				+ borrowTime + ", returnTime=" + returnTime + ", isReturned="
				+ isReturned + ", isOverDue=" + isOverDue + "]";
	}

}
