package com.app.test;

import java.util.Scanner;
import com.app.custom_exceptions.InvalidEmployeeId;
import com.app.org.Employee;
import com.app.org.Manager;
import com.app.org.Worker;
import com.app.utils.MenuHandler;

public class TestOrganization {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		int index = 0;
		// dynamic referenceArray initialization
		System.out.print("\nEnter number of employees to hire [int]: ");

		Employee[] employeeArray = new Employee[sc.nextInt()];
		String[] options = {"Hire Manager","Hire worker","List All Employees","Update basic salary","getPerformanceBonus [Manager]","getHourlyRate [Worker]","Quit"};
		MenuHandler menu = new MenuHandler(options);
		do {
			//System.out.println();	 
			switch (menu.chooseOption()) {
			case 1:
				// upcasting
				if (index < (employeeArray.length)) {
					System.out.print("\nEnter name, deptId, basic, performanceBonus[String String double double]: ");
					employeeArray[index++] = new Manager(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
				} else
					System.out.println("\nAll positions filled.");
				break;
			case 2:
				// upcasting
				if (index < (employeeArray.length)) {
					System.out.print(
							"\nEnter name, deptId, basic, hoursWorker, hourlyRate[String String double double double]: ");
					employeeArray[index++] = new Worker(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(),
							sc.nextDouble());
				} else
					System.out.println("\nAll positions filled.");
				break;
			case 3:
				System.out.print("\n--------------------------------------------------\n\n");
				for (Employee e : employeeArray) {
					if (e != null) {
						// JVM calls toString() of relevant object
						System.out.println(e);
					}
				}
				System.out.print("\n--------------------------------------------------\n");
				break;
			case 4: 
				System.out.print("\nEnter empId, increament[int double]: ");
				int id = sc.nextInt();
				//custom exception
				try {
					if (id >= 0 && id < employeeArray.length) {
						employeeArray[id].setBasic(employeeArray[id].getBasic() + sc.nextDouble());
						System.out.println("basic updated. \n"+employeeArray[id]);
					}
					else{ 
						sc.next();
					throw new InvalidEmployeeId("You entered invalid id [" + id + "]");   
					}  
				} catch (InvalidEmployeeId e) {
					System.out.println(e.getMessage());
				}
				 
					
				break;
			case 5:				
				System.out.print("\nEnter Manager empId [int]: ");
				int mId = sc.nextInt();
				if(employeeArray[mId] instanceof Manager)  
					// downcasting
					System.out.println("performanceBonus "+((Manager)employeeArray[mId]).getPerformanceBonus());
				else
					System.out.println("Wrong employee id [" + mId + "]");
				break;

			case 6:				
				System.out.print("\nEnter Worker empId [int]: ");
				int wId = sc.nextInt();
				if(employeeArray[wId] instanceof Worker)
					// downcasting
					System.out.println("hourlyRate "+((Worker)employeeArray[wId]).getHourlyRate());
				else
					System.out.println("Wrong employee id [" + wId + "]");
				break;

			case 7:
				quit = true;
				break;
			}
		} while (!quit);
		sc.close();
	}

}
