package com.monocept.model;

public class Student {
	
	private int studentid;
	private String firstname;
	private String lastname;
	private String emailId;
	public Student(int studentid, String firstname, String lastname, String emailId) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstname=" + firstname + ", lastname=" + lastname + ", emailId="
				+ emailId + "]";
	}
	

}