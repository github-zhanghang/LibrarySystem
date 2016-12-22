package com.library.bean;

/**
 * 借阅记录实体对象
 * 
 * @author 张航
 * 
 */
public class BorrowBean {
	private String borrowId;// 借阅记录主键Id
	private ReaderBean readerInfo;// 借阅者信息
	private String bookName;// 书籍名称
	private String borrowTime;// 借书时间
	private String returnTime;// 还书时间

	public BorrowBean(String borrowId, ReaderBean readerInfo, String bookName,
			String borrowTime, String returnTime) {
		super();
		this.borrowId = borrowId;
		this.readerInfo = readerInfo;
		this.bookName = bookName;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
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
		return borrowTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	@Override
	public String toString() {
		return "BorrowBean [borrowId=" + borrowId + ", readerInfo="
				+ readerInfo + ", bookName=" + bookName + ", borrowTime="
				+ borrowTime + ", returnTime=" + returnTime + "]";
	}

}
