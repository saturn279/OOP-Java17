package com.app.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import com.app.customer.Customer;

public class FileHandler {

    /**
     * gets customers as HashMap, file name and stores the object in that file.
     * 
     * @param customerMap
     * @param fileName
     */
    public static void saveToFile(HashMap<String, Customer> customerMap, String fileName) throws Exception {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));) {
            objectOutputStream.writeObject(customerMap);
        }
    }

    /**
     * gets file name and returns HashMap<String,Customer> type Object in that file.
     * 
     * @param fileName
     * @return HashMap<String,Customer>
     */
    @SuppressWarnings("unchecked")
    public static HashMap<String, Customer> getFromFile(String fileName) throws Exception {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (HashMap<String, Customer>) objectInputStream.readObject();
        }

    }

    
    /** 
     * Stores all customer objects data to text file
     * @param customerMap
     * @param fileName
     * @throws Exception
     */
    public static void exportAsText(HashMap<String, Customer> customerMap, String fileName) throws Exception {

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            printWriter.write(customerMap.toString());
        }
    }
}
