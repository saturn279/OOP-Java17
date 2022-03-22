package S2;
import java.util.Scanner;

public class GeometryTool {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dimenstions for Box (L B H): ");
        Box b1;
        b1 = new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println("Dimensions : " + b1.getBoxDimensions());
        System.out.println("Volume:  " + b1.getBoxVolume());

        System.out.print("Enter dimensions for Cude (S): ");
        Cube c1;
        c1 = new Cube(sc.nextDouble());
        System.out.println("Dimensions : " + c1.getCubeDimensions());
        System.out.println("Volume:  " + c1.getCubeVolume());

        sc.close();
    }
}

class Box {
    private double length, breadth, height;

    Box(double l, double b, double h) {
        length = l;
        breadth = b;
        height = h;
    }

    String getBoxDimensions() {
        return length + " " + breadth + " " + height;
    }

    double getBoxVolume() {
        return length * breadth * height;
    }

    Boolean isEqual(Box b2) {
        return length == b2.length && breadth == b2.breadth && height == b2.height;
    }

}

class Cube {
    private double side;

    Cube(double s) {
        side = s;
    }

    String getCubeDimensions() {
        return " " + side + " " + side + " " + side;
    }

    double getCubeVolume() {
        return side * side * side;
    }

    Boolean isEqual(Cube c2) {
        return side == c2.side;
    }

}