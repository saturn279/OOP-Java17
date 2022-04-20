package com.empservice.core;

import java.time.LocalDate;

public class Employee {
	// id(unique), name, dob, hireDate, salary and department
	private int id;
	private String name;
	private LocalDate dob,hireDate;
	private double salary;
	private Departments department;
	private static int count;
	public Employee(String name, LocalDate dob, LocalDate hireDate, double salary, Departments department) {
		super();
		this.id = count++;
		this.name = name;
		this.dob = dob;
		this.hireDate = hireDate;
		this.salary = salary;
		this.department = department;
	}
	public Employee(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) 
			return ((Employee)obj).getName().equals(this.name) && ((Employee)obj).getDob().isEqual(this.dob);
		return false;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", hireDate=" + hireDate + ", salary="
				+ salary + ", department=" + department + "]";
	}
	
	

}
