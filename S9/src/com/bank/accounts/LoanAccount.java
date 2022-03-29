package com.bank.accounts;

import java.util.Date;

public class LoanAccount extends Account {
    private double loanBalance;

    public LoanAccount(String holderName, double loanBalance, MembershipType membershipType, Date transactionDate) {
        super(holderName, transactionDate, membershipType);
        this.loanBalance = loanBalance;
       
    }

    @Override
    public String toString() {
        return super.toString()+" LoanAccount [loansBalance=" + loanBalance + "]";
    }
 
    

    

}
