package com.library.bean;

import java.io.Serializable;

/**
 * 管理员对象
 * 
 * @author 张航
 *
 */
public class ManagerBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String managerId;// 管理员Id
	private String managerAccount;// 管理员登录账号
	private String managerPassword;// 管理员登录密码
	private String managerName;// 管理员姓名
	private String managerPhone;// 管理员联系方式
	private String managerDuty;// 管理员职责
	private String createTime;// 创建时间

	public ManagerBean(String managerId, String managerAccount,
			String managerPassword, String managerName, String managerPhone,
			String managerDuty, String createTime) {
		super();
		this.managerId = managerId;
		this.managerAccount = managerAccount;
		this.managerPassword = managerPassword;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.managerDuty = managerDuty;
		this.createTime = createTime;
	}

	public String getManagerId() {
		return managerId;
	}

	public String getManagerAccount() {
		return managerAccount;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public String getManagerName() {
		return managerName;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public String getManagerDuty() {
		return managerDuty;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "ManagerBean [managerId=" + managerId + ", managerAccont="
				+ managerAccount + ", managerPassword=" + managerPassword
				+ ", managerName=" + managerName + ", managerPhone="
				+ managerPhone + ", managerDuty=" + managerDuty
				+ ", createTime=" + createTime + "]";
	}

}
