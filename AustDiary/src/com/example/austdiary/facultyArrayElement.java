package com.example.austdiary;

public class facultyArrayElement {
	private int icon;
    private String title;
    private String Designation;
    private String degrees;
    private String bio;
    private String mobailNumber;
    private String Email;
	public void setIcon(int icon) {
		this.icon = icon;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public void setMobailNumber(String mobailNumber) {
		this.mobailNumber = mobailNumber;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getIcon() {
		return icon;
	}
	public String getTitle() {
		return title;
	}
	public String getDesignation() {
		return Designation;
	}
	public String getDegrees() {
		return degrees;
	}
	public String getBio() {
		return bio;
	}
	public String getMobailNumber() {
		return mobailNumber;
	}
	public String getEmail() {
		return Email;
	}
	public facultyArrayElement(int icon, String title, String designation,
			String degrees, String bio, String mobailNumber, String email) {
		super();
		this.icon = icon;
		this.title = title;
		Designation = designation;
		this.degrees = degrees;
		this.bio = bio;
		this.mobailNumber = mobailNumber;
		Email = email;
	}
	
   
    
}
