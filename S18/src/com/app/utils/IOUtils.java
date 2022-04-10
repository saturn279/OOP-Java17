package com.app.utils;

import java.io.PrintWriter;
import java.util.List;

import com.app.core.Student;

public interface IOUtils {

	/**
	 * Stores given list into file.
	 * 
	 * 
	 * @param List<Student> studentMap
	 * @param String        fileName
	 * @throws Exception
	 */
	static void storeStudentDetails(List<Student> studentMap, String fileName) throws Exception {
		try (PrintWriter out = new PrintWriter(fileName)) {
			studentMap.forEach((student) -> out.println(student));
		}
	}
}
