package com.acts.tester;

import com.acts.geometry.*;
import java.util.Scanner;

public class TestPointArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //create array of ref to class Point2D of user specified size
        System.out.print("\nNumber of points [int]:  ");
        int n = sc.nextInt();
        Point2D[] pa = new Point2D[n];

        //take x y coordinates of each point from user
        System.out.print("\nEnter points [x y x y...]: ");
        for (int i = 0; i < n; i++) {
            pa[i] = new Point2D(sc.nextDouble(), sc.nextDouble());
        }

        //print all points
        System.out.print("\nPoints: ");
        for (Point2D p : pa) {
            System.out.print("[ " + p.show() + " ]");
        }

        // check if points are unique
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pa[i].isEqual(pa[j])) {
                    System.out.print("\nPoints with index [" + i + "] and [" + j + "] are same.");
                }
            }
        }
        sc.close();
    }

}
