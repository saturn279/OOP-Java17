package com.bank.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private double id;
    private String holderName;
    private Date transactionDate;
    private MembershipType membershipType;
    public static SimpleDateFormat sdf; 
    private static int index;
    static{
        sdf = new SimpleDateFormat("dd-MM-yyyy");
    }
    public Account(String holderName, Date transactionDate, MembershipType membershipType) {
        this.id = index++;
        this.holderName = holderName;
        this.transactionDate = transactionDate;
        this.membershipType = membershipType;
    }
    @Override
    public String toString() {
        return "Account [holderName=" + holderName + ", id=" + id + ", membershipType=" + membershipType
                + ", transactionDate=" + sdf.format(transactionDate) + "]";
    }

    
   
}
