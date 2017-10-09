package com.example.austdiary;

public class DeptItem {

	private String DeptName;
	private int iconId;
	
	public DeptItem(String deptName, int iconId) {
		super();
		this.DeptName = deptName;
		this.iconId = iconId;
	}
	
	public String getDeptName() {
		return DeptName;
	}
	public int getIconId() {
		return iconId;
	}
}
