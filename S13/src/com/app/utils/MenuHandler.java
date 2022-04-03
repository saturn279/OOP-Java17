package com.app.utils;

import java.util.Scanner;

import com.app.custom_exception.MenuHandlerException;

public class MenuHandler {
    private String[] options;

    // var...args
    public MenuHandler(String... options) {
        this.options = options;
    }

    public void displayMenu() {
        System.out.println("\n---------------Menu----------------\n");
        for (int i = 1; i <= options.length; i++)
            System.out.print("\t" + i + ". " + options[i - 1] + "\n");

    }

    /**
     * displays menu and takes option as input from user and returns it
     * 
     * @param sc
     * @return int
     * @throws Exception
     */
    public int chooseOption(Scanner sc) throws MenuHandlerException, Exception {
        int option = options.length;

        displayMenu();
        System.out.print("\n\t\tChoose option: ");
        if (sc.hasNextInt()) {
            option = sc.nextInt();
            if (option < 1 || option > options.length)
                throw new MenuHandlerException("Only values between [ " + 1 + "-" + options.length + " ] allowed.");
            else
                return option;

        } else {
            throw new MenuHandlerException(
                    "Only interger values between [ " + 1 + "-" + options.length + " ] allowed.");
        }

    }

}
