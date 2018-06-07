package com.ingd.pa.domain;

import java.util.Date;
import java.util.List;

public class Account {

    private int accountId;

    private Date lastAccessDate;

    private double balance;

    private List<Transaction> transactions;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public

}
