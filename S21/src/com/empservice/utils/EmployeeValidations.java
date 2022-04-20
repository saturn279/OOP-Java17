package com.empservice.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.empservice.core.Departments;
import com.empservice.core.Employee;
import com.empservice.custom_exception.InvalidEmployeeDetails;

public class EmployeeValidations {

	public static Employee validateEmployee(String name, String dob, String hireDate, double salary, String department,
			ArrayList<Employee> employeeList) throws Exception {

		checkForDuplicates(name, dob, employeeList);
		return new Employee(name, validateDob(dob), validateHireDate(hireDate), salary, validateDepartment(department));
	}

	public static void checkForDuplicates(String name, String dob, ArrayList<Employee> employeeList) throws Exception {

		HashMap<Map<String, LocalDate>, Employee> employeeMap = new HashMap<>();
		employeeList.forEach(emp -> employeeMap.put((Map.of(emp.getName(), emp.getDob())), emp));
			//Alternative methods
			//System.out.println(employeeList.stream().filter(emp->emp.getName().equals(name) && emp.getDob().isEqual(LocalDate.parse(dob))).anyMatch(e->true));
			//System.out.println(employeeList.contains(new Employee(name,LocalDate.parse(dob))) );
		
		if (employeeMap.containsKey(Map.of(name, LocalDate.parse(dob)))) {
			throw new InvalidEmployeeDetails("Employee already registered.");
		}
	}

	public static LocalDate validateDob(String dob) throws Exception {
		try {
			LocalDate dateOfBirth = LocalDate.parse(dob);
			if (dateOfBirth.isAfter(LocalDate.parse("1990-05-05"))) {
				throw new InvalidEmployeeDetails("Invalid employee age.");
			} else
				return dateOfBirth;
		} catch (DateTimeParseException e) {
			throw new InvalidEmployeeDetails("Date of birth in wrong format. [yyyy-MM-dd]");
		}
	}

	public static LocalDate validateHireDate(String hireDateString) throws Exception {
		try {
			LocalDate hireDate = LocalDate.parse(hireDateString);
			if (hireDate.isAfter(LocalDate.now())) {
				throw new InvalidEmployeeDetails("Hire date after today.");
			} else
				return hireDate;
		} catch (DateTimeParseException e) {
			throw new InvalidEmployeeDetails("Hire Date in wrong format. [yyyy-MM-dd]");
		}
	}

	public static Departments validateDepartment(String dept) throws Exception {
		try {
			return Departments.valueOf(dept.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new InvalidEmployeeDetails("Department named " + dept + " not found.");
		}
	}
}
