package com.app.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Course;
import com.app.core.Student;
import com.app.custom_exceptions.InvalidInputException;
import com.app.utils.IOUtils;

public class TestStudent {

	public static void main(String[] args) throws Exception {
		ArrayList<Student> studentList = IOUtils.getStudentsFromFile("Students.ser");
		HashMap<String, Course> courseMap = IOUtils.getCoursesFromFile("Courses.ser");

		Boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {

			do {
				try {

					System.out.println(
							"1.List all students\n2.List all courses\n3.Enroll Student into a Course\n4.List students by Course\n5.Register new student\n6.Save and Exit\n\tChoose option: ");
					switch (sc.nextInt()) {
					case 1:
						System.out.println(studentList);
						break;
					case 2:
						System.out.println(courseMap);
						break;
					case 3:
						System.out.println("Enter id and course name [int String]: ");
						int id = sc.nextInt();
						String course = sc.next();
						if (studentList.contains(new Student(id)))
							if (courseMap.containsKey(course))
								courseMap.get(course).addStudent(studentList.get(studentList.indexOf(new Student(id))));
							else
								throw new InvalidInputException("Course not found.");
						else
							throw new InvalidInputException("Student not found.");

						break;
					case 4:
						System.out.println("Enter course name [String]: ");
						System.out.println(courseMap.get(sc.next()).getEnrolledStudents());
						break;
					case 5:
						System.out.println("Enter Student age, name [int String]: ");
						studentList.add(new Student(sc.nextInt(),sc.next()));
						System.out.println("Student registered.");
						break;
					case 6:
						IOUtils.saveStudentsIntoFile(studentList, "Students.ser");
						IOUtils.saveCoursesIntoFile(courseMap, "Courses.ser");
						exit = true;

					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
			} while (!exit);
		}
	}
}
