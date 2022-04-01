package com.app.utils;

import java.util.ArrayList;
import java.util.Date;

import com.app.custom_exception.InvalidCustomerDetails;
import com.app.customer.*;
import static com.app.utils.PasswordHash.generateHash;
import static com.app.customer.Customer.sdf;
import static com.app.customer.Customer.minAgeDate;

public class CustomerValidationRules {
    public static Customer validateCustomer(String name, String email, String password, double registrationAmount,
            String dob, String paymentMethod, ArrayList<Customer> customerArray) throws Exception {

        return new Customer(name, validateEmail(email, customerArray), validatePassword(password), registrationAmount,
                validateDateOfBirth(dob), PaymentMethods.valueOf(paymentMethod.toUpperCase()));

    }

    private static String validateEmail(String email, ArrayList<Customer> customerArray)
            throws InvalidCustomerDetails, Exception {
        if (email.contains("@") && email.endsWith(".com")) {
            if (customerArray.indexOf(new Customer(email)) != -1)
                throw new InvalidCustomerDetails("Email Id associated with existing account.");

            return email;
        } else
            throw new InvalidCustomerDetails("Invalid Email");

    }

    //checks if password follows validation rules and returns password's SHA-256 value
    public static String validatePassword(String password) throws InvalidCustomerDetails, Exception {
        if (password.length() >= 4 && password.length() <= 10) {
            return generateHash(password);
        } else
            throw new InvalidCustomerDetails("Invalid Password");
    }

    private static Date validateDateOfBirth(String dob) throws InvalidCustomerDetails, Exception {
        if (minAgeDate.after(sdf.parse(dob)))
            return sdf.parse(dob);
        else
            throw new InvalidCustomerDetails("Invalid Date of Birth");
    }

    //returns Customer object associated with email
    public static Customer findCustomer(String email, ArrayList<Customer> customerArray) throws InvalidCustomerDetails {
      Customer customerToFind = new Customer(email);
      int index = customerArray.indexOf(customerToFind);
        if (index == -1)
            throw new InvalidCustomerDetails("Customer associated with email not found");
        else{
            return customerArray.get(index);
        }
    }
    
    //finds Customer object associated with email, compares passwordHash and returns true if they're identical 
    public static boolean loginCustomer(String email, String password, ArrayList<Customer> customerArray) throws InvalidCustomerDetails, Exception {
        if (findCustomer(email, customerArray).getPasswordHash().equals(validatePassword(password))){
            return true;
        }
        else throw new InvalidCustomerDetails("Wrong password.");
    }

}
