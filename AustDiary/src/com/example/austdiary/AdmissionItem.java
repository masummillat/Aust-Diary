package com.example.austdiary;

public class AdmissionItem {

	private String AdmissionName;
	private int iconId;
    public AdmissionItem(String admissionName, int iconId) {
		super();
		this.AdmissionName= admissionName;
		this.iconId = iconId;
	}
	public String getAdmissionName() {
		return AdmissionName;
	}
	public int getIconId() {
		return iconId;
	}
}
