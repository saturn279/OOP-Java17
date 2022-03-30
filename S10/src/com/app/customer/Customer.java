package com.app.customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    private String name, email, passwordHash;
    private double registrationAmount;
    private PaymentMethods paymentMethod;
    private Date dob;
    public static SimpleDateFormat sdf;
    public static Date minAgeDate;
    static {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            minAgeDate =  sdf.parse("01-01-1999");
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
    }

    public Customer(String name, String email, String passwordHash, double registrationAmount,Date dob,
            PaymentMethods paymentMethod
            ) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registrationAmount = registrationAmount;
        this.paymentMethod = paymentMethod;
        this.dob = dob;
    }

    public Customer(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nCustomer [dob=" + sdf.format(dob) + ", email=" + email + ", name=" + name + ", passwordHash=" + passwordHash
                + ", paymentMethod=" + paymentMethod + ", registrationAmount=" + registrationAmount + "]";
    }

    @Override
    public boolean equals(Object vCustomer) {
        if (vCustomer instanceof Customer)
            return this.email.equals(((Customer) vCustomer).email);

        else
            return false;
    }

}
