package com.bank.accounts;

public class SavingAccount extends Account {
    private double savedBalance;

    public SavingAccount(double id, String holderName, double savedBalance) {
        super(id, holderName);
        this.savedBalance = savedBalance;
   
    }

    @Override
    public String toString() {
        return super.toString()+" SavingAccount [savedBalance=" + savedBalance + "]";
    }

    
    

}
