package com.llibrary.bean;

/**
 * 借阅记录实体对象
 * 
 * @author 张航
 *
 */
public class BorrowBean {
	private String borrowId;// 借阅记录主键Id
	private String ReaderAccount;// 借阅者id
	private String bookName;// 书籍id
	private String borrowTime;// 借书时间
	private String returnTime;// 还书时间

	public BorrowBean(String borrowId, String readerAccount, String bookName,
			String borrowTime, String returnTime) {
		super();
		this.borrowId = borrowId;
		ReaderAccount = readerAccount;
		this.bookName = bookName;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
	}

	public String getBorrowId() {
		return borrowId;
	}

	public String getReaderAccount() {
		return ReaderAccount;
	}

	public String getBookName() {
		return bookName;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	@Override
	public String toString() {
		return "BorrowBean [borrowId=" + borrowId + ", ReaderAccount="
				+ ReaderAccount + ", bookName=" + bookName + ", borrowTime="
				+ borrowTime + ", returnTime=" + returnTime + "]";
	}

}
