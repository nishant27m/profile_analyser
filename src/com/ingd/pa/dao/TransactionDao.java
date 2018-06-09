package com.ingd.pa.dao;

import com.ingd.pa.domain.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * This class has implementation of Transaction Dao
 */
public class TransactionDao {

    /**
     * This method will return all transactions for given account id.
     * @param accountId account id
     * @return list of transactions.
     */
    public List<Transaction> getTransactions(int accountId) {
        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }

    /**
     * THis method will return all transactions for given account id and in given date range.
     * @param accountId account id
     * @param startDate start date
     * @param endDate end date
     * @return list of transactions.
     */
    public List<Transaction> getTransactions(int accountId, Date startDate, Date endDate) {
        List<Transaction> transactions = new ArrayList<>();
        return transactions;
    }

    /**
     * This method returns account balance as of date.
     * @param accountId account id
     * @param asofDate as of date
     * @return balance.
     */
    public double getBalance(int accountId, Date asofDate) {
        double balance = 0.0d;
        return balance;
    }

}
