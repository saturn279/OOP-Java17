package com.app.org;

public class Worker extends Employee{
	private double hoursWorked,hourlyRate;

	
	public Worker(String name, String deptId, double basic, double hoursWorker, double hourlyRate) {
		super(name, deptId, basic);
		this.hoursWorked = hoursWorker;
		this.hourlyRate = hourlyRate;
	}


	@Override
	public String toString() {
		return super.toString()+" Worker [hoursWorker=" + hoursWorked + ", hourlyRate=" + hourlyRate + ", netSalary="+ getNetSalary() +  "]";
	}

	public double getNetSalary() {
		return getBasic()+(hourlyRate*hoursWorked);
	}
	public double getHourlyRate() {
		return hourlyRate;
	}


	

	
	
	



}