package com.ingd.pa.domain;

import java.util.Set;

public class Output {

    /**
     * customer classifications.
     */
    private Set<Classification> classifications;

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


}
