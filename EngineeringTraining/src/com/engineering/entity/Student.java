package com.engineering.entity;

public class Student {
	private String stuno;
	private String name;
	private String sex;
	private String phone;
	private String dept;
	private String classID;
	private String labID;
	private String position; /* 职务 */
	private String gameExperience; /* 比赛经历 */
	private String winInformation; /* 获奖信息 */
	private String employmentUnit; /* 就业单位 */
	private String performance; /* 毕业后的突出表现 */
	private String entryTime; /* 进入时间 */
	private String graduationTime; /* 毕业时间 */
	private String picture;
	private String url;

	public Student() {
	}

	// 没有url
	public Student(String stuno, String name, String sex, String phone, String dept, String classID, String labID,
			String position, String gameExperience, String winInformation, String employmentUnit, String performance,
			String entryTime, String graduationTime, String picture) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.dept = dept;
		this.classID = classID;
		this.labID = labID;
		this.position = position;
		this.gameExperience = gameExperience;
		this.winInformation = winInformation;
		this.employmentUnit = employmentUnit;
		this.performance = performance;
		this.entryTime = entryTime;
		this.graduationTime = graduationTime;
		this.picture = picture;
	}

	// 没有url，entryTime，graduationTime
	public Student(String stuno, String name, String sex, String phone, String dept, String classID, String labID,
			String position, String gameExperience, String winInformation, String employmentUnit, String performance,
			String picture) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.picture = picture;
		this.dept = dept;
		this.classID = classID;
		this.labID = labID;
		this.position = position;
		this.gameExperience = gameExperience;
		this.winInformation = winInformation;
		this.employmentUnit = employmentUnit;
		this.performance = performance;
	}

	// 没有picture，url
	public Student(String stuno, String name, String sex, String phone, String dept, String classID, String labID,
			String position, String gameExperience, String winInformation, String employmentUnit, String performance,
			String entryTime, String graduationTime) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.dept = dept;
		this.classID = classID;
		this.labID = labID;
		this.entryTime = entryTime;
		this.position = position;
		this.gameExperience = gameExperience;
		this.winInformation = winInformation;
		this.graduationTime = graduationTime;
		this.employmentUnit = employmentUnit;
		this.performance = performance;
	}

	public Student(String stuno, String name, String sex, String phone, String dept, String classID, String labID,
			String position, String gameExperience, String winInformation, String employmentUnit, String performance,
			String entryTime, String graduationTime, String picture, String url) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.dept = dept;
		this.classID = classID;
		this.labID = labID;
		this.position = position;
		this.gameExperience = gameExperience;
		this.winInformation = winInformation;
		this.employmentUnit = employmentUnit;
		this.performance = performance;
		this.entryTime = entryTime;
		this.graduationTime = graduationTime;
		this.picture = picture;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getLabID() {
		return labID;
	}

	public void setLabID(String labID) {
		this.labID = labID;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGameExperience() {
		return gameExperience;
	}

	public void setGameExperience(String gameExperience) {
		this.gameExperience = gameExperience;
	}

	public String getWinInformation() {
		return winInformation;
	}

	public void setWinInformation(String winInformation) {
		this.winInformation = winInformation;
	}

	public String getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(String graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getEmploymentUnit() {
		return employmentUnit;
	}

	public void setEmploymentUnit(String employmentUnit) {
		this.employmentUnit = employmentUnit;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

}
