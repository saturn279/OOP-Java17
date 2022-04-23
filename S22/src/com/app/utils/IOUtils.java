package com.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.app.core.Course;
import com.app.core.Student;
import com.app.core.Student;

public class IOUtils {

	public static void saveStudentsIntoFile(ArrayList<Student> studentList, String fileName) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));) {
			out.writeObject(studentList);
		}
	}

	public static void saveCoursesIntoFile(HashMap<String, Course> courseMap, String fileName) throws Exception {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));) {
			out.writeObject(courseMap);
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Student> getStudentsFromFile(String fileName) throws Exception {
		File studentsFile = new File(fileName);
		if (studentsFile.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(studentsFile))) {
				ArrayList<Student> StudentList = new ArrayList<Student>();
				for (Student p : (ArrayList<Student>) in.readObject()) {
					StudentList.add(new Student(p.getAge(),p.getName(),p.getCourseList()));
				}
				return StudentList;
			}
		}
		return new ArrayList<Student>();
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, Course> getCoursesFromFile(String fileName) throws Exception {
		File coursesFile = new File(fileName);
		if (coursesFile.exists()) {
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(coursesFile))) {
				return (HashMap<String, Course>) in.readObject();
			}
		}
		return new HashMap<String, Course>();
	}
}