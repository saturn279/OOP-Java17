package com.app.org;

public abstract class Employee{
	private int id;
	private static int index=0;
	private String name,deptId;
	private double basic;
	public Employee(String name, String deptId, double basic) {
		super();
		id=index++;
		this.name = name;
		this.deptId = deptId;
		this.basic = basic;
	}
	public double getBasic() {
		return basic;
	}


	public abstract double getNetSalary();
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", deptId=" + deptId + ", basic=" + basic + "]";
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}



}