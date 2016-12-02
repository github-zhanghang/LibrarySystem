package com.library.bean;

/**
 * 管理员对象
 * 
 * @author 张航
 *
 */
public class ManagerBean {
	private String managerId;// 管理员Id
	private String managerAccont;// 管理员登录账号
	private String managerPassword;// 管理员登录密码
	private String managerName;// 管理员姓名
	private String managerPhone;// 管理员联系方式
	private String managerDuty;// 管理员职责
	private String createTime;// 创建时间

	public ManagerBean(String managerId, String managerAccont,
			String managerPassword, String managerName, String managerPhone,
			String managerDuty, String createTime) {
		super();
		this.managerId = managerId;
		this.managerAccont = managerAccont;
		this.managerPassword = managerPassword;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.managerDuty = managerDuty;
		this.createTime = createTime;
	}

	public String getManagerId() {
		return managerId;
	}

	public String getManagerAccont() {
		return managerAccont;
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
				+ managerAccont + ", managerPassword=" + managerPassword
				+ ", managerName=" + managerName + ", managerPhone="
				+ managerPhone + ", managerDuty=" + managerDuty
				+ ", createTime=" + createTime + "]";
	}

}
