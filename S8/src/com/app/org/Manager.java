package com.app.org;

public class Manager extends Employee{
	private double performanceBonus;

	public Manager(String name, String deptId, double basic, double performanceBonus) {
		super(name, deptId, basic);
		this.performanceBonus = performanceBonus;
	}

	@Override
	public String toString() {
		return super.toString()+" Manager [performanceBonus=" + performanceBonus + ", netSalary=" + getNetSalary() + "]";
	}
	
	public double getNetSalary() {
		return getBasic()+performanceBonus;
	}

	public double getPerformanceBonus() {
		return performanceBonus;
	}


	

	
	
	



}