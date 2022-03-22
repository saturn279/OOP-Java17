package com.acts.geometry;

public class Point2D {
    private double x, y;

    public Point2D(double xc, double yc) {
        x = xc;
        y = yc;
    }

    public String show() {
        return x + " " + y;
    }

    public boolean isEqual(Point2D p2) {
        return (x == p2.x && y == p2.y) ? true : false;
    }

}