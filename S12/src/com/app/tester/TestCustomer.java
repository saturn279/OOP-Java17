package com.app.tester;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.customer.SubscriptionPackages;
import com.app.utils.MenuHandler;
import static com.app.utils.CustomerValidationRules.*;

public class TestCustomer {

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            ArrayList<Customer> customerArray = new ArrayList<>();
            MenuHandler menu = new MenuHandler("Register Customer", "View Customers",
                    "Display Specific Customer Details", "Get Subscription", "Customer Login", "Change Password",
                    "Unsubscribe", "Delete Customer Account", "Quit");

            do {
                try {
                    switch (menu.chooseOption()) {
                        case 1:

                            System.out.print(
                                    "\nEnter name email password registrationAmount dateOfBirth paymentOption  [String String String double dd-MM-yyyy String]: ");
                            customerArray.add(validateCustomer(sc.next(), sc.next(), sc.next(),
                                    sc.nextDouble(), sc.next(), sc.next(), customerArray));

                            break;
                        case 2:
                            for (Customer c : customerArray)
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
                            System.out.print("\nEnter Customer Email, Password [String String]: ");
                            if (loginCustomer(sc.next(), sc.next(), customerArray))
                                System.out.println("Customer Logged In.");
                            break;
                        case 6:
                            System.out.print("\nEnter Customer Email oldPassword [String String]: ");
                            String email = sc.next();
                            if (loginCustomer(email, sc.next(), customerArray)){
                                System.out.print("\nEnter newPassword: ");
                                findCustomer(email, customerArray).setPasswordHash(validatePassword(sc.next()));
                                System.out.println("Password Updated.");
                            }
                            break;
                        case 7:
                            System.out.print("\nEnter Customer Email: ");
                            findCustomer(sc.next(), customerArray).unsubscribe();
                            System.out.println("Customer Unsubscribed.");
                            break;
                        case 8:
                            System.out.print("\nEnter Customer Email: ");
                            if (customerArray.remove(findCustomer(sc.next(), customerArray)))
                                System.out.println("Customer Account Deleted.");
                            break;
                        case 9:
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
