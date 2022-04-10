package com.app.tester;

import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Student;
import com.app.utils.SaveByDOB;
import com.app.utils.SaveByGPA;
import static com.app.utils.CollectionUtils.populateMap;

public class TestStudent {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // populates studentMap with dummy values
            HashMap<Integer, Student> studentMap = populateMap(new HashMap<Integer, Student>());

            // Initilizes threads with studentMap.
            Thread gpa = new Thread(new SaveByGPA(studentMap), "GPA Thread");
            Thread dob = new Thread(new SaveByDOB(studentMap), "DOB Thread");

            // Starts threads which sort and store studentMap values.
            gpa.start();
            dob.start();
            gpa.join();
            dob.join();

            // Execution ends with main
            System.out.println("Data exported.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
