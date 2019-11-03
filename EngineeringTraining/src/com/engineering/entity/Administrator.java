package com.engineering.entity;

public class Administrator {
	private String adminID;
	private String adminName;
	private String sex;
	private String dept;
	private String password;
	private String labID;

	public Administrator() {
	}

	public Administrator(String adminID, String adminName, String sex, String dept, String password, String labID) {
		super();
		this.adminID = adminID;
		this.adminName = adminName;
		this.sex = sex;
		this.dept = dept;
		this.password = password;
		this.labID = labID;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLabID() {
		return labID;
	}

	public void setLabID(String labID) {
		this.labID = labID;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
