package com.app.tester;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.app.core.Transaction;
import com.app.utils.IOUtils;

public class TestTransaction {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ArrayList<Transaction> transactionList = IOUtils.getFromFile("March2022.txt");
			//Uncomment one by one to check out different custom exceptions
			//ArrayList<Transaction> transactionList = IOUtils.getFromFile("March2022InvalidTransactionAmount.txt");
			//ArrayList<Transaction> transactionList = IOUtils.getFromFile("March2022InvalidTransactionDate1.txt");
			//ArrayList<Transaction> transactionList = IOUtils.getFromFile("March2022InvalidTransactionDate2.txt");

			if(transactionList.isEmpty()) 
				throw new Exception("No valid data was read from the input file.");
			
			else {
				double maxWithdrawal = 
						  transactionList.stream()
												.mapToDouble(t -> t.getWithdrawalAmount())
												.max()
												.getAsDouble();

				
				
				
				System.out.println("Sum of all deposits = "
						+ transactionList.stream()
												.mapToDouble(t -> t.getDepositAmount())
												.sum());

				
				
				
				System.out.println("Max deposit amount= " 
						+ transactionList.stream()
												.mapToDouble(t -> t.getDepositAmount())
												.max()
												.getAsDouble());

				
				
				System.out.println("Date on which max amount withdrawn= "
						+ transactionList.stream()
												.filter(t -> t.getWithdrawalAmount() == maxWithdrawal)
												.map(t -> (t.getTransactionDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
												.collect(Collectors.toList()).get(0));
				
				
				
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

}
