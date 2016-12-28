package com.library.bean;

import java.io.Serializable;

/**
 * 书架对象
 * 
 * @author 张航
 * 
 */
public class BookAddressBean implements Serializable {
	private static final long serialVersionUID = 1L;
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
		int length = createTime.length();
		return createTime.substring(0, length - 2);
	}

	@Override
	public String toString() {
		return "BookAddressBean [shelfId=" + shelfId + ", shelfName="
				+ shelfName + ", createTime=" + createTime + "]";
	}

}
