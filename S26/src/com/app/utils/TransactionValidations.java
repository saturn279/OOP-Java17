package com.app.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.app.core.Transaction;
import com.app.custom_exceptions.InvalidTransactionAmount;
import com.app.custom_exceptions.InvalidTransactionDate;

public class TransactionValidations {

	/**
	 * Takes all the fields for transaction then parses and validates them.
	 * 
	 * @return validated Transaction object reference
	 */
	public static Transaction validateTransaction(String transactionDate, String narration, String withdrawalAmount,
			String depositAmount, int lineNumber) throws Exception {

		return new Transaction(validateTransactionDate(transactionDate, lineNumber), narration,
				validateAmount(withdrawalAmount, lineNumber), validateAmount(depositAmount, lineNumber));
	}

	
	
	/**
	 * @param Transaction date
	 * @param lineNumber in input file that may need corrections
	 * @return validated LocalDate
	 */
	public static LocalDate validateTransactionDate(String date, int lineNumber) throws Exception {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			if (LocalDate.parse(date, formatter).isAfter(LocalDate.now()))
				throw new InvalidTransactionDate("Transaction date " + date + " after today. Input file line number " + lineNumber);
			return LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			// Transforms generic DateTimeParseException to custom_exception
			throw new InvalidTransactionDate(
					"Invalid transaction date format in input file on line number " + lineNumber);
		}
	}

	
	
	/**
	 * @param Withdrawal or deposit amount
	 * @param lineNumber in input file that may need corrections
	 * @return validated parsed amount
	 */
	public static double validateAmount(String amount, int lineNumber) throws Exception {
		try {
			return Double.parseDouble(amount);
		} catch (NumberFormatException e) {
			// Transforms generic NumberFormatException to custom_exception
			throw new InvalidTransactionAmount(
					"Invalid amount " + amount + " in input file on line number " + lineNumber);
		}
	}
}
