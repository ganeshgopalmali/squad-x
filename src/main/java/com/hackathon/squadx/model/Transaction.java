package com.hackathon.squadx.model;

public class Transaction {

	public String AccountId;
	public String CreditDebitIndicator;
	public Amount Amount;
	public Balance Balance;
	public String TransactionInformation;
	
	public Balance getBalance() {
		return Balance;
	}
	public void setBalance(Balance balance) {
		Balance = balance;
	}
	public String getTransactionInformation() {
		return TransactionInformation;
	}
	public void setTransactionInformation(String transactionInformation) {
		TransactionInformation = transactionInformation;
	}
	public String getAccountId() {
		return AccountId;
	}
	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	public String getCreditDebitIndicator() {
		return CreditDebitIndicator;
	}
	public void setCreditDebitIndicator(String creditDebitIndicator) {
		CreditDebitIndicator = creditDebitIndicator;
	}
	public Amount getAmount() {
		return Amount;
	}
	public void setAmount(Amount amount) {
		Amount = amount;
	}
	
}
