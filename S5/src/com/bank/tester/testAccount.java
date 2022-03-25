package com.bank.tester;

import java.util.Scanner;
import com.bank.accounts.*;

public class testAccount {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        // dynamic referenceArray initialization
        System.out.print("\nEnter number of accounts to create [int]: ");
        Account[] accountArray = new Account[sc.nextInt()];

        do {
            // menu to create and view accounts
            System.out.print(
                    "\n 1.Create LoanAccount\n 2.Create SavingAccount \n 3.List All Accounts \n 4.Quit \n\tChoose option [int]: ");
            switch (sc.nextInt()) {
                case 1:
                    // upcasting loadAccount to Account
                    if (index < (accountArray.length)) {
                        System.out.print("\nEnter id, holderName, loanBalance [double String double]: ");
                        accountArray[index++] = new LoanAccount(sc.nextDouble(), sc.next(), sc.nextDouble());
                    } else
                        System.out.println("\nAll entries filled.");
                    break;
                case 2:
                    // upcasting savingAccount to Account
                    if (index < (accountArray.length)) {
                        System.out.print("\nEnter id, holderName, savedBalance [double String double]: ");
                        accountArray[index++] = new SavingAccount(sc.nextDouble(), sc.next(), sc.nextDouble());
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
        } while (!quit);
        sc.close();
    }
}
