package com.bank.accounts;

public class SavingAccount extends Account {
    private double savedBalance;

    public SavingAccount(String holderName, double savedBalance) {
        super(holderName);
        this.savedBalance = savedBalance;
   
    }

    public double getSavedBalance(){
        return savedBalance;
    }

    public boolean setSavedBalance(double savedBalance){
        if(savedBalance > 2000){
            this.savedBalance = savedBalance;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return super.toString()+" SavingAccount [savedBalance=" + savedBalance + "]";
    }

    
    

}
