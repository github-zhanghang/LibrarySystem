package com.library.bean;

/**
 * 收藏记录实体对象
 * 
 * @author 张航
 * 
 */
public class CollectionBean {
	private String collectionId;
	private ReaderBean readerInfo;
	private BookDetailBean bookInfo;
	private String createTime;

	public CollectionBean(String collectionId, ReaderBean readerInfo,
			BookDetailBean bookInfo, String createTime) {
		super();
		this.collectionId = collectionId;
		this.readerInfo = readerInfo;
		this.bookInfo = bookInfo;
		this.createTime = createTime;
	}

	public String getCollectionId() {
		return collectionId;
	}

	public ReaderBean getReaderInfo() {
		return readerInfo;
	}

	public BookDetailBean getBookInfo() {
		return bookInfo;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "CollectionBean [collectionId=" + collectionId + ", readerInfo="
				+ readerInfo + ", bookInfo=" + bookInfo + ", createTime="
				+ createTime + "]";
	}

}
