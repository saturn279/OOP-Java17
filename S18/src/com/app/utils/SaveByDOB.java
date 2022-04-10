package com.app.utils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.core.Student;
import static com.app.utils.IOUtils.storeStudentDetails;
import static com.app.utils.CollectionUtils.listFromMap;

public class SaveByDOB implements Runnable {

    private Map<Integer, Student> studentMap;

    public SaveByDOB(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public void run() {
        try {
            Comparator<Student> SortByDOB = (studentI, studentJ) -> studentI.getDob().compareTo(studentJ.getDob());
            // sorts list by date of birth
            List<Student> studentsSortedByDOB = listFromMap(studentMap).stream().sorted(SortByDOB)
                    .collect(Collectors.toList());

            // stores list into file
            storeStudentDetails(studentsSortedByDOB, "Students_dob.txt");
            System.out.println("Saved to Students_dob.txt by " + Thread.currentThread().getName());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
