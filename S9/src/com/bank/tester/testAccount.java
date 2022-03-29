package com.bank.tester;

import static com.bank.accounts.Account.sdf;
import java.util.Scanner;
import com.bank.accounts.*;
import com.bank.utils.MenuHandler;
public class testAccount {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        boolean quit = false;
        int index = 0;
        // dynamic referenceArray initialization
        System.out.print("\nEnter number of accounts to create [int]: ");
        Account[] accountArray = new Account[sc.nextInt()]; 
        MenuHandler menu = new MenuHandler("Create LoanAccount","Create SavingAccount","List All Accounts","Quit");
        do {
            try{
            // menu to create and view accounts
               switch (menu.chooseOption()) {
                case 1:
                    // upcasting loadAccount to Account
                    if (index < (accountArray.length)) {
                        System.out.print("\nEnter holderName, loanBalance, membershipType, transactionDate [double String double string dd-MM-yyyy]: "); //parsing string-to-date and
                        accountArray[index++] = new LoanAccount(sc.next(), sc.nextDouble(),MembershipType.valueOf(sc.next().toUpperCase()),sdf.parse(sc.next())); //evaluate string to enum
                    } else
                        System.out.println("\nAll entries filled.");
                    break;
                case 2:
                    // upcasting savingAccount to Account
                    if (index < (accountArray.length)) {
                        System.out.print("\nEnter holderName, savedBalance, membershipType, transactionDate [double String double string dd-MM-yyyy]: "); //parsing string-to-date
                        accountArray[index++] = new SavingAccount(sc.next(), sc.nextDouble(),MembershipType.valueOf(sc.next().toUpperCase()),sdf.parse(sc.next())); //evaluate string to enum
                    } else
                        System.out.println("\nAll entries filled.");
                    break;
                case 3:
                    System.out.print("\n--------------------------------------------------\n\n");
                    for (Account p : accountArray) {
                        if (p != null) {
                            // JVM calls toString() of relevant object
                            System.out.println(p);
                        }
                    }
                    System.out.print("\n--------------------------------------------------\n");
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        } while (!quit);
        sc.close();
    }
}
