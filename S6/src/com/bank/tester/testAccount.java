package com.bank.tester;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

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
                    "\n 1.Create LoanAccount\n 2.Create SavingAccount \n 3.List All Accounts \n 4.Withdraw from savingAccount \n 5.Quit \n\tChoose option [int]: ");
            switch (sc.nextInt()) {
                case 1:
                    // upcasting loadAccount to Account
                    if (index < (accountArray.length)) {
                        System.out.print("\nEnter holderName, loanBalance [double String double]: ");
                        accountArray[index++] = new LoanAccount(sc.next(), sc.nextDouble());
                    } else
                        System.out.println("\nAll entries filled.");
                    break;
                case 2:
                    // upcasting savingAccount to Account
                    if (index < (accountArray.length)) {
                        System.out.print("\nEnter holderName, savedBalance [double String double]: ");
                        accountArray[index++] = new SavingAccount(sc.next(), sc.nextDouble());
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
                    System.out.print("\nEnter Id, amount to withdraw: ");
                    int id = sc.nextInt();
                    if(accountArray[id] instanceof SavingAccount?((SavingAccount)accountArray[id]).setSavedBalance(((SavingAccount)accountArray[id]).getSavedBalance()-sc.nextDouble())?true:false:false)
                    System.out.println("Amount withdrawn.");
                    else
                    System.out.println("Amount not withdrawn."));
                    break;
                case 5:
                    quit = true;
                    break;
            }
        } while (!quit);
        sc.close();
    }
}
