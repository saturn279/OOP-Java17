package com.app.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.core.Student;
import static com.app.utils.IOUtils.storeStudentDetails;
import static com.app.utils.CollectionUtils.listFromMap;

public class SaveByGPA implements Runnable {

    private Map<Integer, Student> studentMap;

    public SaveByGPA(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public void run() {
        try {
            Comparator<Student> SortByGPA = (studentI,
                    studentJ) -> (((Double) studentI.getGpa()).compareTo(studentJ.getGpa()));
            // sorts list by GPA
            List<Student> studentsSortedByGPA = listFromMap(studentMap).stream().sorted(SortByGPA)
                    .collect(Collectors.toList());

            // stores list into file
            storeStudentDetails(studentsSortedByGPA, "Students_gpa.txt");
            System.out.println("Saved to Students_gpa.txt by " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
