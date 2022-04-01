package com.app.utils;

import java.util.Scanner;

public class MenuHandler {
    private String[] options;
    //var...args
    public MenuHandler(String...options) {
        this.options = options;
    }

    public void displayMenu() {
        System.out.println("\n...............Menu...............\n");
        for (int i = 1; i <= options.length; i++)
            System.out.print("\t" + i + ". " + options[i - 1] + "\n");

    }

    public int chooseOption() throws Exception {
        int option = options.length;
        
        Scanner sc = new Scanner(System.in);
        displayMenu();
        System.out.print("\n\t\tChoose option: ");
        try {
            option = sc.nextInt();
            if (option < 1 || option > options.length) {
               
                throw new IndexOutOfBoundsException();

            } else {
               
                return option;

            }
        } catch (Exception e) {

            System.out.println("Invalid option. Please choose from integer [" + 1 + "-" + options.length + "] ");

        }
              
        return -1;
    }

}
