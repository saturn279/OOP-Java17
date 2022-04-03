package com.bank.accounts;

public class LoanAccount extends Account {
    private double loanBalance;

    public LoanAccount( String holderName, double loanBalance) {
        super(holderName);
        this.loanBalance = loanBalance;
       
    }

    @Override
    public String toString() {
        return super.toString()+" LoanAccount [loansBalance=" + loanBalance + "]";
    }
 
    

    

}
