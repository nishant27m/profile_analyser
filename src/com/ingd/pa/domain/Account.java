package com.ingd.pa.domain;

import java.util.Date;
import java.util.List;

public class Account {

    private int accountId;

    private int customerId;

    private Date lastAccessDate;

    private double balance;

    public Account(int accountId, int customerId, Date lastAccessDate, double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.lastAccessDate = lastAccessDate;
        this.balance = balance;
    }

    private List<Transaction> transactions;

    public int getAccountId() {
        return accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getLastAccessDate() {
        return this.lastAccessDate;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

}
