package com.ingd.pa.dao;

import com.ingd.pa.domain.Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class implements CRUD operations for Account.
 */
public class AccountDao {

    /**
     * instance of transaction Dao.
     */
    private TransactionDao transactionDao = new TransactionDao();

    /**
     * This method returns list of accounts for given customer id.
     * @param customerId customer id.
     * @return list of accounts.
     */
    public List<Account> getAccounts(int customerId) {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setTransactions(transactionDao.getTransactions(account.getAccountId()));
        accounts.add(account);
        return accounts;
    }

    /**
     * This method returns list of accounts for given customer id with given date range.
     * @param customerId customer id.
     * @param startDate start date.
     * @param endDate end date.
     * @return list of accounts.
     */
    public List<Account> getAccounts(int customerId, Date startDate, Date endDate) {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setTransactions(transactionDao.getTransactions(account.getAccountId(), startDate, endDate));
        accounts.add(account);
        return accounts;
    }
}
