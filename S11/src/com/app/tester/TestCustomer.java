package com.app.tester;

import java.util.Date;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.customer.SubscriptionPackages;
import com.app.utils.MenuHandler;
import static com.app.utils.CustomerValidationRules.validateCustomer;
import static com.app.utils.CustomerValidationRules.findCustomer;;

public class TestCustomer {

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            int index = 0;
            // dynamic referenceArray initialization
            System.out.print("\nEnter number of Customers to register [int]: ");
            Customer[] customerArray = new Customer[sc.nextInt()];
            MenuHandler menu = new MenuHandler("Register Customer", "View Customers",
                    "Display Specific Customer Details", "Get Subscription", "Quit");

            do {
                try {
                    switch (menu.chooseOption()) {
                        case 1:
                            if (index < (customerArray.length)) {
                                System.out.print(
                                        "\nEnter name email password registrationAmount dateOfBirth paymentOption  [String String String double dd-MM-yyyy String]: ");
                                customerArray[index] = validateCustomer(sc.next(), sc.next(), sc.next(),
                                        sc.nextDouble(), sc.next(), sc.next(), customerArray);
                                index++;
                            } else
                                System.out.println("\nAll entries filled.");
                            break;
                        case 2:
                            for (Customer c : customerArray)
                                if (c != null)
                                    System.out.println(c);
                            break;
                        case 3:
                            System.out.print("\nEnter Customer Email: ");
                            System.out.println(findCustomer(sc.next(), customerArray));
                            break;
                        case 4:
                            System.out.print(
                                    "\nEnter Customer email, subscriptionPackage, durationInMonths [String String int]: ");
                            System.out.println(findCustomer(sc.next(), customerArray).subscribe(
                                    SubscriptionPackages.valueOf(sc.next().toUpperCase()), sc.nextInt(), new Date()));
                            break;
                        case 5:
                            quit = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    ;
                }
            } while (!quit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
