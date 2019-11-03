package com.engineering.entity;

public class Lab {
	private String labID;
	private String labName;
	private String labPlace;
	private String labTime;
	private String introduction;

	public Lab() {
	}

	public Lab(String labID, String labName, String labPlace, String labTime, String introduction) {
		super();
		this.labID = labID;
		this.labName = labName;
		this.labPlace = labPlace;
		this.labTime = labTime;
		this.introduction = introduction;
	}

	public String getLabID() {
		return labID;
	}

	public void setLabID(String labID) {
		this.labID = labID;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLabPlace() {
		return labPlace;
	}

	public void setLabPlace(String labPlace) {
		this.labPlace = labPlace;
	}

	public String getLabTime() {
		return labTime;
	}

	public void setLabTime(String labTime) {
		this.labTime = labTime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
