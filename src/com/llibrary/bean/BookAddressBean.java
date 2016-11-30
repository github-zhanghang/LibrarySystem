package com.llibrary.bean;

/**
 * 书架对象
 * 
 * @author 张航
 *
 */
public class BookAddressBean {
	private String shelfId;// 书架Id
	private String shelfName;// 书架名称
	private String createTime;// 书架创建时间

	public BookAddressBean(String shelfId, String shelfName, String createTime) {
		super();
		this.shelfId = shelfId;
		this.shelfName = shelfName;
		this.createTime = createTime;
	}

	public String getShelfId() {
		return shelfId;
	}

	public String getShelfName() {
		return shelfName;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "BookAddressBean [shelfId=" + shelfId + ", shelfName="
				+ shelfName + ", createTime=" + createTime + "]";
	}

}
