package com.hackathon.squadx.model;

public class TransactionsRequest {
	public String TransactionFromDateTime;
	public String TransactionToDateTime;
	
	public String getTransactionFromDateTime() {
		return TransactionFromDateTime;
	}
	public void setTransactionFromDateTime(String transactionFromDateTime) {
		TransactionFromDateTime = transactionFromDateTime;
	}
	public String getTransactionToDateTime() {
		return TransactionToDateTime;
	}
	public void setTransactionToDateTime(String transactionToDateTime) {
		TransactionToDateTime = transactionToDateTime;
	}
}
