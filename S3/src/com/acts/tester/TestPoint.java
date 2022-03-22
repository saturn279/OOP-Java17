package com.acts.tester;

import com.acts.geometry.*;
import java.util.Scanner;

public class TestPoint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter cooridnates for two points [x y x y]: ");
        Point2D p1 = new Point2D(sc.nextDouble(), sc.nextDouble());
        Point2D p2 = new Point2D(sc.nextDouble(), sc.nextDouble());
        System.out.println("Point: " + p1.show());
        System.out.println("Point: " + p2.show());
        System.out.println("Same point: " + p1.isEqual(p2));
        sc.close();
    }

}
