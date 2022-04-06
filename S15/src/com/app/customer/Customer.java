package com.app.customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer implements Serializable {
    private String name, email, passwordHash;
    private double registrationAmount;
    private PaymentMethods paymentMethod;
    private LocalDate dob;
    private Subscription subscription;

    public Customer(String name, String email, String passwordHash, double registrationAmount, LocalDate dob,
            PaymentMethods paymentMethod) {
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "\nCustomer [dob=" + dob + ", email=" + email + ", name=" + name + ", passwordHash="
                + passwordHash
                + ", paymentMethod=" + paymentMethod + ", registrationAmount=" + registrationAmount + "] "
                + (subscription == null ? " " : subscription);
    }

    
    /** compares this Customer object with Object vCustomer with email as primary key
     * @param vCustomer
     * @return boolean
     */
    @Override
    public boolean equals(Object vCustomer) {
        if (vCustomer instanceof Customer)
            return this.email.equals(((Customer) vCustomer).email);

        else
            return false;
    }


    private class Subscription {
        private SubscriptionPackages subscriptionPackage;
        private int durationInMonths;
        private LocalDateTime startingFromDate;

        public Subscription(SubscriptionPackages subscriptionPackage, int durationInMonths, LocalDateTime localDateTime) {
            this.subscriptionPackage = subscriptionPackage;
            this.durationInMonths = durationInMonths;
            this.startingFromDate = localDateTime;
        }

        @Override
        public String toString() {
            return "\nSubscription [durationInMonths=" + durationInMonths + ", startingFrom="
                    + startingFromDate
                    + ", subscriptionPackage=" + subscriptionPackage + "]";
        }

    }

    
    /** 
     * create, initializes inner class subscription object  
     * @param subscriptionPackage
     * @param durationInMonths
     * @param localDateTime
     * @return String
     */

    public String subscribe(SubscriptionPackages subscriptionPackage, int durationInMonths, LocalDateTime localDateTime) {
        this.subscription = new Subscription(subscriptionPackage, durationInMonths, localDateTime);
        return this.subscription.toString();
    }

    /**
     * sets inner class object reference of subscription to null, thus marking subscription object for GC
     */
    public void unsubscribe(){
        subscription = null;
    }
}
