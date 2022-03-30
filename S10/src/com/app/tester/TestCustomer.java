package com.app.tester;

import java.util.Scanner;

import com.app.customer.Customer;
import com.app.utils.MenuHandler;
import static com.app.utils.CustomerValidationRules.validateCustomer;

public class TestCustomer {
    
    public static void main(String args[]) {
        try(Scanner sc = new Scanner(System.in)){
        boolean quit = false;
        int index = 0;
        // dynamic referenceArray initialization
        System.out.print("\nEnter number of Customers to register [int]: ");
        Customer[] customerArray = new Customer[sc.nextInt()]; 
        MenuHandler menu = new MenuHandler("Register Customer","View Customers","Quit");
        do {
            try{
               switch (menu.chooseOption()) {
                case 1:
                    if (index < (customerArray.length)) {
                        System.out.print("\nEnter name email password registrationAmount dateOfBirth paymentOption  [String String String double dd-MM-yyyy String]: "); 
                        customerArray[index] = validateCustomer(sc.next(),sc.next(),sc.next(), sc.nextDouble(),sc.next(),sc.next(),customerArray);
                        index++;
                    } else
                        System.out.println("\nAll entries filled.");
                    break;
                case 2:
                    for(Customer c: customerArray)
                        if(c!=null) System.out.println(c);
                        break;
                case 3:
                    quit = true;
                    break;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());;
        }
        } while (!quit);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
