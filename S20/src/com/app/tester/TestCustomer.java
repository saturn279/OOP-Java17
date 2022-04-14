package com.app.tester;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Courses;
import com.app.core.Student;
import com.app.custom_exceptions.InvalidInputException;
import com.app.custom_exceptions.StudentNotFound;

import static com.app.utils.CollectionUtils.*;

public class TestCustomer {

	public static void main(String[] args) {

		HashMap<Integer, Student> studentMap = populateHashMap();
		Boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			
			do {
				try {
					System.out.println("Choose option: ");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter course name: ");
						String course = sc.next();
						if (Courses.valueOf(course) == null) {
							throw new InvalidInputException("Invalid Course.");
						} else {
							studentMap.forEach((i, s) -> {
								if (s.getCourse().equals(Courses.valueOf(course)))
									System.out.println(s);
							});
						}
						break;

					case 2:
						System.out.println("Enter id: ");
						int id = sc.nextInt();
						if (studentMap.get(id) == null)
							throw new StudentNotFound();
						else {
							System.out.println("Enter marks, phoneNumber: ");
							studentMap.get(id).setMarks(sc.nextDouble());
							studentMap.get(id).setPhoneNumber(sc.nextInt());
							System.out.println("Marks and phoneNumber updated.");
						}

						break;
					case 3:
						System.out.println("Enter email : ");
						Boolean studentFound = false;
						String email = sc.next();
						for (int i : studentMap.keySet()) {
							if (studentMap.get(i).getEmail().equals(email)) {
								studentMap.remove(i);
								System.out.println("Student removed.");
								studentFound = true;
							}
						}
						if (!studentFound)
							throw new StudentNotFound();
						break;
					case 4:
						exit = true;
						break;
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while (!exit);
		}
	}
}


