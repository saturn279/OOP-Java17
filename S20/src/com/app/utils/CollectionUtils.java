package com.app.utils;

import java.util.HashMap;

import com.app.core.Courses;
import com.app.core.Student;
import com.app.custom_exceptions.StudentNotFound;

public class CollectionUtils {

	
	public static HashMap<Integer,Student> populateHashMap() {
		HashMap<Integer,Student> studentMap = new HashMap<Integer,Student>();
		studentMap.put(0, new Student(0,95,234223,"ren@.com","ren",Courses.valueOf("DITISS")));
		studentMap.put(1, new Student(1,98,234567,"sam@.com","sam",Courses.valueOf("MSD")));
		studentMap.put(2, new Student(2,85,234866,"deb@.com","deb",Courses.valueOf("SSA")));
		studentMap.put(3, new Student(3,56,234358,"ron@.com","ron",Courses.valueOf("SSA")));
		studentMap.put(4, new Student(4,96,234683,"kim@.com","kim",Courses.valueOf("MSD")));
		return studentMap;
	}
	
	public static Student getStudentByEmail(HashMap<Integer,Student> studentMap, String email) throws StudentNotFound {
		
		for(int i: studentMap.keySet()) {
			if(studentMap.get(i).getEmail().equals(email)) {
				return studentMap.get(i);
			}
		}
		throw new StudentNotFound();
		
	}

}
