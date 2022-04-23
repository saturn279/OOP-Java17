package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate registrationDate;
	private String courseName;
	private ArrayList<Student> enrolledStudents;

	@Override
	public String toString() {
		return "Course [registrationDate=" + registrationDate + ", courseName=" + courseName + ", \n\tenrolledStudents="
				+ enrolledStudents + "]\n";
	}

	public Course(LocalDate registrationDate, String courseName) {
		super();
		this.registrationDate = registrationDate;
		this.courseName = courseName;
	}

	public void addStudent(Student student) throws Exception {
		if (enrolledStudents == null) {
			enrolledStudents = new ArrayList<Student>();
		}
		if (enrolledStudents.contains(student)) {
			throw new Exception("Student Already Enrolled.");
		} else if (registrationDate.isAfter(LocalDate.now())) {
			enrolledStudents.add(student);
			student.getCourseList().add(courseName);
			System.out.println("Student enrolled into " + courseName);
		} else {
			throw new Exception("Registration has passed, cannot enroll.");
		}
	}

	public ArrayList<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

}
