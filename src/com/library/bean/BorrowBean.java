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
	private String readerName;// 借阅者姓名
	private String bookName;// 书籍名称
	private String borrowTime;// 借书时间
	private String returnTime;// 还书时间
	private boolean isReturned;// 是否归还
	private boolean isOverDue;// 是否超时
	private int renewTimes;// 续借次数

	public BorrowBean(String readerName, String bookName, String borrowTime,
			String returnTime, boolean isReturned, boolean isOverDue,
			int renewTimes) {
		super();
		this.readerName = readerName;
		this.bookName = bookName;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
		this.isReturned = isReturned;
		this.isOverDue = isOverDue;
		this.renewTimes = renewTimes;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public boolean getIsReturned() {
		return isReturned;
	}

	public void setIsReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public boolean getIsOverDue() {
		return isOverDue;
	}

	public void setIsOverDue(boolean isOverDue) {
		this.isOverDue = isOverDue;
	}

	public int getRenewTimes() {
		return renewTimes;
	}

	public void setRenewTimes(int renewTimes) {
		this.renewTimes = renewTimes;
	}

	@Override
	public String toString() {
		return "BorrowBean [readerName=" + readerName + ", bookName="
				+ bookName + ", borrowTime=" + borrowTime + ", returnTime="
				+ returnTime + ", isReturned=" + isReturned + ", isOverDue="
				+ isOverDue + ", renewTimes=" + renewTimes + "]";
	}

}
