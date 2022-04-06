package com.app.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class PasswordHash {

    /**
     * returns SHA of String input in byte[] format
     * 
     * @param input
     * @return byte[]
     * @throws Exception
     */
    public static byte[] getSHA(String input) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Converts byte[] to String
     * 
     * @param hash
     * @return String
     */
    public static String toHexString(byte[] hash) {

        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    /**
     * Take String password and returns it SHA digest in String format
     * 
     * @param password
     * @return String
     * @throws Exception
     */
    public static String generateHash(String password) throws Exception {

        return toHexString(getSHA(password));

    }
}
