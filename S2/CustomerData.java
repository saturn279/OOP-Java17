package S2;
import java.util.Scanner;

public class CustomerData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer data (FirstName Email Age CreditLimit): ");
        Customer c = new Customer();
        c.set(sc.next(), sc.next(), sc.nextInt(), sc.nextDouble());
        c.get();
        sc.close();
    }

}

class Customer {
    private double creditLimit;
    private String name, email;
    private int age;

    void set(String n, String e, int a, double c) {
        if (a > 21 && a < 61 && c < 50000 && c > 5000) {
            name = n;
            email = e;
            age = a;
            creditLimit = c;
        } else
            System.out.println("Error: Invalid inputs");
    }

    void get() {
        System.out.println("---------Customer Data----------");
        System.out.println(
                "First Name: " + name + "\nEmail: " + email + "\nAge: " + age + "\nCredit Limit: " + creditLimit);
    }
}
