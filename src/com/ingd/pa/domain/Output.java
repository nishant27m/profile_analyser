package com.ingd.pa.domain;

import java.util.List;
import java.util.Set;

public class Output {

    /**
     * customer classifications.
     */
    private Set<Classification> classifications;

    /**
     * list of transaction.
     */
    private List<Transaction> transactions;

    /**
     * balance
     */
    private double balance;

    public Set<Classification> getClassifications() {
        return classifications;
    }

    public void setClassifications(Set<Classification> classifications) {
        this.classifications = classifications;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
