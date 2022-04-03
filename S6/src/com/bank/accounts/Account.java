package com.bank.accounts;

public class Account {
    private int id;
    private String holderName;
    private static int index;

    public Account(String holderName) {
        this.id = index++;
        this.holderName = holderName;
    }

    @Override
    public String toString() {
        return "Account [holderName=" + holderName + ", id=" + id + "]";
    }

   
}
