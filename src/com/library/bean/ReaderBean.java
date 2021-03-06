package com.library.bean;

import java.io.Serializable;

/**
 * 读者Bean对象
 * 
 * @author 张航
 * 
 */
public class ReaderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String readerId;// 读者Id
	private String readerAccount;// 读者账号
	private String readerPassword;// 读者密码
	private String readerName;// 读者姓名
	private String readerPhone;// 读者电话
	private String createTime;// 注册时间
	private int isEnable;// 是否可以登录

	public ReaderBean(String readerId, String readerAccount,
			String readerPassword, String readerName, String readerPhone,
			String createTime, int isEnable) {
		super();
		this.readerId = readerId;
		this.readerAccount = readerAccount;
		this.readerPassword = readerPassword;
		this.readerName = readerName;
		this.readerPhone = readerPhone;
		this.createTime = createTime;
		this.isEnable = isEnable;
	}

	public String getReaderId() {
		return readerId;
	}

	public String getReaderAccount() {
		return readerAccount;
	}

	public String getReaderPassword() {
		return readerPassword;
	}

	public String getReaderName() {
		return readerName;
	}

	public String getReaderPhone() {
		return readerPhone;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public String getCreateTime() {
		int length = createTime.length();
		return createTime.substring(0, length - 2);
	}

	@Override
	public String toString() {
		return "ReaderBean [readerId=" + readerId + ", readerAccount="
				+ readerAccount + ", readerPassword=" + readerPassword
				+ ", readerName=" + readerName + ", readerPhone=" + readerPhone
				+ ", createTime=" + createTime + ", isEnable=" + isEnable + "]";
	}

}
