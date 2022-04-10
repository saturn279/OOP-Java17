package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.Student;
import com.app.core.Subjects;

public interface CollectionUtils {

	/**
	 * returns List containing values of provided Map
	 * 
	 * @param Map<Integer,Student> studentMap
	 * @return List<Student>
	 * @throws Exception
	 */
	static List<Student> listFromMap(Map<Integer, Student> studentMap) throws Exception {
		List<Student> StudentArray = new ArrayList<Student>();
		studentMap.forEach((i, Student) -> StudentArray.add(Student));
		return StudentArray;
	}

	/**
	 * returns HashMap populated with Student Objects.
	 * 
	 * @param Map<Integer,Student> studentMap
	 * @return Map<Integer,Student> 
	 * @throws Exception
	 */
	static HashMap<Integer, Student> populateMap(HashMap<Integer, Student> studentMap){
		   
        studentMap.put(100,new Student(100, "ren", LocalDate.parse("1995-01-01"),Arrays.asList(Subjects.CC,Subjects.OOP), 5));
        studentMap.put(101,new Student(101, "anika", LocalDate.parse("1993-01-01"),Arrays.asList(Subjects.DV,Subjects.EC), 9));
        studentMap.put(102,new Student(102, "dev", LocalDate.parse("1991-01-01"),Arrays.asList(Subjects.LP,Subjects.EC), 7));
        studentMap.put(103,new Student(103, "arun", LocalDate.parse("1992-01-01"),Arrays.asList(Subjects.CC,Subjects.OOP), 8));
        studentMap.put(104,new Student(104, "rus", LocalDate.parse("1994-01-01"),Arrays.asList(Subjects.DV,Subjects.EC), 6));

		return studentMap;
     
	}

}
