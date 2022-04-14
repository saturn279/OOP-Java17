package com.app.core;

public class Student {

	private int id, phoneNumber;
	private double marks;
	private String email,name;
	private Courses course;
	
	public Student() {
		super();
	}
	public Student(int id, int phoneNumber, double marks, String email, String name, Courses course) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.marks = marks;
		this.email = email;
		this.name = name;
		this.course = course;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", phoneNumber=" + phoneNumber + ", marks=" + marks + ", email=" + email
				+ ", name=" + name + ", course=" + course + "]";
	}
	public Courses getCourse() {
		return course;
	}
	public String getEmail() {
		return email;
	}
	
}
