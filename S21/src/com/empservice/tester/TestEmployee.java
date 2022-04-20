package com.empservice.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.empservice.core.Departments;
import com.empservice.core.Employee;
import com.empservice.custom_exception.InvalidEmployeeDetails;
import com.empservice.utils.EmployeeValidations;

public class TestEmployee {

	
	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("deb", LocalDate.parse("1980-12-11") ,LocalDate.parse("2011-11-21") , 100, Departments.valueOf("HR")));
		employeeList.add(new Employee("ren", LocalDate.parse("1980-12-11") ,LocalDate.parse("2011-11-21") , 100, Departments.valueOf("HR")));
		employeeList.add(new Employee("kim", LocalDate.parse("1980-12-11") ,LocalDate.parse("2011-11-21") , 100, Departments.valueOf("HR")));

		
		Boolean exit=false;
		try(Scanner sc = new Scanner(System.in)){
		do {
			try {
				
				System.out.println("\n1.Add new Employee\n2.View Employee by id\n3.View all Employees\n4.Delete Employee\n5.Exit\n\tChoose option: ");
				switch(sc.nextInt()) {
				case 1:
					System.out.println("Enter employee name, dob, hireDate, salary, department [String yyyy-MM-dd yyyy-MM-dd double String]: ");
					employeeList.add(EmployeeValidations.validateEmployee(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(),employeeList));
					System.out.println("Employee added.");
					break;
				
				case 2:
					System.out.println("Enter Employee id: ");
					int id = sc.nextInt();
					employeeList.parallelStream().filter(emp->emp.getId() == id). forEach(emp->System.out.println(emp));
					
					break;
					
				case 3:
					System.out.println(employeeList);
					break;
				case 4:
					System.out.println("Enter Employee id: ");
					int idToDelete = sc.nextInt();
					if(employeeList.removeIf(emp->emp.getId()==idToDelete)) {
						System.out.println("Employee Removed.");
					}else {
						throw new InvalidEmployeeDetails("Employee with given id not found.");
					}
					break;
					
				case 5:
					exit =true;
					break;
				
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
			sc.nextLine();
			
		}while(!exit);
		
		}
	}
}
