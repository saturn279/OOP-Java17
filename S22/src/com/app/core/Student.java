package com.app.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id, age;
	private String name;
	private static int count;
	private List<String> courseList;

	public Student(int id) {
		this.id = id;
	}

	public Student(int age, String name) {
		super();
		this.id = count++;
		this.age = age;
		this.name = name;
		courseList = new ArrayList<String>();
	}

	public Student(int age, String name, List<String> courseList) {
		super();
		this.id = count++;
		this.age = age;
		this.name = name;
		this.courseList =courseList;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Student)
			return ((Student) obj).getId() == this.id;
		else
			return false;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public List<String> getCourseList() {
		return courseList;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", courseList=" + courseList + "]\n";
	}

}
