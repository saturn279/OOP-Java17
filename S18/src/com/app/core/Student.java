package com.app.core;

import java.time.LocalDate;
import java.util.List;

public class Student {
    private String name;
    private int id;
    private LocalDate dob;
    private List<Subjects> subjects;
    private double gpa;

    public Student(int id, String name, LocalDate dob, List<Subjects> subjectsList, double gpa) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.subjects = subjectsList;
        this.gpa = gpa;
    }

    public LocalDate getDob() {
        return dob;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student [dob=" + dob + ", gpa=" + gpa + ", id=" + id + ", name=" + name + ", subjects=" + subjects
                + "]";
    }

}