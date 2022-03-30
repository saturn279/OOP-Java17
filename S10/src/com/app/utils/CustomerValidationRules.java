package com.app.utils;

import java.util.Date;

import com.app.custom_exception.InvalidCustomerDetails;
import com.app.customer.*;
import static com.app.utils.PasswordHash.generateHash;
import static com.app.customer.Customer.sdf;
import static com.app.customer.Customer.minAgeDate;

public class CustomerValidationRules {
    public static Customer validateCustomer(String name, String email, String password, double registrationAmount,
            String dob, String paymentMethod, Customer[] customerArray) throws Exception {

        return new Customer(name, validateEmail(email, customerArray), validatePassword(password), registrationAmount,
                validateDateOfBirth(dob), PaymentMethods.valueOf(paymentMethod.toUpperCase()));

    }

    private static String validateEmail(String email, Customer[] customerArray)
            throws InvalidCustomerDetails, Exception {
        if (email.contains("@") && email.endsWith(".com")) {
            Customer vCustomer = new Customer(email);
            for (Customer c : customerArray) {

                if (c != null ? c.equals(vCustomer) : false)
                    throw new InvalidCustomerDetails("Email Id associated with existing account.");
                
            }
            return email;
        } else
            throw new InvalidCustomerDetails("Invalid Email");

    }

    private static String validatePassword(String password) throws InvalidCustomerDetails, Exception {
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
}
