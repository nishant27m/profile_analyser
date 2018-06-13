package com.ingd.pa.domain;

import java.util.Date;

public class Transaction {

    private int transactionId;

    private Date transactionDate;

    private Double amount;

    private int accountId;

    private TransactionType transactionType;

    public Transaction(int transactionId, Date transactionDate, double amount, int accountId, TransactionType transactionType) {
        this.transactionId = transactionId;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.accountId = accountId;
        this.transactionType = transactionType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public int getAccountId() {
        return accountId;
    }

}
