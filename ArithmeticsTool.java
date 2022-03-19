import java.util.Scanner;

public class ArithmeticsTool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "quit";
        double d1, d2;
        do {
            System.out.print("\nChoose options (quit|add|sub|mul|div|avg): ");
            input = sc.next();
            if ((input.equals("quit")))
                break;
            System.out.print("\nEnter 2 values[double]: ");
            if (sc.hasNextDouble())
                d1 = sc.nextDouble();
            else {
                System.out.println("Error: Only [double] accepted");
                break;
            }
            if (sc.hasNextDouble())
                d2 = sc.nextDouble();
            else {
                System.out.println("Error: Only [double] accepted");
                break;
            }
            System.out.print("\n\n--------------------------------------------------\n\n\t\t");
            switch (input) {
                case "add":
                    System.out.println(d1 + "+" + d2 + " = " + (d1 + d2));
                    break;
                case "sub":
                    System.out.println(d1 + "-" + d2 + " = " + (d1 - d2));
                    break;
                case "mul":
                    System.out.println(d1 + "*" + d2 + " = " + (d1 * d2));
                    break;
                case "div":
                    if (d2 == 0)
                        System.out.println("Cannot divide by zero");
                    else
                        System.out.println(d1 + "/" + d2 + " = " + (d1 / d2));
                    break;
                case "avg":
                    System.out.println("(" + d1 + "+" + d2 + ") / 2 = " + ((d1 + d2) / 2));
                    break;
            }
            System.out.print("\n--------------------------------------------------\n");
        } while (!(input.equals("quit")));
    }
}
