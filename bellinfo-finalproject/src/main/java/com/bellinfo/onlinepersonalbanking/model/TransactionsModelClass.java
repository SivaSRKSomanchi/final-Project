package com.bellinfo.onlinepersonalbanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class TransactionsModelClass {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
	@Column(name="fundsTransferred",nullable = false)
	@NotEmpty
	private String fundsTransferred;
	
	@Column(name="recipientName",nullable = false)
	@NotEmpty
	private String recipientName;
	
	@Column(name="payer",nullable = false)
	@NotEmpty
	private String payer;
	
	@Column(name="amount",nullable = false)

	private int amount;
	
	@Column(name="recipientAccountNumber",nullable = false)
	@NotEmpty
	private String recipientAccountNumber;
	
	@Column(name="payerAccountNumber",nullable = false)
	@NotEmpty
	private String payerAccountNumber;
	
	
	
	public TransactionsModelClass() {
		
	}

	public TransactionsModelClass(String fundsTransferred, String recipientName, String payer, int amount,
			String recipientAccountNumber, String payerAccountNumber) {
		this.fundsTransferred = fundsTransferred;
		this.recipientName = recipientName;
		this.payer = payer;
		this.amount = amount;
		this.recipientAccountNumber = recipientAccountNumber;
		this.payerAccountNumber = payerAccountNumber;
		
	}
	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getFundsTransferred() {
		return fundsTransferred;
	}

	public void setFundsTransferred(String fundsTransferred) {
		this.fundsTransferred = fundsTransferred;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRecipientAccountNumber() {
		return recipientAccountNumber;
	}

	public void setRecipientAccountNumber(String recipientAccountNumber) {
		this.recipientAccountNumber = recipientAccountNumber;
	}

	public String getPayerAccountNumber() {
		return payerAccountNumber;
	}

	public void setPayerAccountNumber(String payerAccountNumber) {
		this.payerAccountNumber = payerAccountNumber;
	}


	@Override
	public String toString() {
		return "TransactionsModelClass [transactionId=" + transactionId + ", fundsTransferred=" + fundsTransferred
				+ ", recipientName=" + recipientName + ", payer=" + payer + ", amount=" + amount
				+ ", recipientAccountNumber=" + recipientAccountNumber + ", payerAccountNumber=" + payerAccountNumber
				+ "]";
	}
}
