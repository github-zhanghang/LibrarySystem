package com.library.bean;

/**
 * 收藏记录实体对象
 * 
 * @author 张航
 * 
 */
public class CollectionBean {
	private String collectionId;
	private String readerAccount;
	private String bookName;
	private String createTime;

	public CollectionBean(String collectionId, String readerAccount,
			String bookName, String createTime) {
		super();
		this.collectionId = collectionId;
		this.readerAccount = readerAccount;
		this.bookName = bookName;
		this.createTime = createTime;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public String getReaderAccount() {
		return readerAccount;
	}

	public String getBookName() {
		return bookName;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "CollectionBean [collectionId=" + collectionId
				+ ", readerAccount=" + readerAccount + ", bookName=" + bookName
				+ ", createTime=" + createTime + "]";
	}

}
