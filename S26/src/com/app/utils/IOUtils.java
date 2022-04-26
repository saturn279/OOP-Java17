package com.app.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.app.core.*;

public class IOUtils {

	/**
	 * Reads the input file line by line and creates new object of transaction with
	 * each line of validated data
	 * 
	 * @param Name of input file
	 * @return a list of transactions created using data from the file
	 */
	public static ArrayList<Transaction> getFromFile(String fileName) throws Exception {
		File transactionFile = new File(fileName);
		if (transactionFile.exists()) {
			try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
				
				ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
				String line = br.readLine(); // field names
				line = br.readLine(); // transaction data
				int lineNumber = 2;
				
				
				while (line != null) {
					String[] transactionData = line.split(",");
					// validates and parses transaction data
					transactionList.add(TransactionValidations.validateTransaction(transactionData[0], transactionData[1], transactionData[2], transactionData[3], lineNumber++));
					line = br.readLine(); // reads next line of transaction data
				}
				
				
				return transactionList;
			}
		}
		return new ArrayList<Transaction>(); // returns empty List if file doesn't exist.
	}
}