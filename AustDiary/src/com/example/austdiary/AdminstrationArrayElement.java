package com.example.austdiary;

public class AdminstrationArrayElement {
	
	private String Name;
	private String Designation;
	private String JobPosition;
	public AdminstrationArrayElement(String name, String designation,
			String jobPosition) {
		super();
		this.Name = name;
		this.Designation = designation;
		this.JobPosition = jobPosition;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public void setJobPosition(String jobPosition) {
		JobPosition = jobPosition;
	}
	public String getName() {
		return Name;
	}
	public String getDesignation() {
		return Designation;
	}
	public String getJobPosition() {
		return JobPosition;
	}
	
	
	
	

}
