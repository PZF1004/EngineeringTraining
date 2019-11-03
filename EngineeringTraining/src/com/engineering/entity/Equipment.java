package com.engineering.entity;

public class Equipment {
	private String equipmentID;
	private String equipmentName;
	private int equipmentNumber;
	private String equipmentPlace;
	private String equipmentManager;
	private int equipmentPrice;
	private String equipmentStatus;
	private String introduction;
	private String equipmentTime;

	public Equipment() {
	}

	public Equipment(String equipmentID, String equipmentName, int equipmentNumber, int equipmentPrice,
			String equipmentStatus, String introduction, String equipmentTime) {
		super();
		this.equipmentID = equipmentID;
		this.equipmentName = equipmentName;
		this.equipmentNumber = equipmentNumber;
		this.equipmentPrice = equipmentPrice;
		this.equipmentStatus = equipmentStatus;
		this.introduction = introduction;
		this.equipmentTime = equipmentTime;
	}

	public Equipment(String equipmentID, String equipmentName, int equipmentNumber, String equipmentPlace,
			String equipmentManager, int equipmentPrice, String equipmentStatus, String introduction,
			String equipmentTime) {
		this.equipmentID = equipmentID;
		this.equipmentName = equipmentName;
		this.equipmentNumber = equipmentNumber;
		this.equipmentPlace = equipmentPlace;
		this.equipmentManager = equipmentManager;
		this.equipmentPrice = equipmentPrice;
		this.equipmentStatus = equipmentStatus;
		this.introduction = introduction;
		this.equipmentTime = equipmentTime;
	}

	public String getEquipmentPlace() {
		return equipmentPlace;
	}

	public void setEquipmentPlace(String equipmentPlace) {
		this.equipmentPlace = equipmentPlace;
	}

	public String getEquipmentManager() {
		return equipmentManager;
	}

	public void setEquipmentManager(String equipmentManager) {
		this.equipmentManager = equipmentManager;
	}

	public String getEquipmentStatus() {
		return equipmentStatus;
	}

	public void setEquipmentStatus(String equipmentStatus) {
		this.equipmentStatus = equipmentStatus;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getEquipmentTime() {
		return equipmentTime;
	}

	public void setEquipmentTime(String equipmentTime) {
		this.equipmentTime = equipmentTime;
	}

	public String getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getEquipmentNumber() {
		return equipmentNumber;
	}

	public void setEquipmentNumber(int equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}

	public int getEquipmentPrice() {
		return equipmentPrice;
	}

	public void setEquipmentPrice(int equipmentPrice) {
		this.equipmentPrice = equipmentPrice;
	}

}
