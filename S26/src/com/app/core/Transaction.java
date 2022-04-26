package com.app.core;

import java.time.LocalDate;

public class Transaction {

	private LocalDate transactionDate;
	private String narration;
	private double withdrawalAmount, depositAmount;
	
	public Transaction(LocalDate transactionDate, String narration, double withdrawalAmount, double depositAmount) {
		super();
		this.transactionDate = transactionDate;
		this.narration = narration;
		this.withdrawalAmount = withdrawalAmount;
		this.depositAmount = depositAmount;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", narration=" + narration + ", withdrawalAmount="
				+ withdrawalAmount + ", depositAmount=" + depositAmount + "]";
	}

	

}
