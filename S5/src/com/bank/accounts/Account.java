package com.bank.accounts;

public class Account {
    private double id;
    private String holderName;

    public Account(double id, String holderName) {
        this.id = id;
        this.holderName = holderName;
    }

    @Override
    public String toString() {
        return "Account [holderName=" + holderName + ", id=" + id + "]";
    }

   
}
