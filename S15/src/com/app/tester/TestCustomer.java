package com.app.tester;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import com.app.customer.Customer;
import com.app.customer.SubscriptionPackages;
import com.app.utils.MenuHandler;
import static com.app.utils.CustomerValidationRules.*;
import com.app.custom_exception.InvalidCustomerDetails;
import static com.app.utils.FileHandler.*;

public class TestCustomer {

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            HashMap<String, Customer> customerMap = new HashMap<>();
            MenuHandler menu = new MenuHandler("Register Customer", "View Customers",
                    "Display Specific Customer Details", "Get Subscription", "Customer Login", "Change Password",
                    "Unsubscribe", "Delete Customer Account", "Save data to file(binary)",
                    "Retrieve data from file(binary)", "Export in readable format", "Quit");

            do {
                try {
                    switch (menu.chooseOption(sc)) {
                        case 1:
                            System.out.print("\nEnter Customer email: ");
                            String email = validateEmail(sc.next(), customerMap);
                            System.out.print(
                                    "\nEnter name password registrationAmount dateOfBirth paymentOption  [String String String double yyyy-MM-dd String]: ");

                            customerMap.putIfAbsent(email, validateCustomer(sc.next(), email, sc.next(),
                                    sc.nextDouble(), sc.next(), sc.next(), customerMap));

                            break;
                        case 2:
                            System.out.println(customerMap.values());
                            break;
                        case 3:
                            System.out.print("\nEnter Customer Email: ");
                            System.out.println(customerMap.get(validateEmail(sc.next(), customerMap)));

                            break;
                        case 4:
                            System.out.print(
                                    "\nEnter Customer email, subscriptionPackage, durationInMonths [String String int]: ");
                            String emailForSubscription = sc.next();
                            if (customerMap.containsKey(emailForSubscription))
                                System.out.println(customerMap.get(emailForSubscription).subscribe(
                                        SubscriptionPackages.valueOf(sc.next().toUpperCase()), sc.nextInt(),
                                        LocalDateTime.now()));
                            break;
                        case 5:
                            System.out.print("\nEnter Customer Email, Password [String String]: ");
                            if (loginCustomer(sc.next(), sc.next(), customerMap))
                                System.out.println("\nCustomer Logged In.");
                            else
                                throw new InvalidCustomerDetails("Incorrect login details");
                            break;
                        case 6:
                            System.out.print("\nEnter Customer Email oldPassword [String String]: ");
                            String emailForPasswordChange = sc.next();
                            if (loginCustomer(emailForPasswordChange, sc.next(), customerMap)) {
                                System.out.print("\nEnter newPassword: ");
                                customerMap.get(emailForPasswordChange).setPasswordHash(validatePassword(sc.next()));
                                System.out.println("\nPassword Updated.");
                            }
                            break;
                        case 7:
                            System.out.print("\nEnter Customer Email: ");
                            String emailForUnsubscription = sc.next();
                            if (customerMap.containsKey(validateEmail(emailForUnsubscription, customerMap))) {
                                customerMap.get(emailForUnsubscription).unsubscribe();
                                System.out.println("\nCustomer Unsubscribed.");
                            } else
                                throw new InvalidCustomerDetails("Account associated with email not found.");

                            break;
                        case 8:
                            System.out.print("\nEnter Customer Email: ");
                            if (customerMap.remove(validateEmail(sc.next(), customerMap)) != null)
                                System.out.println("\nCustomer Account Deleted.");
                            else
                                throw new InvalidCustomerDetails("Account associated with email not found.");
                            break;
                        case 9:
                            System.out.print("\nEnter File Name:");
                            String fileNameForSaving = sc.next();
                            saveToFile(customerMap, fileNameForSaving);
                            System.out.println("Data saved to " + fileNameForSaving);
                            break;
                        case 10:
                            System.out.print("\nEnter File Name:");
                            String fileNameForRetrieving = sc.next();
                            customerMap = getFromFile(fileNameForRetrieving);
                            System.out.println("Data retrieved from " + fileNameForRetrieving);
                            break;
                        case 11:
                            System.out.print("\nEnter File Name:");
                            String fileNameForExporting = sc.next();
                            exportAsText(customerMap, fileNameForExporting);
                            System.out.println("Data exported as text to file " + fileNameForExporting);
                            break;
                        case 12:
                            quit = true;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    ;
                }
                sc.nextLine();
            } while (!quit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
