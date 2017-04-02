package com.library.bean;

public class UserBook extends BookDetailBean {
	private int isBorrowed, isCollected;

	public UserBook(String bookID, String bookName, String bookAuthor,
			String bookType, String bookAddress, int isBorrowed,
			int borrowTimes, String createTime, int isEnable, String imageUrl,
			String bookPress) {
		super(bookID, bookName, bookAuthor, bookType, bookAddress, isBorrowed,
				borrowTimes, createTime, isEnable, imageUrl, bookPress);
	}

	public int getIsBorrowed() {
		return isBorrowed;
	}

	public void setIsBorrowed(int isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public int getIsCollected() {
		return isCollected;
	}

	public void setIsCollected(int isCollected) {
		this.isCollected = isCollected;
	}

}
