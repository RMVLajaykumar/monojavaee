package com.monocept.entry;

public class Student {
	
	private int rollnumber;
	private String name;
	private int pecentage;
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPecentage() {
		return pecentage;
	}
	public void setPecentage(int pecentage) {
		this.pecentage = pecentage;
	}
	public Student(int rollnumber, String name, int pecentage) {
		super();
		this.rollnumber = rollnumber;
		this.name = name;
		this.pecentage = pecentage;
	}
	@Override
	public String toString() {
		return "Student [rollnumber=" + rollnumber + ", name=" + name + ", pecentage=" + pecentage + "]";
	}
	public Student(String name, int pecentage) {
		super();
		this.name = name;
		this.pecentage = pecentage;
	} 
	
	
	

}