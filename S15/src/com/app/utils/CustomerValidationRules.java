package com.app.utils;

import java.util.HashMap;

import com.app.custom_exception.InvalidCustomerDetails;
import com.app.customer.*;
import static com.app.utils.PasswordHash.generateHash;
import static java.time.LocalDate.parse;
import java.time.LocalDate;
public class CustomerValidationRules {

    /**
     * validates parameters and returns new customer object reference
     * 
     * @param name
     * @param email
     * @param password
     * @param registrationAmount
     * @param dob
     * @param paymentMethod
     * @param customerMap
     * @return Customer
     * @throws Exception
     */
    public static Customer validateCustomer(String name, String email, String password, double registrationAmount,
            String dob, String paymentMethod, HashMap<String, Customer> customerMap) throws Exception {

        return new Customer(name, validateEmail(email, customerMap), validatePassword(password), registrationAmount,
                validateDateOfBirth(dob), PaymentMethods.valueOf(paymentMethod.toUpperCase()));

    }

    /**
     * check if String is an email address
     * 
     * @param email
     * @param customerMap
     * @return String
     * @throws InvalidCustomerDetails
     * @throws Exception
     */
    public static String validateEmail(String email, HashMap<String, Customer> customerMap)
            throws InvalidCustomerDetails, Exception {
        if (email.contains("@") && email.endsWith(".com")) {
            return email;
        } else
            throw new InvalidCustomerDetails("Invalid Email");

    }

    /**
     * checks if password follows validation rules and returns password's SHA-256
     * value
     * 
     * @param password
     * @return String
     * @throws InvalidCustomerDetails
     * @throws Exception
     */
    public static String validatePassword(String password) throws InvalidCustomerDetails, Exception {
        if (password.length() >= 4 && password.length() <= 10) {
            return generateHash(password);
        } else
            throw new InvalidCustomerDetails("Invalid Password");
    }

    /**
     * Validates date of birth
     * 
     * @param dob
     * @return Date
     * @throws InvalidCustomerDetails
     * @throws Exception
     */
    private static LocalDate validateDateOfBirth(String dob) throws InvalidCustomerDetails, Exception {
        if (parse("1999-01-01").isAfter(parse(dob)))
            return parse(dob);
        else
            throw new InvalidCustomerDetails("Invalid Date of Birth");
    }

    /**
     * finds Customer object associated with email, compares passwordHash and
     * returns true if they're identical
     * 
     * @param email
     * @param password
     * @param CustomerMap
     * @return boolean
     * @throws InvalidCustomerDetails
     * @throws Exception
     */
    public static boolean loginCustomer(String email, String password, HashMap<String, Customer> CustomerMap)
            throws InvalidCustomerDetails, Exception {
        if (CustomerMap.containsKey(email))
            if (CustomerMap.get(email).getPasswordHash().equals(validatePassword(password)))
                return true;
            else
                throw new InvalidCustomerDetails("Wrong password.");
        return false;
    }

}
