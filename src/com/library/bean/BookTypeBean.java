package com.library.bean;

/**
 * 书籍类型对象
 * 
 * @author 张航
 *
 */
public class BookTypeBean {
	private String typeId;//类型Id
	private String typeName;//类型名称
	private String createTime;//创建时间

	public BookTypeBean(String typeId, String typeName, String createTime) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.createTime = createTime;
	}

	public String getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "BookTypeBean [typeId=" + typeId + ", typeName=" + typeName
				+ ", createTime=" + createTime + "]";
	}

}
