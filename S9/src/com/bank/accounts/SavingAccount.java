package com.bank.accounts;

import java.util.Date;

public class SavingAccount extends Account {
    private double savedBalance;

    public SavingAccount(String holderName, double savedBalance, MembershipType membershipType, Date transactionDate) {
        super(holderName, transactionDate, membershipType);
        this.savedBalance = savedBalance;
   
    }

    @Override
    public String toString() {
        return super.toString()+" SavingAccount [savedBalance=" + savedBalance + "]";
    }

    
    

}
